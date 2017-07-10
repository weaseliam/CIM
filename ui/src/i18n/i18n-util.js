import R from 'ramda';

export const format = (message, params) => {
  if (R.isNil(message) || R.isEmpty(message ||
      R.isNil(params) || R.isEmpty(params))) {
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

export const translate = (messages, code, params) => {
  if (R.isNil(code) || R.isEmpty(code)) {
    return code;
  }

  const message = messages[code];
  if (R.isNil(message)) {
    return code;
  }

  if (R.isNil(params) || R.isEmpty(params)) {
    return message;
  }

  return format(message, params);
};
