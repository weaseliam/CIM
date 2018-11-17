import React, { Component } from 'react';
import { connect } from 'react-redux';
import { AutoSizer, Table, Column } from 'react-virtualized';

import withI18n from '../../i18n/i18n-decorator';
import { selectedGraveownerSelector } from '../graveowner/graveowner-selector';
import { contractListWithGravesSelector } from './contract-selector';
import { TABLE_COL_WIDTH } from '../../core/constants';
import { exemptMapSelector } from '../exempt/exempt-selector';
import { graveyardMapSelector } from '../graveyard/graveyard-selector';

import styles from './contract-list-view.scss';
import tableStyles from '../../styles/table-styles.scss';

const TABLE_TITLE_HEIGHT = 35;
const TABLE_HEADER_HEIGHT = 30;
const TABLE_ROW_HEIGHT = 30;

const mapStateToProps = state => ({
  contracts: contractListWithGravesSelector(state),
  selectedGraveowner: selectedGraveownerSelector(state),
  exemptMap: exemptMapSelector(state),
  graveyardMap: graveyardMapSelector(state)
});

@withI18n
@connect(mapStateToProps)
class ContractListView extends Component {
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
    const { contracts = [] } = this.props;

    return (
      <div className={styles.contractList}>
        <AutoSizer>
          {({ width, height }) => (
            <React.Fragment>
              <div className={styles.tableTitle}>
                {selectedGraveowner
                  ? `${contracts.length} contract(s) for ${selectedGraveowner.nume} ${selectedGraveowner.prenume}`
                  : 'No selection'}
              </div>
              <Table
                headerClassName={tableStyles.tableHeaderColumn}
                rowClassName={this.handleRowClassName}
                width={width}
                height={height - TABLE_TITLE_HEIGHT}
                headerHeight={TABLE_HEADER_HEIGHT}
                rowHeight={TABLE_ROW_HEIGHT}
                rowCount={contracts.length}
                rowGetter={({ index }) => contracts[index]}
              >
                <Column
                  label="Cimitir"
                  dataKey="cimitirId"
                  cellDataGetter={this.formatGraveyardCell}
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Cod zona"
                  dataKey="codZona"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label="Sector"
                  dataKey="sector"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label="Rand"
                  dataKey="rand"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label="Pozitie"
                  dataKey="pozitie"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label="NrLocuri"
                  dataKey="nrLocuri"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label="Ani"
                  dataKey="ani"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label="DataIncep"
                  dataKey="dataIncep"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="DataExp"
                  dataKey="dataExp"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="NrContr"
                  dataKey="nrContr"
                  width={TABLE_COL_WIDTH.S}
                />
                <Column
                  label="DataContr"
                  dataKey="dataContr"
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Scutit"
                  dataKey="exemptId"
                  cellDataGetter={this.formatExemptCell}
                  width={TABLE_COL_WIDTH.M}
                />
                <Column
                  label="Matricola"
                  dataKey="matricola"
                  width={TABLE_COL_WIDTH.S}
                />
              </Table>
            </React.Fragment>
          )}
        </AutoSizer>
      </div>
    );
  }
}

export default ContractListView;
