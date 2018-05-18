import axios from 'axios';

import { API_PATH } from '../core/constants';

/**
 * Get current app session REST call.
 *
 * @returns {Promise}
 */
export const getAppSession = () =>
  axios.get(`${API_PATH}/session`)
    .then(response => response.data);

/**
 * Log out current user REST call.
 *
 * @returns {Promise}
 */
export const logOutUser = () =>
  axios.post('/logout');
