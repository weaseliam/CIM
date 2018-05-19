import { combineReducers } from 'redux';

import { appReducer } from '../app/app-reducer';
import { i18nReducer } from '../i18n/i18n-reducer';
import { graveownerReducer } from '../admin/graveowner/graveowner-reducer';

export const rootReducer = combineReducers({
  app: appReducer,
  i18n: i18nReducer,
  graveowner: graveownerReducer
});
