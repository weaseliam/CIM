import { takeLatest, call, put } from 'redux-saga/effects';

import { setAppLoadingContentAction } from '../../app/app-actions';
import { fetchExpiredContractListAction, fetchToExpireContractListAction } from './status-actions';
import { fetchStatusContractList } from './status-api';

function* fetchStatusContractListSaga({ page, size, dte, resultAction }) {
  try {
    yield put(setAppLoadingContentAction.success(true));

    const contractList = yield call(fetchStatusContractList, {
      page, size, dte
    });

    yield put(resultAction.success(contractList));
  } finally {
    yield put(setAppLoadingContentAction.success(false));
  }
}

function* fetchExpiredContractListSaga(action) {
  const { page, size } = action.payload || {};
  yield call(fetchStatusContractListSaga, {
    page,
    size,
    dte: 0,
    resultAction: fetchExpiredContractListAction
  });
}

function* fetchToExpireContractListSaga(action) {
  const { page, size } = action.payload || {};
  yield call(fetchStatusContractListSaga, {
    page,
    size,
    dte: 30,
    resultAction: fetchToExpireContractListAction
  });
}

export function* statusSagas() {
  yield takeLatest(fetchExpiredContractListAction.TRIGGER, fetchExpiredContractListSaga);
  yield takeLatest(fetchToExpireContractListAction.TRIGGER, fetchToExpireContractListSaga);
}
