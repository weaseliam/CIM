import React from 'react';
import PropTypes from 'prop-types';

import styles from './header.scss';

const Header = ({ companyTitle, userName }) => (
  <div className={styles.header}>
    <div className={styles.company}>
      {companyTitle}
    </div>
    <div className={styles.user}>
      {userName}
    </div>
  </div>
);

Header.propTypes = {
  companyTitle: PropTypes.string,
  userName: PropTypes.string
};

Header.defaultProps = {
  companyTitle: 'Company Title',
  userName: 'User Name'
};

export default Header;
