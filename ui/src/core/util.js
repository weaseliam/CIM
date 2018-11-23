import { isNil, isEmpty } from 'ramda';
import moment from 'moment';

import { DEFAULT_DATE_FORMAT } from './constants';

/**
 * Check if the provided value is nil or empty using ramda.
 * See ramda isNil and isEmpty for more details.
 *
 * @param {any} value
 */
export const isNilOrEmpty = value => (
  isNil(value) || isEmpty(value)
);

/**
 * Returns a function, that, as long as it continues to be invoked, will not
 * be triggered. The function will be called after it stops being called for
 * N milliseconds.
 *
 * @param {function} fn function
 * @param {number} time debounce time milliseconds
 */
export const debounce = (fn, time) => {
  let timeout;

  return function () {
    // eslint-disable-next-line prefer-rest-params
    const functionCall = () => fn.apply(this, arguments);

    clearTimeout(timeout);
    timeout = setTimeout(functionCall, time);
  };
};

/**
 * Parse and display a date using a specific format.
 *
 * @param {string} date the date to be parsed
 * @param {string} format the format to be used for display
 */
export const parseAndFormatDate = (date, format = DEFAULT_DATE_FORMAT) =>
  moment(date).format(format);
