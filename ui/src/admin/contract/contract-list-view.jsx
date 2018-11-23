import React, { Component } from 'react';
import { connect } from 'react-redux';
import { AutoSizer, Table, Column } from 'react-virtualized';

import withI18n from '../../i18n/i18n-decorator';
import { selectedGraveownerSelector } from '../graveowner/graveowner-selector';
import { contractListWithGravesSelector } from './contract-selector';
import { TABLE_COL_WIDTH } from '../../core/constants';
import { exemptMapSelector } from '../exempt/exempt-selector';
import { graveyardMapSelector } from '../graveyard/graveyard-selector';
import * as i18nc from '../../i18n/i18n-constants';
import { parseAndFormatDate, isNilOrEmpty } from '../../core/util';

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

  formatGraveyardCell = ({ rowData }) => {
    const { graveyardMap } = this.props;
    const { graveyardId, codZona = '', sector = '', rand = '', pozitie = '' } = rowData;
    const { nume = '' } = graveyardMap[graveyardId] || {};

    return `${nume},${codZona},${sector},${rand},${pozitie}`;
  }

  formatExemptCell = ({ dataKey, rowData }) => {
    const { exemptMap } = this.props;
    const { nume = '' } = exemptMap[rowData[dataKey]] || {};

    return nume;
  }

  formatDateCell = ({ dataKey, rowData }) => {
    const { i18n } = this.props;
    const date = rowData[dataKey];

    if (isNilOrEmpty(date)) {
      return '';
    }

    return parseAndFormatDate(date, i18n.formats.date);
  }

  render() {
    const { selectedGraveowner, t } = this.props;
    const { contracts = [] } = this.props;

    return (
      <div className={styles.contractList}>
        <AutoSizer>
          {({ width, height }) => (
            <React.Fragment>
              <div className={styles.tableTitle}>
                {selectedGraveowner
                  ? t(i18nc.CONTRACT_LIST_SELECTION_DESC, [
                    contracts.length,
                    selectedGraveowner.nume,
                    selectedGraveowner.prenume
                  ])
                  : t(i18nc.CONTRACT_LIST_NO_SELECTION)}
              </div>
              <Table
                className={tableStyles.table}
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
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_GRAVEYARD)}
                  dataKey="graveyardId"
                  cellDataGetter={this.formatGraveyardCell}
                  width={TABLE_COL_WIDTH.L}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_PLACES)}
                  dataKey="nrLocuri"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_YEARS)}
                  dataKey="ani"
                  width={TABLE_COL_WIDTH.XS}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_START_DATE)}
                  dataKey="dataIncep"
                  cellDataGetter={this.formatDateCell}
                  width={TABLE_COL_WIDTH.S}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_END_DATE)}
                  dataKey="dataExp"
                  cellDataGetter={this.formatDateCell}
                  width={TABLE_COL_WIDTH.S}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_CONTRACT_NO)}
                  dataKey="nrContr"
                  width={TABLE_COL_WIDTH.S}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_CONTRACT_DATE)}
                  dataKey="dataContr"
                  cellDataGetter={this.formatDateCell}
                  width={TABLE_COL_WIDTH.S}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_EXEMPT)}
                  dataKey="exemptId"
                  cellDataGetter={this.formatExemptCell}
                  width={TABLE_COL_WIDTH.S}
                />
                <Column
                  label={t(i18nc.CONTRACT_LIST_TABLE_HEADER_REGISTRATION)}
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
