import { takeLatest, call, put } from 'redux-saga/effects';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchGraveListAction } from './grave-actions';
import { fetchGraveList } from './grave-api';

/**
 * Fetch grave list saga.
 */
function* fetchGraveListSaga(action) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const { page, size, sort, graveownerId } = action.payload || {};

    const graveList = yield call(fetchGraveList, {
      page, size, sort, graveownerId
    });

    yield put(fetchGraveListAction.success(graveList));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

export function* graveSagas() {
  yield takeLatest(fetchGraveListAction.TRIGGER, fetchGraveListSaga);
}
