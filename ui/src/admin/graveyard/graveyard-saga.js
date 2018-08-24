import { call, put } from 'redux-saga/effects';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchGraveyardMap } from './graveyard-api';
import { fetchGraveyardMapAction } from './graveyard-actions';

export function* fetchGraveyardMapSaga() {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const graveyardMap = yield call(fetchGraveyardMap);

    yield put(fetchGraveyardMapAction.success(graveyardMap));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}
