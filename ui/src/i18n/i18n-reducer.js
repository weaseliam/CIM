import { ACTION_START, ACTION_SUCCESS, ACTION_ERROR } from '../core/constants';
import { CHANGE_LANGUAGE } from './i18n-actions';

export const INITIAL_STATE = {
  language: '',
  messages: {}
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    case `${CHANGE_LANGUAGE}${ACTION_SUCCESS}`: {
      const newState = action.payload;

      return newState;
    }

    case `${CHANGE_LANGUAGE}${ACTION_START}`:
    case `${CHANGE_LANGUAGE}${ACTION_ERROR}`:
    default:
      return state;
  }
}
