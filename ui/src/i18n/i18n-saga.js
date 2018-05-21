import { takeLatest, call, put, select } from 'redux-saga/effects';

import { changeLanguageAction, fetchSupportedLanguagesAction } from './i18n-actions';
import { fetchDictionary, fetchSupportedLanguages } from './i18n-api';
import { currentLanguageSelector } from './i18n-selector';
import { setAppLoadingAction } from '../app/app-actions';

/**
 * Change app language saga
 */
export function* changeLanguageSaga(action) {
  try {
    yield put(setAppLoadingAction.success(true));

    const language = yield select(currentLanguageSelector);
    if (action.payload && action.payload === language) {
      return;
    }

    const dictionary = yield call(fetchDictionary, action.payload);
    yield put(changeLanguageAction.success(dictionary));
  } finally {
    yield put(setAppLoadingAction.success(false));
  }
}

/**
 * Fetch supported languages saga
 */
export function* fetchSupportedLanguagesSaga() {
  const supportedLanguages = yield call(fetchSupportedLanguages);
  yield put(fetchSupportedLanguagesAction.success(supportedLanguages));
}

export function* i18nSagas() {
  yield takeLatest(changeLanguageAction.TRIGGER, changeLanguageSaga);
}
