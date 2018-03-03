import React from 'react';
import PropTypes from 'prop-types';
import { ProgressIndicator } from 'office-ui-fabric-react/lib/ProgressIndicator';

import style from './loader.scss';

const propTypes = {
  loading: PropTypes.bool,
  size: PropTypes.number
};

const defaultProps = {
  loading: true,
  size: 30
};

/**
 * Loader component
 *
 * @extends {Component}
 */
const Loader = ({ loading, size }) => (
  loading ?
    <div className={style.loader} style={{ width: size }}>
      <ProgressIndicator />
    </div> :
    null
);

Loader.propTypes = propTypes;
Loader.defaultProps = defaultProps;

export default Loader;
