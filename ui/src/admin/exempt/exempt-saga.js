import { call, put } from 'redux-saga/effects';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchExemptMap } from './exempt-api';
import { fetchExemptMapAction } from './exempt-actions';

export function* fetchExemptMapSaga() {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const exemptMap = yield call(fetchExemptMap);

    yield put(fetchExemptMapAction.success(exemptMap));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}
