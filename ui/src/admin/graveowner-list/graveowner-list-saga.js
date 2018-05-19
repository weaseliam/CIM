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

    const { page = 1, size = 100, sort = 'id' } = action.payload || {};
    const graveownerList = yield call(fetchGraveownerList, { page, size, sort });

    yield put(fetchGraveownerListAction.success(graveownerList));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

export function* graveownerListSagas() {
  yield takeLatest(fetchGraveownerListAction.TRIGGER, fetchGraveownerListSaga);
}
