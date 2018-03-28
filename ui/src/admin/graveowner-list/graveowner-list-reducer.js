import { fetchGraveownerListAction } from './graveowner-list-actions';

export const INITIAL_STATE = {
  list: {},
  loading: false
};

export const graveownerListReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchGraveownerListAction.SUCCESS: {
      const { graveowners = [] } = state.list;
      const { page = 1 } = action.payload;
      const newState = {
        ...state,
        list: action.payload,
        loading: false
      };

      if (page > 1) {
        newState.list.graveowners.unshift(...graveowners);
      }

      return newState;
    }

    case fetchGraveownerListAction.TRIGGER:
      return {
        ...state,
        loading: true
      };

    case fetchGraveownerListAction.FAILURE:
      return {
        ...state,
        loading: false
      };

    default:
      return state;
  }
};
