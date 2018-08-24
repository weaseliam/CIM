import { takeEvery, call, put, all } from 'redux-saga/effects';

import { getAppSession, logOutUser } from './app-api';
import {
  bootstrapAppAction,
  fetchAppSessionAction,
  logOutUserAction,
  setAppLoadingAction
} from './app-actions';
import { changeLanguageSaga, fetchSupportedLanguagesSaga } from '../i18n/i18n-saga';
import { fetchExemptMapSaga } from '../admin/exempt/exempt-saga';
import { fetchGraveyardMapSaga } from '../admin/graveyard/graveyard-saga';

function* fetchAppSessionSaga() {
  const session = yield call(getAppSession);
  yield put(fetchAppSessionAction.success(session));
}

function* bootstrapAppSaga() {
  yield all([
    call(fetchAppSessionSaga),
    call(changeLanguageSaga, {}),
    call(fetchSupportedLanguagesSaga),
    call(fetchExemptMapSaga),
    call(fetchGraveyardMapSaga)
  ]);

  yield put(bootstrapAppAction.success());
}

function* logOutUserSaga() {
  try {
    yield put(setAppLoadingAction.success(true));
    yield call(logOutUser);

    // eslint-disable-next-line no-undef
    yield window.location = '/login?logout';
  } finally {
    yield put(setAppLoadingAction.success(false));
  }
}

export function* appSagas() {
  yield takeEvery(bootstrapAppAction.TRIGGER, bootstrapAppSaga);
  yield takeEvery(logOutUserAction.TRIGGER, logOutUserSaga);
}
