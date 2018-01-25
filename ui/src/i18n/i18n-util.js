import { isNil } from 'ramda';

import { isNilOrEmpty } from '../core/util';

/**
 * If the message contains string sequence of type `{n}` were n is a number
 * between 1 and 9, it will replace it with the n-th value from params.
 *
 * @param {string} message
 * @param {Array} params
 * @returns formatted message or initial message
 */
export const format = (message, params) => {
  if (isNilOrEmpty(message) || isNilOrEmpty(params)) {
    return message;
  }

  let formatted = '';
  for (let i = 0; i < message.length; i += 1) {
    const c = message.charAt(i);
    if (c !== '{') {
      formatted += c;
      continue;
    }

    if (i + 2 >= message.length ||
        message.charAt(i + 1) < '0' && message.charAt(i + 1) > '9' ||
        message.charAt(i + 2) !== '}') {
      formatted += c;
      continue;
    }

    const paramIndex = message.charAt(i + 1) - '0';
    if (paramIndex >= params.length) {
      formatted += c;
      continue;
    }

    formatted += params[paramIndex];
    i += 2;
  }

  return formatted;
};

/**
 * Translate code and parameters using messages.
 * The code is the key part from messages.
 * If the message contains string sequence of type `{n}` were n is a number
 * between 1 and 9, it will replace it with the n-th value from params.
 *
 * @param {object} messages dictionary messages
 * @param {string} code translation code
 * @param {Array} params translation parameters
 * @returns translated message or initial translation code
 */
export const translate = (messages, code, params) => {
  if (isNilOrEmpty(code)) {
    return code;
  }

  const message = messages[code];
  if (isNil(message)) {
    return code;
  }

  if (isNilOrEmpty(params)) {
    return message;
  }

  return format(message, params);
};
