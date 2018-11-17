const getRoot = state =>
  state.grave;

export const graveListSelector = state =>
  getRoot(state).list;

export const graveMapSelector = state =>
  getRoot(state).map;
