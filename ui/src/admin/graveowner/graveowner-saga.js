import { takeLatest, call, put } from 'redux-saga/effects';
import { isNil } from 'ramda';

import { fetchGraveownerList } from './graveowner-api';
import { fetchGraveownerListAction, setGraveownerListSelectedIndexAction } from './graveowner-actions';
import { setAppLoadingContentAction } from '../../app/app-actions';

/**
 * Fetch graveowners saga.
 */
function* fetchGraveownerListSaga(action) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const { page, size, sort, filter } = action.payload || {};

    // reset selected index on graveowners refresh
    if (isNil(page) || page === 1) {
      yield put(setGraveownerListSelectedIndexAction.success(null));
    }

    const graveownerList = yield call(fetchGraveownerList, {
      page, size, sort, filter: filter || {}
    });

    yield put(fetchGraveownerListAction.success(graveownerList));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

export function* graveownerSagas() {
  yield takeLatest(fetchGraveownerListAction.TRIGGER, fetchGraveownerListSaga);
}
