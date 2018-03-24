import { takeLatest, call, put } from 'redux-saga/effects';

import { fetchGraveownerList } from './graveowner-list-api';
import { fetchGraveownerListAction } from './graveowner-list-actions';

/**
 * Fetch graveowners saga.
 */
function* fetchGraveownerListSaga(action) {
  try {
    const { page } = action.payload || {};
    const graveownerList = yield call(fetchGraveownerList, page);

    yield put(fetchGraveownerListAction.success(graveownerList));
  } catch (error) {
    yield put(fetchGraveownerListAction.failure());
  }
}

export function* graveownerListSagas() {
  yield takeLatest(fetchGraveownerListAction.TRIGGER, fetchGraveownerListSaga);
}
