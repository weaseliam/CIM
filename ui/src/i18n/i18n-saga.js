import { takeEvery, call, put } from 'redux-saga/effects';

import { ACTION_START, ACTION_SUCCESS, ACTION_ERROR } from '../core/constants';
import { changeLanguageAction, CHANGE_LANGUAGE } from './i18n-actions';
import fetchDictionary from './i18n-api';

export function* changeLanguageSaga() {
  try {
    yield put(changeLanguageAction(undefined, ACTION_START));

    const dictionary = yield call(fetchDictionary);

    yield put(changeLanguageAction(dictionary, ACTION_SUCCESS));
  } catch (error) {
    yield put(changeLanguageAction(error.response.data, ACTION_ERROR));
  }
}

export default function* i18nSagas() {
  yield takeEvery(CHANGE_LANGUAGE, changeLanguageSaga);
}
