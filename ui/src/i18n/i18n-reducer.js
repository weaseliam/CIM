import { changeLanguageAction, fetchSupportedLanguagesAction } from './i18n-actions';

export const INITIAL_STATE = {
  language: '',
  messages: {},
  languages: []
};

export const i18nReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case changeLanguageAction.SUCCESS:
      return {
        ...state,
        ...action.payload
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
