import axios from 'axios';

import { API_PATH } from '../core/constants';

export const getLoggedInUser = () => (
  axios.get(`${API_PATH}/session`)
    .then(response => (response.data))
);

export const logOutUser = () => {
  axios.post('/logout');
};
