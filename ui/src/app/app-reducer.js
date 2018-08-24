import {
  fetchAppSessionAction,
  bootstrapAppAction,
  setAppLoadingContentAction,
  setAppLoadingAction
} from './app-actions';

export const INITIAL_STATE = {
  session: null,
  loading: 0,
  loadingContent: 0,
  bootstrap: false
};

const newLoading = (currentLoading, increment) => {
  if (currentLoading === 0 && increment === -1) {
    return 0;
  }

  return currentLoading + increment;
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

    case setAppLoadingContentAction.SUCCESS: {
      const currentLoading = state.loadingContent;
      const increment = action.payload ? 1 : -1;

      return {
        ...state,
        loadingContent: newLoading(currentLoading, increment)
      };
    }

    case setAppLoadingAction.SUCCESS: {
      const currentLoading = state.loading;
      const increment = action.payload ? 1 : -1;

      return {
        ...state,
        loading: newLoading(currentLoading, increment)
      };
    }

    default:
      return state;
  }
};
