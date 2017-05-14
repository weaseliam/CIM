import { combineReducers } from 'redux';

import AppReducer from '../layout/reducers/app-reducer';

export default combineReducers({
  app: AppReducer
});
