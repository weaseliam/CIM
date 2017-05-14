import axios from 'axios';

import { API_PATH } from '../../core/constants';

// eslint-disable-next-line
export const getLoggedInUser = () => (
  axios.get(`${API_PATH}/session`)
    .then(response => (response.data))
);
