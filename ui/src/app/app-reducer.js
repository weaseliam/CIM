import { fetchLoggedInUserAction, bootstrapAppAction, setAppLoadingContentAction } from './app-actions';

export const INITIAL_STATE = {
  session: null,
  loading: false,
  loadingContent: false
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

    case setAppLoadingContentAction.SUCCESS:
      return {
        ...state,
        loadingContent: action.payload
      };

    default:
      return state;
  }
};
