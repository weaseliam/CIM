const getRoot = state =>
  state.graveyard;

export const graveyardMapSelector = state =>
  getRoot(state).map;
