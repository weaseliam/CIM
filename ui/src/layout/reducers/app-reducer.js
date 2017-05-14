import { ACTION_START, ACTION_SUCCESS, ACTION_ERROR } from '../../core/constants';
import { FETCH_LOGGED_IN_USER } from '../actions/app-actions';

export const INITIAL_STATE = {
  session: {
    user: {
      userName: '',
      firstName: '',
      lastName: '',
      email: ''
    }
  }
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    case `${FETCH_LOGGED_IN_USER}${ACTION_SUCCESS}`: {
      const newState = { ...state };
      newState.session.user = action.payload;

      return newState;
    }

    case `${FETCH_LOGGED_IN_USER}${ACTION_START}`:
    case `${FETCH_LOGGED_IN_USER}${ACTION_ERROR}`:
    default:
      return state;
  }
}
