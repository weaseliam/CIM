import axios from 'axios';

import { API_GRAVE } from '../../core/constants';

const serializeParams = (params) => {
  const keys = Object.keys(params);
  return keys.map(
    key =>
      Array.isArray(params[key])
        ? `${key}=${params[key].join(',')}`
        : `${key}=${params[key]}`
  ).join('&');
};

export const fetchGraveList = ({
  page = 1, size = 100, sort = 'id', contractIds
}) =>
  axios.get(API_GRAVE, {
    params: {
      page, size, sort, contractIds
    },
    paramsSerializer: params =>
      serializeParams(params)
  }).then(response => response.data);
