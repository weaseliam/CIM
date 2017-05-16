import axios from 'axios';

import { API_PATH } from '../../core/constants';

export const getLoggedInUser = () => (
  axios.get(`${API_PATH}/session`)
    .then(response => (response.data))
);

export const logOutUser = () => {
  // logout from server
  axios.get('/logout');

  // logout from basic auth
  axios.get('/', {
    auth: {
      username: '',
      password: ''
    }
  });
};
