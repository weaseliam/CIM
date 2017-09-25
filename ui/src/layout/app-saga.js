import { takeEvery, call, put } from 'redux-saga/effects';

import { getLoggedInUser, logOutUser } from './app-api';
import {
  bootstrapAppAction,
  fetchLoggedInUserAction,
  logOutUserAction
} from './app-actions';
import { changeLanguageSaga } from '../i18n/i18n-saga';

/**
 * Fetch current logged in user detail saga.
 */
function* fetchLoggedInUserSaga() {
  try {
    const user = yield call(getLoggedInUser);

    yield put(fetchLoggedInUserAction.success(user));
  } catch (error) {
    yield put(fetchLoggedInUserAction.failure(error.response.data));
  }
}

/**
 * Bootstrap application saga.
 */
function* bootstrapAppSaga() {
  try {
    yield call(fetchLoggedInUserSaga);
    yield call(changeLanguageSaga, {});

    yield put(bootstrapAppAction.success());
  } catch (error) {
    yield put(bootstrapAppAction.failure(error.response.data));
  } finally {
    yield put(bootstrapAppAction.fulfill());
  }
}

/**
 * Log out current user saga.
 */
function* logOutUserSaga() {
  try {
    yield call(logOutUser);

    yield put(logOutUserAction.success());
  } catch (error) {
    yield put(logOutUserAction.failure());
  } finally {
    yield put(logOutUserAction.fulfill());
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
  yield takeEvery(bootstrapAppAction.TRIGGER, bootstrapAppSaga);
  yield takeEvery(logOutUserAction.TRIGGER, logOutUserSaga);
  yield takeEvery(logOutUserAction.FULFILL, afterLogOutUserSaga);
}
