import { fetchLoggedInUserRoutine } from './app-routines';

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

export const appReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchLoggedInUserRoutine.SUCCESS: {
      const newState = { ...state };
      newState.session.user = action.payload;

      return newState;
    }

    default:
      return state;
  }
};
