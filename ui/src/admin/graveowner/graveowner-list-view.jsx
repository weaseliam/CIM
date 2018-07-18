import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Table, Column, AutoSizer, SortDirection, SortIndicator } from 'react-virtualized';
import { isNil, keys, equals } from 'ramda';
import { TextField } from 'office-ui-fabric-react/lib/TextField';

import { graveownerListSelector } from './graveowner-selector';
import { fetchGraveownerListAction } from './graveowner-actions';
import { debounce } from '../../core/util';
import withI18n from '../../i18n/i18n-hoc';
import * as i18nc from '../../i18n/i18n-constants';
import TableTitle from '../../components/table-title';

import styles from './graveowner-list-view.scss';

const colWidth = {
  XS: 50,
  S: 100,
  M: 150,
  L: 200,
  XL: 400
};

const mapStateToProps = state => ({
  graveownerList: graveownerListSelector(state)
});

@withI18n
@connect(mapStateToProps)
class GraveownerListView extends Component {
  constructor(props) {
    super(props);

    this.tableRef = null;
    this.tableInputRefs = {};
  }

  componentDidMount() {
    this.props.dispatch(fetchGraveownerListAction.trigger());
  }

  componentWillReceiveProps(nextProps) {
    const { sort, filter } = this.props.graveownerList;
    const nextSort = nextProps.graveownerList.sort;
    const nextFilter = nextProps.graveownerList.filter;

    if (sort !== nextSort || filter !== nextFilter) {
      this.tableRef.scrollToPosition(0);
    }
  }

  handleRowClassName = ({ index }) => {
    if (index < 0) {
      return styles.tableHeaderRow;
    }

    return index % 2 === 0
      ? styles.tableEvenRow
      : styles.tableOddRow;
  }

  handleTableScroll = ({ clientHeight, scrollHeight, scrollTop }) => {
    const refHeight = scrollHeight - clientHeight;
    const currentTime = (new Date()).getTime();
    const timeDiff = currentTime - (this.lastTime || 0);

    if (scrollTop < refHeight - 1000 || timeDiff < 1000) {
      return;
    }

    this.lastTime = currentTime;

    const { page, totalPages, sort, filter } = this.props.graveownerList;
    if (page < totalPages) {
      this.props.dispatch(fetchGraveownerListAction.trigger({ page: page + 1, sort, filter }));
    }
  }

  handleTableNoRows = () => {
    const { t } = this.props;
    return <div>{t(i18nc.GRAVEOWNER_LIST_TABLE_NO_RESULTS)}</div>;
  }

  handleTableSort = ({ sortBy, sortDirection }) => {
    const { graveowners = [], filter } = this.props.graveownerList;
    if (graveowners.length === 0) {
      return;
    }

    const sort = sortDirection === SortDirection.DESC ? `-${sortBy}` : sortBy;
    this.props.dispatch(fetchGraveownerListAction.trigger({ sort, filter }));
  }

  buildTableSort = () => {
    const { sort } = this.props.graveownerList;
    let sortBy = 'id';
    let sortDirection = SortDirection.ASC;

    if (!isNil(sort)) {
      sortDirection = sort.startsWith('-') ? SortDirection.DESC : SortDirection.ASC;
      sortBy = sort.startsWith('-') ? sort.substring(1) : sort;
    }

    return {
      sortBy,
      sortDirection
    };
  }

  inputHeaderRenderer = ({ dataKey, label, sortBy, sortDirection }) => (
    <div title={label}>
      {sortBy === dataKey && <SortIndicator sortDirection={sortDirection} />}
      {label}
      <TextField
        ref={(ref) => { this.tableInputRefs[dataKey] = ref; }}
        inputClassName={styles.tableHeaderColumnInput}
        onClick={(e) => { e.preventDefault(); e.stopPropagation(); }}
        onKeyDown={e => (e.keyCode === 13 || e.keyCode === 32) && e.stopPropagation()}
        onChanged={newValue => this.handleTableHeaderInputChange(dataKey, newValue)}
      />
    </div>
  )

  handleTableHeaderInputChange = debounce(() => {
    const { sort, filter } = this.props.graveownerList;

    // read values from UNCONTROLLED inputs
    const newFilter = this.readTableInputValues();

    // deep comparison
    if (!equals(filter, newFilter)) {
      this.props.dispatch(fetchGraveownerListAction.trigger({
        sort,
        filter: {
          ...filter,
          ...newFilter
        }
      }));
    }
  }, 750)

  handleTableTitleResetFilter = () => {
    const dataKeys = keys(this.tableInputRefs);
    let didReset = false;

    for (const dataKey of dataKeys) {
      const input = this.tableInputRefs[dataKey];
      if (input.value !== '') {
        // TODO find better solution for filter reset
        // implement as controlled component, do not couple state to this view
        /* eslint-disable no-underscore-dangle */
        input._latestValue = '';
        input._latestValidateValue = '';
        /* eslint-enable */
        input.state.value = '';
        didReset = true;
      }
    }

    if (didReset) {
      const { sort } = this.props.graveownerList;
      this.props.dispatch(fetchGraveownerListAction.trigger({ sort }));
    }
  }

  readTableInputValues = () => {
    const dataKeys = keys(this.tableInputRefs);
    const values = {};

    for (const dataKey of dataKeys) {
      let { value } = this.tableInputRefs[dataKey];
      value = value && value.trim();
      if (value === '') {
        value = null;
      }
      values[dataKey] = value;
    }

    return values;
  }

  render() {
    const { t } = this.props;
    const { graveowners = [], totalResults } = this.props.graveownerList;
    const { sortBy, sortDirection } = this.buildTableSort();

    return (
      <div className={styles.graveownerList}>
        <AutoSizer>
          {({ width, height }) => (
            <React.Fragment>
              <TableTitle
                results={totalResults || 0}
                width={width}
                height={30}
                onResetFilter={this.handleTableTitleResetFilter}
                i18n={{
                  results: t(i18nc.GRAVEOWNER_LIST_TABLE_TITLE_RESULTS),
                  resetFilter: t(i18nc.GRAVEOWNER_LIST_TABLE_TITLE_RESET_FILTER)
                }}
              />
              <Table
                ref={(ref) => { this.tableRef = ref; }}
                width={width}
                height={height - 30}
                headerHeight={65}
                rowHeight={35}
                headerClassName={styles.tableHeaderColumn}
                rowClassName={this.handleRowClassName}
                rowCount={graveowners.length}
                rowGetter={({ index }) => graveowners[index]}
                onScroll={this.handleTableScroll}
                noRowsRenderer={this.handleTableNoRows}
                sort={this.handleTableSort}
                sortBy={sortBy}
                sortDirection={sortDirection}
              >
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_ID)}
                  dataKey="id"
                  width={colWidth.S}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_CNP)}
                  dataKey="cnp"
                  width={colWidth.L}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_NUME)}
                  dataKey="nume"
                  width={colWidth.L}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_PRENUME)}
                  dataKey="prenume"
                  width={colWidth.L}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_LOC)}
                  dataKey="localitate"
                  width={colWidth.M}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_JUD)}
                  dataKey="judet"
                  width={colWidth.S}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_ADR)}
                  dataKey="adresa"
                  width={colWidth.XL}
                  headerRenderer={this.inputHeaderRenderer}
                />
              </Table>
            </React.Fragment>
          )}
        </AutoSizer>
      </div>
    );
  }
}

export default GraveownerListView;
