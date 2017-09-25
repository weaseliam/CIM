import { takeLatest, call, put } from 'redux-saga/effects';

import { changeLanguageAction } from './i18n-actions';
import { fetchDictionary } from './i18n-api';

/**
 * Change app language saga
 */
export function* changeLanguageSaga(action) {
  try {
    const dictionary = yield call(fetchDictionary, action.payload);

    yield put(changeLanguageAction.success(dictionary));
  } catch (error) {
    yield put(changeLanguageAction.failure(error.response.data));
  }
}

export function* i18nSagas() {
  yield takeLatest(changeLanguageAction.TRIGGER, changeLanguageSaga);
}
