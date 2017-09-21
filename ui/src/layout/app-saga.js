import { takeEvery, call, put } from 'redux-saga/effects';

import { getLoggedInUser, logOutUser } from './app-api';
import {
  bootstrapAppRoutine,
  fetchLoggedInUserRoutine,
  logOutUserRoutine
} from './app-routines';
import { changeLanguageSaga } from '../i18n/i18n-saga';

/**
 * Fetch current logged in user detail saga.
 */
function* fetchLoggedInUserSaga() {
  try {
    const user = yield call(getLoggedInUser);

    yield put(fetchLoggedInUserRoutine.success(user));
  } catch (error) {
    yield put(fetchLoggedInUserRoutine.failure(error.response.data));
  }
}

/**
 * Bootstrap application saga.
 */
function* bootstrapAppSaga() {
  try {
    yield call(fetchLoggedInUserSaga);
    yield call(changeLanguageSaga, {});

    yield put(bootstrapAppRoutine.success());
  } catch (error) {
    yield put(bootstrapAppRoutine.failure(error.response.data));
  } finally {
    yield put(bootstrapAppRoutine.fulfill());
  }
}

/**
 * Log out current user saga.
 */
function* logOutUserSaga() {
  try {
    yield call(logOutUser);

    yield put(logOutUserRoutine.success());
  } catch (error) {
    yield put(logOutUserRoutine.failure());
  } finally {
    yield put(logOutUserRoutine.fulfill());
  }
}

/**
 * After successful log out user saga.
 */
function* afterLogOutUserSaga() {
  // eslint-disable-next-line no-undef
  yield window.location = '/login?logout';
}

export function* appSagas() {
  yield takeEvery(bootstrapAppRoutine.TRIGGER, bootstrapAppSaga);
  yield takeEvery(logOutUserRoutine.TRIGGER, logOutUserSaga);
  yield takeEvery(logOutUserRoutine.FULFILL, afterLogOutUserSaga);
}
