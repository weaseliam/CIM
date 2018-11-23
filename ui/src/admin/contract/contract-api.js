import axios from 'axios';

import { API_CONTRACT } from '../../core/constants';

export const fetchContractList = ({
  page = 1, size = 100, sort = '-id', graveownerId
}) =>
  axios.get(API_CONTRACT, {
    params: {
      page, size, sort, graveownerId
    }
  }).then(response => response.data);
