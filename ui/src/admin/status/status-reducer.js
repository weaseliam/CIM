import { fetchStatusContractListAction } from './status-actions';

export const INITIAL_STATE = {
  contract: {
    list: {}
  },
  invoice: {}
};

export const statusReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchStatusContractListAction.SUCCESS:
      return {
        ...state,
        contract: {
          ...state.contract,
          list: action.payload
        }
      };

    default:
      return state;
  }
};
