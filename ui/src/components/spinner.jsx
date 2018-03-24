import React from 'react';
import PropTypes from 'prop-types';
import { Spinner as MSpinner } from 'office-ui-fabric-react/lib/Spinner';

import styles from './spinner.scss';

const propTypes = {
  children: PropTypes.oneOfType([PropTypes.object, PropTypes.array]),
  renderChildren: PropTypes.bool,
  label: PropTypes.string,
  size: PropTypes.number,
  loading: PropTypes.bool,
  fillContainer: PropTypes.bool
};

const defaultProps = {
  children: [],
  renderChildren: true,
  label: '',
  size: 3,
  loading: false,
  fillContainer: false
};

/**
 * Spinner component
 *
 * @extends {Component}
 */
const Spinner = ({ children, label, size, renderChildren, loading, fillContainer }) => (
  <div className={fillContainer || !renderChildren ? styles.fillContainer : styles.container}>
    {
      loading &&
      <div className={styles.background}>
        <div className={styles.spinner} >
          <MSpinner size={size} label={label} ariaLive="assertive" />
        </div>
      </div>
    }
    {renderChildren && children}
  </div>
);

Spinner.propTypes = propTypes;
Spinner.defaultProps = defaultProps;

export default Spinner;
