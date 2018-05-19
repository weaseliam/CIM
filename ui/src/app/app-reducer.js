import {
  fetchAppSessionAction,
  bootstrapAppAction,
  setAppLoadingContentAction,
  logOutUserAction
} from './app-actions';

export const INITIAL_STATE = {
  session: null,
  loading: false,
  loadingContent: false,
  bootstrap: false
};

export const appReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchAppSessionAction.SUCCESS:
      return {
        ...state,
        session: {
          ...action.payload
        }
      };

    case bootstrapAppAction.SUCCESS:
      return {
        ...state,
        bootstrap: true
      };

    case setAppLoadingContentAction.SUCCESS:
      return {
        ...state,
        loadingContent: action.payload
      };

    case logOutUserAction.TRIGGER:
      return {
        ...state,
        loading: true
      };

    case logOutUserAction.FULFILL:
      return {
        ...state,
        loading: false
      };

    default:
      return state;
  }
};
