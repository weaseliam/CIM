import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Table, Column, AutoSizer, SortDirection } from 'react-virtualized';
import { isNil } from 'ramda';

import { graveownerListSelector } from './graveowner-list-selector';
import { fetchGraveownerListAction } from './graveowner-list-actions';
import style from './graveowner-list-view.scss';

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
      return style.tableHeaderRow;
    }

    return index % 2 === 0
      ? style.tableEvenRow
      : style.tableOddRow;
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

  handleNoRows = () => (
    // TODO i18n
    <div>No results</div>
  )

  handleSort = ({ sortBy, sortDirection }) => {
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

  render() {
    const { graveowners = [] } = this.props.graveownerList;
    const { sortBy, sortDirection } = this.buildTableSort();

    return (
      <div className={style.graveownerList}>
        <AutoSizer>
          {({ width, height }) => (
            <Table
              ref={(ref) => { this.tableRef = ref; }}
              width={width}
              height={height}
              headerHeight={25}
              rowHeight={35}
              headerClassName={style.tableHeaderColumn}
              rowClassName={this.handleRowClassName}
              rowCount={graveowners.length}
              rowGetter={({ index }) => graveowners[index]}
              onScroll={this.handleTableScroll}
              noRowsRenderer={this.handleNoRows}
              sort={this.handleSort}
              sortBy={sortBy}
              sortDirection={sortDirection}
            >
              <Column label="Id" dataKey="id" width={colWidth.SMALL} />
              <Column label="CNP" dataKey="cnp" width={colWidth.LARGE} />
              <Column label="Nume" dataKey="nume" width={colWidth.LARGE} />
              <Column label="Prenume" dataKey="prenume" width={colWidth.LARGE} />
              <Column label="Localitate" dataKey="localitate" width={colWidth.MEDIUM} />
              <Column label="Jud" dataKey="judet" width={colWidth.SMALL} />
              <Column label="Str" dataKey="str" width={colWidth.LARGE} />
              <Column label="Nr" dataKey="nr" width={colWidth.SMALL} />
              <Column label="Bl" dataKey="bl" width={colWidth.SMALL} />
              <Column label="Sc" dataKey="sc" width={colWidth.SMALL} />
              <Column label="Et" dataKey="et" width={colWidth.SMALL} />
              <Column label="Ap" dataKey="ap" width={colWidth.SMALL} />
            </Table>
          )}
        </AutoSizer>
      </div>
    );
  }
}

export default GraveownerListView;
