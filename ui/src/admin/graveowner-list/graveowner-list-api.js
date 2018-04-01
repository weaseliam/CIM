import axios from 'axios';

import { API_PATH } from '../../core/constants';

/**
 * Fetch graveowners REST call.
 *
 * @returns {Promise}
 */
export const fetchGraveownerList = ({ page, size, sort }) =>
  axios.get(`${API_PATH}/graveowner/list`, { params: { page, size, sort } })
    .then(response => response.data);
