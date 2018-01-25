import React from 'react';
import PropTypes from 'prop-types';

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
  loading ?
    <div className={style.loader} style={{ color, fontSize: size }}>
      &nbsp;Loading...
    </div> :
    null
);

Loader.propTypes = propTypes;
Loader.defaultProps = defaultProps;

export default Loader;
