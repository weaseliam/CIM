import React, { Component } from 'react';
import { connect } from 'react-redux';
import { AutoSizer, Table, Column } from 'react-virtualized';

import withI18n from '../../i18n/i18n-decorator';
import { selectedGraveownerSelector } from '../graveowner/graveowner-selector';
import { graveListSelector } from './grave-selector';
import { TABLE_COL_WIDTH } from '../../core/constants';

import styles from './grave-list-view.scss';
import tableStyles from '../../styles/table-styles.scss';

const TABLE_TITLE_HEIGHT = 35;
const TABLE_HEADER_HEIGHT = 30;
const TABLE_ROW_HEIGHT = 30;

const mapStateToProps = state => ({
  graveList: graveListSelector(state),
  selectedGraveowner: selectedGraveownerSelector(state),
});

@withI18n
@connect(mapStateToProps)
class GraveListView extends Component {
  handleRowClassName = ({ index }) => {
    if (index < 0) {
      return tableStyles.tableHeaderRow;
    }

    return index % 2 === 0
      ? tableStyles.tableEvenRow
      : tableStyles.tableOddRow;
  }

  render() {
    const { selectedGraveowner } = this.props;
    const { graves = [] } = this.props.graveList;

    return (
      <div className={styles.graveList}>
        <AutoSizer>
          {({ width, height }) => (
            <React.Fragment>
              <div className={styles.tableTitle}>
                {selectedGraveowner
                  ? `${graves.length} grave(s) for ${selectedGraveowner.nume} ${selectedGraveowner.prenume}`
                  : 'No selection'}
              </div>
              <Table
                headerClassName={tableStyles.tableHeaderColumn}
                rowClassName={this.handleRowClassName}
                width={width}
                height={height - TABLE_TITLE_HEIGHT}
                headerHeight={TABLE_HEADER_HEIGHT}
                rowHeight={TABLE_ROW_HEIGHT}
                rowCount={graves.length}
                rowGetter={({ index }) => graves[index]}
              >
                <Column
                  label="cimitirId"
                  dataKey="cimitirId"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="codZona"
                  dataKey="codZona"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="sector"
                  dataKey="sector"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="rand"
                  dataKey="rand"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="pozitie"
                  dataKey="pozitie"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="ani"
                  dataKey="ani"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="scutitId"
                  dataKey="scutitId"
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="matricola"
                  dataKey="matricola"
                  width={TABLE_COL_WIDTH.L}
                />
              </Table>
            </React.Fragment>
          )}
        </AutoSizer>
      </div>
    );
  }
}

export default GraveListView;
