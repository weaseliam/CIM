import { fetchGraveownerListAction } from './graveowner-list-actions';

export const INITIAL_STATE = {
  list: [],
  loading: false
};

export const graveownerListReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchGraveownerListAction.SUCCESS:
      return {
        ...state,
        list: action.payload,
        loading: false
      };

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
