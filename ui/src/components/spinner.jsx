import React from 'react';
import PropTypes from 'prop-types';
import { BounceLoader } from 'halogen';

import styles from './spinner.scss';

const propTypes = {
  children: PropTypes.anyOf,
  renderChildren: PropTypes.bool,
  color: PropTypes.string,
  size: PropTypes.number,
  loading: PropTypes.bool,
  fillContainer: PropTypes.bool
};

const defaultProps = {
  children: [],
  renderChildren: true,
  color: '#3399ff',
  size: 60,
  loading: true,
  fillContainer: true
};

/**
 * Spinner component
 *
 * @extends {Component}
 */
const Spinner = ({ children, color, size, renderChildren, loading, fillContainer }) => (
  <div className={fillContainer || !renderChildren ? styles.fillContainer : styles.container}>
    {loading ?
      <div className={styles.background}>
        <BounceLoader className={styles.loader} color={color} size={size} />
      </div> :
      null}
    {renderChildren ? children : null}
  </div>
);

Spinner.propTypes = propTypes;
Spinner.defaultProps = defaultProps;

export default Spinner;
