import axios from 'axios';

import { API_SESSION, LOGOUT_URL } from '../core/constants';

export const getAppSession = () =>
  axios.get(API_SESSION)
    .then(response => response.data);

export const logOutUser = () =>
  axios.post(LOGOUT_URL);
