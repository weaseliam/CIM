const getRootState = state =>
  state.graveownerList;

export const graveownerListSelector = state =>
  getRootState(state).list;
