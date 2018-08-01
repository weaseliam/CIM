import axios from 'axios';

import { API_SESSION, LOGOUT_URL } from '../core/constants';

/**
 * Get current app session REST call.
 *
 * @returns {Promise}
 */
export const getAppSession = () =>
  axios.get(API_SESSION)
    .then(response => response.data);

/**
 * Log out current user REST call.
 *
 * @returns {Promise}
 */
export const logOutUser = () =>
  axios.post(LOGOUT_URL);
