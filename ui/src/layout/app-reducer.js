import { fetchLoggedInUserAction } from './app-actions';

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
    case fetchLoggedInUserAction.SUCCESS:
      return {
        ...state,
        session: {
          user: action.payload
        }
      };

    default:
      return state;
  }
};
