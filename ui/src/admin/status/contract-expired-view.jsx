import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import { List } from 'office-ui-fabric-react/lib/List';
import { MessageBar, MessageBarType } from 'office-ui-fabric-react/lib/MessageBar';

import withI18n from '../../i18n/i18n-decorator';
import Pagination from '../../components/pagination';
import { fetchExpiredContractListAction } from './status-actions';
import { expiredContractListSelector } from './status-selector';
import { parseAndFormatDate } from '../../core/util';
import { graveyardMapSelector } from '../graveyard/graveyard-selector';
import { exemptMapSelector } from '../exempt/exempt-selector';

import styles from './contract-expired-view.scss';

const PAGE_SIZE = 5;
const messageBarNoIconStyle = { icon: { display: 'none' } };

const mapStateToProps = state => ({
  expiredContracts: expiredContractListSelector(state),
  graveyardMap: graveyardMapSelector(state),
  exemptMap: exemptMapSelector(state)
});

@withI18n
@connect(mapStateToProps)
class ContractExpiredView extends Component {
  componentDidMount() {
    this.fetchExpiredContracts(1);
  }

  fetchExpiredContracts = (page) => {
    const { dispatch } = this.props;

    dispatch(fetchExpiredContractListAction.trigger({
      page, size: PAGE_SIZE
    }));
  }

  handleFirstPage = (page) => {
    this.fetchExpiredContracts(page);
  }

  handlePrevPage = (page) => {
    this.fetchExpiredContracts(page);
  }

  handleNextPage = (page) => {
    this.fetchExpiredContracts(page);
  }

  handleLastPage = (page) => {
    this.fetchExpiredContracts(page);
  }

  onRenderListItemContract = ({ contract, grave, graveowner }) => {
    const { i18n, graveyardMap, exemptMap } = this.props;
    const formatDate = date =>
      parseAndFormatDate(date, i18n.formats.date);
    const cemeteryName = (graveyardMap[grave.graveyardId] || {}).nume || '';
    const exemptName = (exemptMap[contract.exemptId] || {}).nume || '';

    return (
      <MessageBar
        messageBarType={MessageBarType.severeWarning}
        isMultiline={false}
        truncated
        styles={messageBarNoIconStyle}
      >
        {
          `${graveowner.nume} ${graveowner.prenume}, ${graveowner.localitate}, ${graveowner.adresa}, ${graveowner.judet}, ID ${graveowner.id}. ${exemptName}
Grave ${cemeteryName}, zone ${grave.codZona}, sector ${grave.sector}, row ${grave.rand}, pozition ${grave.pozitie}, ${grave.nrLocuri} places.
Contract end date ${formatDate(contract.dataExp)}, start date ${formatDate(contract.dataIncep)}, registration ${contract.matricola}.`
        }
      </MessageBar>
    );
  };

  render() {
    const { expiredContracts } = this.props;
    const { totalResults, page, totalPages, results } = expiredContracts;

    return (
      <Fragment>
        <MessageBar
          className={styles.titleMessageBar}
          messageBarType={MessageBarType.severeWarning}
        >
          <Pagination
            page={page}
            pages={totalPages}
            onFirstPage={this.handleFirstPage}
            onPrevPage={this.handlePrevPage}
            onNextPage={this.handleNextPage}
            onLastPage={this.handleLastPage}
          />
          <span>{`${totalResults} expired contracts.`}</span>
        </MessageBar>
        <List items={results} onRenderCell={this.onRenderListItemContract} />
      </Fragment>
    );
  }
}

export default ContractExpiredView;
