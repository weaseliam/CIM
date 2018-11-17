import React from 'react';

import GraveownerListView from '../graveowner/graveowner-list-view';
import ContractListView from '../contract/contract-list-view';

import styles from './center-panel.scss';

const CenterPanel = () => (
  <div className={styles.centerPanel}>
    <GraveownerListView />
    <ContractListView />
  </div>
);

export default CenterPanel;
