import { changeLanguageRoutine } from './i18n-routines';

export const INITIAL_STATE = {
  language: '',
  messages: {}
};

export const i18nReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case changeLanguageRoutine.SUCCESS: {
      const newState = action.payload;

      return newState;
    }

    default:
      return state;
  }
};
