import axios from 'axios';

import { API_GRAVEOWNER } from '../../core/constants';

/**
 * Fetch graveowners REST call.
 *
 * @returns {Promise}
 */
export const fetchGraveownerList = ({
  page, size, sort, filter: {
    id, cnp, nume, prenume, localitate, judet, adresa
  }
}) =>
  axios.get(API_GRAVEOWNER, {
    params: {
      page, size, sort, id, cnp, nume, prenume, localitate, judet, adresa
    }
  }).then(response => response.data);
