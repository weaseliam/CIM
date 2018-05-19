import { fetchGraveownerListAction } from './graveowner-list-actions';

export const INITIAL_STATE = {
  list: {}
};

export const graveownerListReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchGraveownerListAction.SUCCESS: {
      const { graveowners = [] } = state.list;
      const { page = 1 } = action.payload;
      const newState = {
        ...state,
        list: action.payload
      };

      if (page > 1) {
        newState.list.graveowners.unshift(...graveowners);
      }

      return newState;
    }

    default:
      return state;
  }
};
