import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Table, Column, AutoSizer } from 'react-virtualized';

import HeaderLoader from '../../components/header-loader';
import { graveownerListSelector, graveownerListLoadingSelector } from './graveowner-list-selector';
import { fetchGraveownerListAction } from './graveowner-list-actions';
import style from './graveowner-list-view.scss';

const colWidth = {
  SMALL: 50,
  MEDIUM: 100,
  LARGE: 160
};

const mapStateToProps = state => ({
  graveownerList: graveownerListSelector(state),
  loading: graveownerListLoadingSelector(state)
});

@connect(mapStateToProps)
class GraveownerListView extends Component {
  componentDidMount() {
    this.props.dispatch(fetchGraveownerListAction.trigger());
  }

  render() {
    const { graveowners = [] } = this.props.graveownerList || {};
    const { loading } = this.props;

    return (
      <div className={style.graveownerList}>
        <HeaderLoader loading={loading} />
        <AutoSizer>
          {({ width, height }) => (
            <Table
              width={width}
              height={height}
              headerHeight={20}
              rowHeight={30}
              rowCount={graveowners.length}
              rowGetter={({ index }) => graveowners[index]}
            >
              <Column label="Id" dataKey="id" width={colWidth.SMALL} />
              <Column label="CNP" dataKey="cnp" width={colWidth.MEDIUM} />
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
