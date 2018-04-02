import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Table, Column, AutoSizer, SortDirection, SortIndicator } from 'react-virtualized';
import { isNil } from 'ramda';
import { TextField } from 'office-ui-fabric-react/lib/TextField';

import { graveownerListSelector } from './graveowner-list-selector';
import { fetchGraveownerListAction } from './graveowner-list-actions';
import { debounce } from '../../core/util';

import styles from './graveowner-list-view.scss';

const colWidth = {
  SMALL: 50,
  MEDIUM: 100,
  LARGE: 150
};

const mapStateToProps = state => ({
  graveownerList: graveownerListSelector(state)
});

@connect(mapStateToProps)
class GraveownerListView extends Component {
  componentDidMount() {
    this.props.dispatch(fetchGraveownerListAction.trigger());
  }

  componentWillReceiveProps(nextProps) {
    const { sort } = this.props.graveownerList;
    const nextSort = nextProps.graveownerList.sort;

    if (sort !== nextSort && this.tableRef) {
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
    if (scrollTop < refHeight - 1000) {
      return;
    }

    const { page, totalPages, sort } = this.props.graveownerList;
    if (page < totalPages) {
      this.props.dispatch(fetchGraveownerListAction.trigger({ page: page + 1, sort }));
    }
  }

  handleTableNoRows = () => (
    // TODO i18n
    <div>No results</div>
  )

  handleTableSort = ({ sortBy, sortDirection }) => {
    const { graveowners = [] } = this.props.graveownerList;
    if (graveowners.length === 0) {
      return;
    }

    const sort = sortDirection === SortDirection.DESC ? `-${sortBy}` : sortBy;
    this.props.dispatch(fetchGraveownerListAction.trigger({ sort }));
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
    <div>
      {label}
      {sortBy === dataKey && <SortIndicator sortDirection={sortDirection} />}
      <TextField
        inputClassName={styles.tableHeaderColumnInput}
        onClick={(e) => { e.preventDefault(); e.stopPropagation(); }}
        onKeyDown={e => (e.keyCode === 13 || e.keyCode === 32) && e.stopPropagation()}
        onChanged={newValue => this.handleTableHeaderInputChange(dataKey, newValue)}
      />
    </div>
  )

  handleTableHeaderInputChange = debounce((dataKey, newValue) => {
    console.log('TableHeaderInputChange', dataKey, newValue);
  }, 750)

  render() {
    const { graveowners = [] } = this.props.graveownerList;
    const { sortBy, sortDirection } = this.buildTableSort();

    return (
      <div className={styles.graveownerList}>
        <AutoSizer>
          {({ width, height }) => (
            <Table
              ref={(ref) => { this.tableRef = ref; }}
              width={width}
              height={height}
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
                label="Id"
                dataKey="id"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="CNP"
                dataKey="cnp"
                width={colWidth.LARGE}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Nume"
                dataKey="nume"
                width={colWidth.LARGE}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Prenume"
                dataKey="prenume"
                width={colWidth.LARGE}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Localitate"
                dataKey="localitate"
                width={colWidth.MEDIUM}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Jud"
                dataKey="judet"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Str"
                dataKey="str"
                width={colWidth.LARGE}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Nr"
                dataKey="nr"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Bl"
                dataKey="bl"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Sc"
                dataKey="sc"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Et"
                dataKey="et"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
              <Column
                label="Ap"
                dataKey="ap"
                width={colWidth.SMALL}
                headerRenderer={this.inputHeaderRenderer}
              />
            </Table>
          )}
        </AutoSizer>
      </div>
    );
  }
}

export default GraveownerListView;
