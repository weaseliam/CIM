import { takeLatest, call, put } from 'redux-saga/effects';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchStatusContractListAction } from './status-actions';
import { fetchStatusContractList } from './status-api';

function* fetchStatusContractListSaga(action) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const { page, size, dte } = action.payload || {};

    const contractList = yield call(fetchStatusContractList, {
      page, size, dte
    });

    yield put(fetchStatusContractListAction.success(contractList));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

export function* statusSagas() {
  yield takeLatest(fetchStatusContractListAction.TRIGGER, fetchStatusContractListSaga);
}
