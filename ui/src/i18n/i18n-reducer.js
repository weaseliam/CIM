import { changeLanguageAction } from './i18n-actions';

export const INITIAL_STATE = {
  language: '',
  messages: {}
};

export const i18nReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case changeLanguageAction.SUCCESS:
      return {
        ...state,
        ...action.payload
      };

    default:
      return state;
  }
};
