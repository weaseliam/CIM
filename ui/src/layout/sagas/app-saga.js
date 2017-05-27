import { takeEvery, call, put } from 'redux-saga/effects';

import { getLoggedInUser, logOutUser } from '../apis/app-api';
import { ACTION_START, ACTION_SUCCESS, ACTION_ERROR } from '../../core/constants';
import { fetchLoggedInUserAction, logOutUserAction, FETCH_LOGGED_IN_USER, LOG_OUT_USER } from '../actions/app-actions';

function* fetchLoggedInUserSaga() {
  try {
    yield put(fetchLoggedInUserAction(null, ACTION_START));
    const user = yield call(getLoggedInUser);

    yield put(fetchLoggedInUserAction(user, ACTION_SUCCESS));
  } catch (error) {
    yield put(fetchLoggedInUserAction(error.response.data, ACTION_ERROR));
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
  yield takeEvery(FETCH_LOGGED_IN_USER, fetchLoggedInUserSaga);
  yield takeEvery(LOG_OUT_USER, logOutUserSaga);
  yield takeEvery(`${LOG_OUT_USER}${ACTION_SUCCESS}`, afterLogOutUserSaga);
}
