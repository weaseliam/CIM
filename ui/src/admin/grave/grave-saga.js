import { takeLatest, call, put } from 'redux-saga/effects';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchGraveListAction } from './grave-actions';
import { fetchGraveList } from './grave-api';

export function* fetchGraveListSaga(action) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const { page, size, sort, contractIds } = action.payload || {};

    const graveList = yield call(fetchGraveList, {
      page, size, sort, contractIds
    });

    yield put(fetchGraveListAction.success(graveList));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

export function* graveSagas() {
  yield takeLatest(fetchGraveListAction.TRIGGER, fetchGraveListSaga);
}
