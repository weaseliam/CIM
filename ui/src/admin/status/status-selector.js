const getRoot = state =>
  state.status;

export const expiredContractListSelector = state =>
  getRoot(state).contract.expired;

export const toExpireContractListSelector = state =>
  getRoot(state).contract.toExpire;
