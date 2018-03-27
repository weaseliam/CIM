import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Table, Column, AutoSizer } from 'react-virtualized';

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

  handleRowClassName = ({ index }) => {
    if (index < 0) {
      return style.tableHeaderRow;
    }

    return index % 2 === 0
      ? style.tableEvenRow
      : style.tableOddRow;
  }

  render() {
    const { graveowners = [] } = this.props.graveownerList || {};

    return (
      <div className={style.graveownerList}>
        <AutoSizer>
          {({ width, height }) => (
            <Table
              width={width}
              height={height}
              headerHeight={25}
              rowHeight={35}
              headerClassName={style.tableHeaderColumn}
              rowClassName={this.handleRowClassName}
              rowCount={graveowners.length}
              rowGetter={({ index }) => graveowners[index]}
            >
              <Column label="Id" dataKey="id" width={colWidth.SMALL} />
              <Column label="CNP" dataKey="cnp" width={colWidth.LARGE} />
              <Column label="Nume" dataKey="nume" width={colWidth.LARGE} />
              <Column label="Prenume" dataKey="prenume" width={colWidth.LARGE} />
              <Column label="Localitate" dataKey="localitate" width={colWidth.MEDIUM} />
              <Column label="Judet" dataKey="judet" width={colWidth.SMALL} />
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
