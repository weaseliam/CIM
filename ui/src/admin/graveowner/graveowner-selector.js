const getRoot = state =>
  state.graveowner;

export const graveownerListSelector = state =>
  getRoot(state).list;
