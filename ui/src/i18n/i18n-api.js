import axios from 'axios';

import { API_PATH } from '../core/constants';

/**
 * Fetch dictionary REST call.
 *
 * @param {string} language
 * @returns {Promise}
 */
const fetchDictionary = (language) => {
  const languageParam = language ? `/${language}` : '';

  return axios.get(`${API_PATH}/dictionary${languageParam}`)
    .then(response => (response.data));
};

export default fetchDictionary;
