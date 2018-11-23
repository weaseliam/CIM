import { fetchGraveListAction } from './grave-actions';
import { setGraveownerListSelectedIndexAction } from '../graveowner/graveowner-actions';

export const INITIAL_STATE = {
  list: {},
  map: {}
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

      let map = {};
      if (page > 1) {
        newState.list.graves = graves.concat(action.payload.graves);
        map = Object.assign({}, state.map);
      }

      for (const grave of action.payload.graves) {
        map[grave.id] = grave;
      }
      newState.map = map;

      return newState;
    }

    case setGraveownerListSelectedIndexAction.SUCCESS: {
      const selectedIndex = action.payload;
      if (!selectedIndex) {
        return {
          ...state,
          list: {},
          map: {}
        };
      }

      return state;
    }

    default:
      return state;
  }
};
