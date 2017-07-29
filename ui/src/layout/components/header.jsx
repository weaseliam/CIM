import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';

import styles from './header.scss';

const propTypes = {
  /**
   * Company title that will appear in the left side of the header.
   */
  companyTitle: PropTypes.string,

  /**
   * User name that will appear in the right side of the header.
   */
  userName: PropTypes.string,

  /**
   * Extra class names that can be used to further customize the
   * look and feel of the component.
   */
  className: PropTypes.string
};

const defaultProps = {
  companyTitle: 'Company Title',
  userName: 'User Name',
  className: ''
};

/**
 * Header component
 */
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

Header.propTypes = propTypes;
Header.defaultProps = defaultProps;

export default Header;
