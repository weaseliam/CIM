import React from 'react';

import LeftPanel from './left-panel';
import CenterPanel from './center-panel';
import RightPanel from './right-panel';

import styles from './admin-page.scss';

const AdminPage = () => (
  <div className={styles.admin}>
    <LeftPanel />
    <CenterPanel />
    <RightPanel />
  </div>
);

export default AdminPage;
