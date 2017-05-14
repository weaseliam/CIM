import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';

import styles from './header.scss';

const Header = ({ companyTitle, userName, className }) => (
  <div className={classNames(styles.header, className)}>
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
  userName: PropTypes.string,
  className: PropTypes.string
};

Header.defaultProps = {
  companyTitle: 'Company Title',
  userName: 'User Name',
  className: ''
};

export default Header;
