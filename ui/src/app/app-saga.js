import { takeEvery, call, put, all } from 'redux-saga/effects';

import { getAppSession, logOutUser } from './app-api';
import {
  bootstrapAppAction,
  fetchAppSessionAction,
  logOutUserAction,
  setAppLoadingAction
} from './app-actions';
import { changeLanguageSaga, fetchSupportedLanguagesSaga } from '../i18n/i18n-saga';

/**
 * Fetch current app session saga.
 */
function* fetchAppSessionSaga() {
  const session = yield call(getAppSession);
  yield put(fetchAppSessionAction.success(session));
}

/**
 * Bootstrap application saga.
 */
function* bootstrapAppSaga() {
  yield all([
    call(fetchAppSessionSaga),
    call(changeLanguageSaga, {}),
    call(fetchSupportedLanguagesSaga)
  ]);

  yield put(bootstrapAppAction.success());
}

/**
 * Log out current user saga.
 */
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
