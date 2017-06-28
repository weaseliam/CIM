import axios from 'axios';

import { API_PATH } from '../core/constants';

const fetchDictionary = (language = undefined) => {
  const languageParam = language ? `/${language}` : '';

  return axios.get(`${API_PATH}/dictionary${languageParam}`)
    .then(response => (response.data));
};

export default fetchDictionary;
