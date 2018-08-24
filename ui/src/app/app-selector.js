const getRoot = state =>
  state.app;

export const appLoadingContentSelector = state =>
  getRoot(state).loadingContent > 0;

export const appLoadingSelector = state =>
  getRoot(state).loading > 0;

export const appUserSelector = state =>
  getRoot(state).session.user;

export const appBootstrapSelector = state =>
  getRoot(state).bootstrap;
