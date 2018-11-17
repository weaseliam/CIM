import { fetchContractListAction } from './contract-actions';
import { setGraveownerListSelectedIndexAction } from '../graveowner/graveowner-actions';

export const INITIAL_STATE = {
  list: {}
};

export const contractReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchContractListAction.SUCCESS: {
      const { contracts = [] } = state.list;
      const { page = 1 } = action.payload;
      const newState = {
        ...state,
        list: action.payload
      };

      if (page > 1) {
        newState.list.contracts = contracts.concat(action.payload.contracts);
      }

      return newState;
    }

    case setGraveownerListSelectedIndexAction.SUCCESS: {
      const selectedIndex = action.payload;
      if (!selectedIndex) {
        return {
          ...state,
          list: {}
        };
      }

      return state;
    }

    default:
      return state;
  }
};
