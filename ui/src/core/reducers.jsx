import { combineReducers } from 'redux';

import { appReducer } from '../app/app-reducer';
import { i18nReducer } from '../i18n/i18n-reducer';
import { graveownerListReducer } from '../admin/graveowner-list/graveowner-list-reducer';

export const rootReducer = combineReducers({
  app: appReducer,
  i18n: i18nReducer,
  graveownerList: graveownerListReducer
});
