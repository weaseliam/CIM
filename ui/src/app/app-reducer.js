import { fetchLoggedInUserAction, bootstrapAppAction } from './app-actions';

export const INITIAL_STATE = {
  session: {
    user: {
      userName: '',
      firstName: '',
      lastName: '',
      email: ''
    }
  },
  loading: false
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

    case bootstrapAppAction.TRIGGER:
      return {
        ...state,
        loading: true
      };

    case bootstrapAppAction.FULFILL:
      return {
        ...state,
        loading: false
      };

    default:
      return state;
  }
};
