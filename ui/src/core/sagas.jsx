import { appSagas } from '../layout/app-saga';
import { i18nSagas } from '../i18n/i18n-saga';

export const rootSaga = [
  appSagas,
  i18nSagas
];
