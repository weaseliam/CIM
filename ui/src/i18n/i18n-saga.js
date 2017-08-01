import { takeLatest, call, put } from 'redux-saga/effects';

import { changeLanguageRoutine } from './i18n-routines';
import fetchDictionary from './i18n-api';

/**
 * Change app language saga
 */
export function* changeLanguageSaga() {
  try {
    const dictionary = yield call(fetchDictionary);

    yield put(changeLanguageRoutine.success(dictionary));
  } catch (error) {
    yield put(changeLanguageRoutine.failure(error.response.data));
  }
}

export default function* i18nSagas() {
  yield takeLatest(changeLanguageRoutine.TRIGGER, changeLanguageSaga);
}
