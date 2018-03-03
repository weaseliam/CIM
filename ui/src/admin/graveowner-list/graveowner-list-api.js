import axios from 'axios';

import { API_PATH } from '../../core/constants';

/**
 * Fetch graveowners REST call.
 *
 * @returns {Promise}
 */
export const fetchGraveownerList = (page = 1, size = 100) =>
  axios.get(`${API_PATH}/graveowner/list`, { params: { page, size } })
    .then(response => response.data);
