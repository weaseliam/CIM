import React from 'react';

import StatusView from '../status/status-view';

import styles from './right-panel.scss';

const RightPanel = () => (
  <div className={styles.rightPanel}>
    <StatusView />
  </div>
);

export default RightPanel;
