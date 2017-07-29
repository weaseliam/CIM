import axios from 'axios';

import { API_PATH } from '../core/constants';

/**
 * Get current logged in user detail REST call.
 *
 * @returns {Promise}
 */
export const getLoggedInUser = () => (
  axios.get(`${API_PATH}/session`)
    .then(response => (response.data))
);

/**
 * Log out current user REST call.
 *
 * @returns {Promise}
 */
export const logOutUser = () => {
  axios.post('/logout');
};
