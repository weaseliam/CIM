const getRoot = state =>
  state.exempt;

export const exemptMapSelector = state =>
  getRoot(state).map;
