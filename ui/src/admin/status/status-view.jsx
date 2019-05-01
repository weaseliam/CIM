import React from 'react';

import ContractExpiredView from './contract-expired-view';
import ContractToExpireView from './contract-to-expire-view';

import styles from './status-view.scss';

const StatusView = () =>
  <div className={styles.statusView}>
    <ContractExpiredView />
    <ContractToExpireView />
  </div>;

export default StatusView;
