import React from 'react';
import PropTypes from 'prop-types';
import { PulseLoader } from 'halogen';

import style from './loader.scss';

const propTypes = {
  color: PropTypes.string,
  size: PropTypes.number,
  loading: PropTypes.bool,
};

const defaultProps = {
  color: '#3399ff',
  size: 10,
  loading: true
};

/**
 * Loader component
 *
 * @extends {Component}
 */
const Loader = ({ color, size, loading }) => (
  <PulseLoader className={style.loader} color={color} size={size} loading={loading} />
);

Loader.propTypes = propTypes;
Loader.defaultProps = defaultProps;

export default Loader;
