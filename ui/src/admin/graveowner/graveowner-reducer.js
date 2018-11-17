import { fetchGraveownerListAction, setGraveownerListSelectedIndexAction } from './graveowner-actions';

export const INITIAL_STATE = {
  list: {},
  selectedIndex: null
};

export const graveownerReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchGraveownerListAction.SUCCESS: {
      const { graveowners = [] } = state.list;
      const { page = 1 } = action.payload;
      const newState = {
        ...state,
        list: action.payload
      };

      if (page > 1) {
        newState.list.graveowners = graveowners.concat(action.payload.graveowners);
      }

      return newState;
    }

    case setGraveownerListSelectedIndexAction.SUCCESS: {
      return {
        ...state,
        selectedIndex: action.payload
      };
    }

    default:
      return state;
  }
};
