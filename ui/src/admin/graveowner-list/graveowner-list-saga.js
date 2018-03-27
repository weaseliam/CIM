import { takeLatest, call, put } from 'redux-saga/effects';

import { fetchGraveownerList } from './graveowner-list-api';
import { fetchGraveownerListAction } from './graveowner-list-actions';
import { setAppLoadingContentAction } from '../../app/app-actions';

/**
 * Fetch graveowners saga.
 */
function* fetchGraveownerListSaga(action) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const { page } = action.payload || {};
    const graveownerList = yield call(fetchGraveownerList, page);

    yield put(fetchGraveownerListAction.success(graveownerList));
    yield put(setAppLoadingContentAction.success(false));
  } catch (error) {
    yield put(fetchGraveownerListAction.failure());
    yield put(setAppLoadingContentAction.success(false));
  }
}

export function* graveownerListSagas() {
  yield takeLatest(fetchGraveownerListAction.TRIGGER, fetchGraveownerListSaga);
}
