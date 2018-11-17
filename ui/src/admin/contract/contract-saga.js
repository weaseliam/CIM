import { takeLatest, call, put } from 'redux-saga/effects';
import { map, prop } from 'ramda';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchContractListAction, fetchContractListWithGravesAction } from './contract-actions';
import { fetchContractList } from './contract-api';
import { fetchGraveListSaga } from '../grave/grave-saga';

function* fetchContractListSaga(action) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const { page, size, sort, graveownerId } = action.payload || {};

    const contractList = yield call(fetchContractList, {
      page, size, sort, graveownerId
    });

    yield put(fetchContractListAction.success(contractList));
    return contractList;
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

function* fetchContractListWithGravesSaga(action) {
  const contractList = yield call(fetchContractListSaga, action);
  const contractIds = map(prop('id'), contractList.contracts);
  yield call(fetchGraveListSaga, { payload: { contractIds } });
}

export function* contractSagas() {
  yield takeLatest(fetchContractListWithGravesAction.TRIGGER, fetchContractListWithGravesSaga);
}
