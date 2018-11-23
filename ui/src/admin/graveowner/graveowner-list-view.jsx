import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Table, Column, AutoSizer, SortDirection, SortIndicator } from 'react-virtualized';
import { isNil, keys, equals, filter as Rfilter } from 'ramda';
import { TextField } from 'office-ui-fabric-react/lib/TextField';

import { graveownerListSelector, graveownerSelectedIndexSelector } from './graveowner-selector';
import { fetchGraveownerListAction, setGraveownerListSelectedIndexAction } from './graveowner-actions';
import { debounce } from '../../core/util';
import withI18n from '../../i18n/i18n-decorator';
import * as i18nc from '../../i18n/i18n-constants';
import TableTitle from '../../components/table-title';
import { TABLE_COL_WIDTH } from '../../core/constants';
import { fetchContractListWithGravesAction } from '../contract/contract-actions';

import styles from './graveowner-list-view.scss';
import tableStyles from '../../styles/table-styles.scss';

const TABLE_TITLE_HEIGHT = 30;
const TABLE_HEADER_HEIGHT = 65;
const TABLE_ROW_HEIGHT = 35;

const mapStateToProps = state => ({
  graveownerList: graveownerListSelector(state),
  graveownerListSelectedIndex: graveownerSelectedIndexSelector(state)
});

@withI18n
@connect(mapStateToProps)
class GraveownerListView extends Component {
  constructor(props) {
    super(props);

    this.tableRef = null;
    this.tableInputValues = {};
  }

  componentDidMount() {
    this.props.dispatch(fetchGraveownerListAction.trigger());
  }

  componentWillReceiveProps(nextProps) {
    const { sort, filter } = this.props.graveownerList;
    const nextSort = nextProps.graveownerList.sort;
    const nextFilter = nextProps.graveownerList.filter;

    if (sort !== nextSort || !equals(filter, nextFilter)) {
      this.tableRef.scrollToPosition(0);
    }
  }

  handleRowClassName = ({ index }) => {
    if (index === -1) {
      return tableStyles.tableHeaderRow;
    }

    let className = index % 2 === 0
      ? tableStyles.tableEvenRow
      : tableStyles.tableOddRow;

    const { graveownerListSelectedIndex } = this.props;
    if (graveownerListSelectedIndex === index) {
      className = `${className} ${tableStyles.tableSelectedRow}`;
    }

    return className;
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

  handleRowClick = ({ index, rowData }) => {
    const { graveownerListSelectedIndex } = this.props;
    if (graveownerListSelectedIndex === index) {
      return;
    }

    this.props.dispatch(setGraveownerListSelectedIndexAction.success(index));
    this.props.dispatch(fetchContractListWithGravesAction.trigger({ graveownerId: rowData.id }));
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
        inputClassName={styles.tableHeaderColumnInput}
        onClick={e => e.stopPropagation() && e.preventDefault()}
        onKeyDown={e => (e.keyCode === 13 || e.keyCode === 32) && e.stopPropagation()}
        onChange={e => this.handleTableHeaderInputChange(dataKey, e)}
        value={this.tableInputValues[dataKey] || ''}
      />
    </div>
  )

  handleTableHeaderInputChange = debounce((dataKey, e) => {
    const { sort, filter } = this.props.graveownerList;

    this.updateTableHeaderInputValue(dataKey, e);
    const newFilter = this.tableInputValues;

    // deep comparison
    const isNotNil = val => !isNil(val);
    if (!equals(Rfilter(isNotNil, filter || {}), Rfilter(isNotNil, newFilter))) {
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
    const dataKeys = keys(this.tableInputValues);
    let didReset = false;

    for (const dataKey of dataKeys) {
      const value = this.tableInputValues[dataKey];
      if (value !== null) {
        didReset = true;
        this.tableInputValues = {};
        break;
      }
    }

    if (didReset) {
      const { sort } = this.props.graveownerList;
      this.props.dispatch(fetchGraveownerListAction.trigger({ sort }));
    }
  }

  updateTableHeaderInputValue = (dataKey, e) => {
    const { value = '' } = e.target;

    this.tableInputValues[dataKey] = value.trim() === ''
      ? null
      : value;
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
                height={TABLE_TITLE_HEIGHT}
                onResetFilter={this.handleTableTitleResetFilter}
                i18n={{
                  results: t(i18nc.GRAVEOWNER_LIST_TABLE_TITLE_RESULTS),
                  resetFilter: t(i18nc.GRAVEOWNER_LIST_TABLE_TITLE_RESET_FILTER)
                }}
              />
              <Table
                ref={(ref) => { this.tableRef = ref; }}
                className={tableStyles.table}
                headerClassName={tableStyles.tableHeaderColumn}
                rowClassName={this.handleRowClassName}
                width={width}
                height={height - TABLE_TITLE_HEIGHT}
                headerHeight={TABLE_HEADER_HEIGHT}
                rowHeight={TABLE_ROW_HEIGHT}
                rowCount={graveowners.length}
                rowGetter={({ index }) => graveowners[index]}
                noRowsRenderer={this.handleTableNoRows}
                sort={this.handleTableSort}
                sortBy={sortBy}
                sortDirection={sortDirection}
                onScroll={this.handleTableScroll}
                onRowClick={this.handleRowClick}
              >
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_ID)}
                  dataKey="id"
                  width={TABLE_COL_WIDTH.S}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_CNP)}
                  dataKey="cnp"
                  width={TABLE_COL_WIDTH.L}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_NUME)}
                  dataKey="nume"
                  width={TABLE_COL_WIDTH.L}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_PRENUME)}
                  dataKey="prenume"
                  width={TABLE_COL_WIDTH.L}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_LOC)}
                  dataKey="localitate"
                  width={TABLE_COL_WIDTH.M}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_JUD)}
                  dataKey="judet"
                  width={TABLE_COL_WIDTH.S}
                  headerRenderer={this.inputHeaderRenderer}
                />
                <Column
                  label={t(i18nc.GRAVEOWNER_LIST_TABLE_HEADER_ADR)}
                  dataKey="adresa"
                  width={TABLE_COL_WIDTH.XL}
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
