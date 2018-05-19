import { takeEvery, call, put, all } from 'redux-saga/effects';

import { getAppSession, logOutUser } from './app-api';
import {
  bootstrapAppAction,
  fetchAppSessionAction,
  logOutUserAction
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
  yield call(logOutUser);
}

/**
 * After successful log out user saga.
 */
function* afterLogOutUserSaga() {
  // eslint-disable-next-line no-undef
  yield window.location = '/login?logout';
}

export function* appSagas() {
  yield takeEvery(bootstrapAppAction.TRIGGER, bootstrapAppSaga);
  yield takeEvery(logOutUserAction.TRIGGER, logOutUserSaga);
  yield takeEvery(logOutUserAction.FULFILL, afterLogOutUserSaga);
}
