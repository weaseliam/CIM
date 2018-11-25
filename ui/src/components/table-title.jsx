import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { ActionButton } from 'office-ui-fabric-react/lib/Button';

import styles from './table-title.scss';

const propTypes = {
  i18n: PropTypes.shape(),
  results: PropTypes.number,
  title: PropTypes.string,
  onResetFilter: PropTypes.func,
  className: PropTypes.string,
  width: PropTypes.number,
  height: PropTypes.number
};

const defaultProps = {
  i18n: {
    results: 'result(s)',
    resetFilter: 'Reset filter'
  },
  results: 0,
  title: '',
  onResetFilter: null,
  className: '',
  width: null,
  height: null
};

/**
 * Table title component that displays the number of results, title and reset option
 */
const TableTitle = ({ i18n, results, title, onResetFilter, className, width, height }) => (
  <div className={classNames(styles.container, className)} style={{ width, height }}>
    <span className={styles.text}>
      {results}
      &nbsp;
      {i18n.results}
    </span>
    <span className={styles.text}>{title}</span>
    {
      typeof onResetFilter === 'function' &&
      <ActionButton onClick={onResetFilter}>{i18n.resetFilter}</ActionButton>
    }
  </div>
);

TableTitle.propTypes = propTypes;
TableTitle.defaultProps = defaultProps;

export default TableTitle;
