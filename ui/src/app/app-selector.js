const getRoot = state =>
  state.app;

export const appLoadingContentSelector = state =>
  getRoot(state).loadingContent;

export const appLoadingSelector = state =>
  getRoot(state).loading;

export const appUserSelector = state =>
  getRoot(state).session.user;

export const appBootstrapSelector = state =>
  getRoot(state).bootstrap;
