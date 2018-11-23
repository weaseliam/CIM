import { changeLanguageAction, fetchSupportedLanguagesAction } from './i18n-actions';

import { DEFAULT_DATE_FORMAT } from '../core/constants';
import { DATE_FORMAT } from './i18n-constants';

export const INITIAL_STATE = {
  language: '',
  messages: {},
  languages: [],
  formats: {}
};

export const i18nReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case changeLanguageAction.SUCCESS:
      return {
        ...state,
        ...action.payload,
        formats: {
          date: action.payload.messages[DATE_FORMAT] || DEFAULT_DATE_FORMAT
        }
      };

    case fetchSupportedLanguagesAction.SUCCESS:
      return {
        ...state,
        languages: action.payload
      };

    default:
      return state;
  }
};
