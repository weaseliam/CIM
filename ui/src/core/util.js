import { isNil, isEmpty } from 'ramda';

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
 * @param {*} fn function
 * @param {*} time debounce time
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
