import R from 'ramda';

/**
 * Check if the provided value is nil or empty using ramda.
 * See ramda isNil and isEmpty for more details.
 *
 * @param {any} value
 */
export const isNilOrEmpty = value => (
  R.isNil(value) || R.isEmpty(value)
);
