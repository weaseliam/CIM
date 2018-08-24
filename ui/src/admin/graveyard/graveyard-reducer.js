import { fetchGraveyardMapAction } from './graveyard-actions';

export const INITIAL_STATE = {
  map: {}
};

export const graveyardReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchGraveyardMapAction.SUCCESS: {
      const { graveyards = {} } = action.payload;
      return {
        ...state,
        map: graveyards
      };
    }

    default:
      return state;
  }
};
