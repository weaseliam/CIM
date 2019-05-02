/* eslint-disable jsx-a11y/anchor-is-valid */
import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'office-ui-fabric-react/lib/Link';
import { Label } from 'office-ui-fabric-react/lib/Label';

import styles from './pagination.scss';

const propTypes = {
  i18n: PropTypes.shape(),
  page: PropTypes.number,
  pages: PropTypes.number,
  onFirstPage: PropTypes.func,
  onPrevPage: PropTypes.func,
  onNextPage: PropTypes.func,
  onLastPage: PropTypes.func
};

const defaultProps = {
  i18n: {
    firstPageTooltip: 'Go to first page',
    prevPageTooltip: 'Go to previous page',
    nextPageTooltip: 'Go to next page',
    lastPageTooltip: 'Go to last page'
  },
  page: 1,
  pages: 1,
  onFirstPage: () => { },
  onPrevPage: () => { },
  onNextPage: () => { },
  onLastPage: () => { },
};

/**
 * Simple pagination component
 */
const Pagination = ({ i18n, page, pages, onFirstPage, onPrevPage, onNextPage, onLastPage }) => {
  const handleFirstPage = () => {
    typeof onFirstPage === 'function' && onFirstPage(1);
  };

  const handlePrevPage = () => {
    typeof onPrevPage === 'function' && onPrevPage(Math.max(page - 1, 1));
  };

  const handleNextPage = () => {
    typeof onNextPage === 'function' && onNextPage(Math.min(page + 1, pages));
  };

  const handleLastPage = () => {
    typeof onLastPage === 'function' && onLastPage(pages);
  };

  return (
    <span>
      <Link
        className={styles.linkButton}
        onClick={handleFirstPage}
        title={i18n.firstPageTooltip}
      >
        &#9668;
      </Link>
      &nbsp;
      <Link
        className={styles.linkButton}
        onClick={handlePrevPage}
        title={i18n.prevPageTooltip}
      >
        &#8882;
      </Link>
      &nbsp;
      <Label className={styles.pagesLabel}>
        {page}
        /
        {pages}
      </Label>
      &nbsp;
      <Link
        className={styles.linkButton}
        onClick={handleNextPage}
        title={i18n.nextPageTooltip}
      >
        &#8883;
      </Link>
      &nbsp;
      <Link
        className={styles.linkButton}
        onClick={handleLastPage}
        title={i18n.lastPageTooltip}
      >
        &#9658;
      </Link>
    </span>
  );
};

Pagination.propTypes = propTypes;
Pagination.defaultProps = defaultProps;

export default Pagination;
