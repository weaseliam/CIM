import axios from 'axios';

import { API_DICTIONARY } from '../core/constants';

export const fetchDictionary = (language) => {
  const languageParam = language ? `/${language}` : '';

  return axios.get(`${API_DICTIONARY}${languageParam}`)
    .then(response => response.data);
};

export const fetchSupportedLanguages = () =>
  axios.get(`${API_DICTIONARY}/list`)
    .then(response => response.data);
