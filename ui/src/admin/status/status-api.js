import axios from 'axios';

import { API_STATUS_CONTRACT } from '../../core/constants';

export const fetchStatusContractList = ({
  page = 1, size = 5, dte = 0
}) =>
  axios.get(API_STATUS_CONTRACT, {
    params: {
      page, size, dte
    }
  }).then(response => response.data);
