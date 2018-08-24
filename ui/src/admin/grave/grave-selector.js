const getRoot = state =>
  state.grave;

export const graveListSelector = state =>
  getRoot(state).list;
