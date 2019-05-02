import { fetchExpiredContractListAction, fetchToExpireContractListAction } from './status-actions';

export const INITIAL_STATE = {
  contract: {
    expired: {},
    toExpire: {}
  }
};

export const statusReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchExpiredContractListAction.SUCCESS:
      return {
        ...state,
        contract: {
          ...state.contract,
          expired: action.payload
        }
      };

    case fetchToExpireContractListAction.SUCCESS:
      return {
        ...state,
        contract: {
          ...state.contract,
          toExpire: action.payload
        }
      };

    default:
      return state;
  }
};
