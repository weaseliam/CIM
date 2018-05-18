const getRoot = state =>
  state.graveownerList;

export const graveownerListSelector = state =>
  getRoot(state).list;
