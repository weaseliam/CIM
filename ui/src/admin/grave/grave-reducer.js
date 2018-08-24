import { fetchGraveListAction } from './grave-actions';
import { setGraveownerListSelectedIndexAction } from '../graveowner/graveowner-actions';

export const INITIAL_STATE = {
  list: {}
};

export const graveReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchGraveListAction.SUCCESS: {
      const { graves = [] } = state.list;
      const { page = 1 } = action.payload;
      const newState = {
        ...state,
        list: action.payload
      };

      if (page > 1) {
        newState.list.graves.unshift(...graves);
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
