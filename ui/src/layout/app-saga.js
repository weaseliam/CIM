import { takeEvery, call, put } from 'redux-saga/effects';

import { getLoggedInUser, logOutUser } from './app-api';
import { ACTION_START, ACTION_SUCCESS, ACTION_ERROR } from '../core/constants';
import {
  bootstrapAppAction,
  fetchLoggedInUserAction,
  logOutUserAction,
  BOOTSTRAP_APP, LOG_OUT_USER
} from './app-actions';
import { changeLanguageSaga } from '../i18n/i18n-saga';

function* fetchLoggedInUserSaga() {
  try {
    yield put(fetchLoggedInUserAction(undefined, ACTION_START));

    const user = yield call(getLoggedInUser);

    yield put(fetchLoggedInUserAction(user, ACTION_SUCCESS));
  } catch (error) {
    yield put(fetchLoggedInUserAction(error.response.data, ACTION_ERROR));
  }
}

function* bootstrapAppSaga() {
  try {
    yield put(bootstrapAppAction(undefined, ACTION_START));

    yield call(fetchLoggedInUserSaga);
    yield call(changeLanguageSaga);

    yield put(bootstrapAppAction(undefined, ACTION_SUCCESS));
  } catch (error) {
    yield put(bootstrapAppAction(error.response.data, ACTION_ERROR));
  }
}

function* logOutUserSaga() {
  try {
    yield put(logOutUserAction(ACTION_START));

    yield call(logOutUser);

    yield put(logOutUserAction(ACTION_SUCCESS));
  } catch (error) {
    yield put(logOutUserAction(ACTION_ERROR));
  }
}

function* afterLogOutUserSaga() {
  // eslint-disable-next-line
  yield window.location = "/login?logout";
}

export default function* appSagas() {
  yield takeEvery(BOOTSTRAP_APP, bootstrapAppSaga);
  yield takeEvery(LOG_OUT_USER, logOutUserSaga);
  yield takeEvery(`${LOG_OUT_USER}${ACTION_SUCCESS}`, afterLogOutUserSaga);
}
