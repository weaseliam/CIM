import { combineReducers } from 'redux';

import { appReducer } from '../layout/app-reducer';
import { i18nReducer } from '../i18n/i18n-reducer';

export const rootReducer = combineReducers({
  app: appReducer,
  i18n: i18nReducer
});
