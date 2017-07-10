import { combineReducers } from 'redux';

import AppReducer from '../layout/app-reducer';
import I18nReducer from '../i18n/i18n-reducer';

export default combineReducers({
  app: AppReducer,
  i18n: I18nReducer
});
