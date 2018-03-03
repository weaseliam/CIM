import { appSagas } from '../app/app-saga';
import { i18nSagas } from '../i18n/i18n-saga';
import { graveownerListSagas } from '../admin/graveowner-list/graveowner-list-saga';

export const rootSaga = [
  appSagas,
  i18nSagas,
  graveownerListSagas
];
