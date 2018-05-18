const getRoot = state =>
  state.app;

export const appLoadingContentSelector = state =>
  getRoot(state).loadingContent;

export const appLoadingSelector = state =>
  getRoot(state).loading;

export const appSessionSelector = state =>
  getRoot(state).session;
