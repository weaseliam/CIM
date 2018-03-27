const getRootState = state =>
  state.app;

export const loggedInUserSelector = state =>
  getRootState(state).session.user;

export const appLoadingContentSelector = state =>
  getRootState(state).loadingContent;
