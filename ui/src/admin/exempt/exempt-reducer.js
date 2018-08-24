import { fetchExemptMapAction } from './exempt-actions';

export const INITIAL_STATE = {
  map: {}
};

export const exemptReducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case fetchExemptMapAction.SUCCESS: {
      const { exempts = {} } = action.payload;
      return {
        ...state,
        map: exempts
      };
    }

    default:
      return state;
  }
};
