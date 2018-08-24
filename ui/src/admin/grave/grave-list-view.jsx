import React, { Component } from 'react';
import { connect } from 'react-redux';
import { AutoSizer, Table, Column } from 'react-virtualized';

import withI18n from '../../i18n/i18n-decorator';
import { selectedGraveownerSelector } from '../graveowner/graveowner-selector';
import { graveListSelector } from './grave-selector';
import { TABLE_COL_WIDTH } from '../../core/constants';
import { exemptMapSelector } from '../exempt/exempt-selector';
import { graveyardMapSelector } from '../graveyard/graveyard-selector';

import styles from './grave-list-view.scss';
import tableStyles from '../../styles/table-styles.scss';

const TABLE_TITLE_HEIGHT = 35;
const TABLE_HEADER_HEIGHT = 30;
const TABLE_ROW_HEIGHT = 30;

const mapStateToProps = state => ({
  graveList: graveListSelector(state),
  selectedGraveowner: selectedGraveownerSelector(state),
  exemptMap: exemptMapSelector(state),
  graveyardMap: graveyardMapSelector(state)
});

@withI18n
@connect(mapStateToProps)
class GraveListView extends Component {
  handleRowClassName = ({ index }) => {
    if (index === -1) {
      return tableStyles.tableHeaderRow;
    }

    return index % 2 === 0
      ? tableStyles.tableEvenRow
      : tableStyles.tableOddRow;
  }

  formatGraveyardCell = ({ dataKey, rowData }) => {
    const { nume = '' } = this.props.graveyardMap[rowData[dataKey]] || {};
    return nume;
  }

  formatExemptCell = ({ dataKey, rowData }) => {
    const { nume = '' } = this.props.exemptMap[rowData[dataKey]] || {};
    return nume;
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
                  label="Cimitir"
                  dataKey="cimitirId"
                  cellDataGetter={this.formatGraveyardCell}
                  width={TABLE_COL_WIDTH.XL}
                />
                <Column
                  label="Cod zona"
                  dataKey="codZona"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Sector"
                  dataKey="sector"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Rand"
                  dataKey="rand"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Pozitie"
                  dataKey="pozitie"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Ani"
                  dataKey="ani"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Scutit"
                  dataKey="scutitId"
                  cellDataGetter={this.formatExemptCell}
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label="Matricola"
                  dataKey="matricola"
                  width={TABLE_COL_WIDTH.M}
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
