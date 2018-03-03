import React from 'react';
import PropTypes from 'prop-types';
import { Spinner as MSpinner } from 'office-ui-fabric-react/lib/Spinner';

import styles from './spinner.scss';

const propTypes = {
  children: PropTypes.arrayOf(PropTypes.element),
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
  loading: true,
  fillContainer: true
};

/**
 * Spinner component
 *
 * @extends {Component}
 */
const Spinner = ({ children, label, size, renderChildren, loading, fillContainer }) => (
  <div className={fillContainer || !renderChildren ? styles.fillContainer : styles.container}>
    {loading ?
      <div className={styles.background}>
        <div className={styles.spinner} >
          <MSpinner size={size} label={label} ariaLive="assertive" />
        </div>
      </div> :
      null}
    {renderChildren ? children : null}
  </div>
);

Spinner.propTypes = propTypes;
Spinner.defaultProps = defaultProps;

export default Spinner;
