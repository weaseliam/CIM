import { takeLatest, call, put, select } from 'redux-saga/effects';

import { changeLanguageAction, fetchSupportedLanguagesAction } from './i18n-actions';
import { fetchDictionary, fetchSupportedLanguages } from './i18n-api';
import { currentLanguageSelector } from './i18n-selector';

/**
 * Change app language saga
 */
export function* changeLanguageSaga(action) {
  try {
    const language = yield select(currentLanguageSelector);
    if (action.payload && action.payload === language) {
      return;
    }

    const dictionary = yield call(fetchDictionary, action.payload);

    yield put(changeLanguageAction.success(dictionary));
  } catch (error) {
    yield put(changeLanguageAction.failure());
  }
}

/**
 * Fetch supported languages saga
 */
export function* fetchSupportedLanguagesSaga() {
  try {
    const supportedLanguages = yield call(fetchSupportedLanguages);

    yield put(fetchSupportedLanguagesAction.success(supportedLanguages));
  } catch (error) {
    yield put(fetchSupportedLanguagesAction.failure());
  }
}

export function* i18nSagas() {
  yield takeLatest(changeLanguageAction.TRIGGER, changeLanguageSaga);
}
