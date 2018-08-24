import axios from 'axios';

import { API_GRAVE } from '../../core/constants';

export const fetchGraveList = ({
  page = 1, size = 100, sort = 'id', graveownerId
}) =>
  axios.get(API_GRAVE, {
    params: {
      page, size, sort, graveownerId
    }
  }).then(response => response.data);
