import { takeEvery, call, put } from 'redux-saga/effects';

import { getLoggedInUser } from '../apis/app-api';
import { ACTION_START, ACTION_SUCCESS, ACTION_ERROR } from '../../core/constants';
import { fetchLoggedInUser, FETCH_LOGGED_IN_USER } from '../actions/app-actions';

function* fetchLoggedInUserSaga() {
  try {
    yield put(fetchLoggedInUser(null, ACTION_START));
    const user = yield call(getLoggedInUser);

    yield put(fetchLoggedInUser(user, ACTION_SUCCESS));
  } catch (error) {
    yield put(fetchLoggedInUser(error.response.data, ACTION_ERROR));
  }
}

export default function* appSagas() {
  yield takeEvery(FETCH_LOGGED_IN_USER, fetchLoggedInUserSaga);
}
