import { spawn, call } from 'redux-saga/effects';

import { appSagas } from '../app/app-saga';
import { i18nSagas } from '../i18n/i18n-saga';
import { graveownerSagas } from '../admin/graveowner/graveowner-saga';
import { graveSagas } from '../admin/grave/grave-saga';
import { contractSagas } from '../admin/contract/contract-saga';
import { statusSagas } from '../admin/status/status-saga';

const sagas = [
  appSagas,
  i18nSagas,
  graveownerSagas,
  graveSagas,
  contractSagas,
  statusSagas
];

export function* rootSaga() {
  yield sagas.map(saga =>
    spawn(function* () {
      while (true) {
        try {
          yield call(saga);
        } catch (e) {
          // Global exception handling for sagas
          // eslint-disable-next-line
          console.error(e);
          // eslint-disable-next-line
          alert(e);
        }
      }
    })
  );
}
