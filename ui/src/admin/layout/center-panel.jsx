import React from 'react';

import GraveownerListView from '../graveowner/graveowner-list-view';
import GraveListView from '../grave/grave-list-view';

import styles from './center-panel.scss';

const CenterPanel = () => (
  <div className={styles.centerPanel}>
    <GraveownerListView />
    <GraveListView />
  </div>
);

export default CenterPanel;
