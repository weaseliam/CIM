import axios from 'axios';

import { API_EXEMPT } from '../../core/constants';

export const fetchExemptMap = () =>
  axios.get(API_EXEMPT).then(response => response.data);
