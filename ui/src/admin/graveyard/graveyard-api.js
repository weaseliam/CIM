import axios from 'axios';

import { API_GRAVEYARD } from '../../core/constants';

export const fetchGraveyardMap = () =>
  axios.get(API_GRAVEYARD).then(response => response.data);
