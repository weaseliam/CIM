import { takeLatest, call, put } from 'redux-saga/effects';

import { changeLanguageRoutine } from './i18n-routines';
import { fetchDictionary } from './i18n-api';

/**
 * Change app language saga
 */
export function* changeLanguageSaga(action) {
  try {
    const dictionary = yield call(fetchDictionary, action.payload);

    yield put(changeLanguageRoutine.success(dictionary));
  } catch (error) {
    yield put(changeLanguageRoutine.failure(error.response.data));
  }
}

export function* i18nSagas() {
  yield takeLatest(changeLanguageRoutine.TRIGGER, changeLanguageSaga);
}
