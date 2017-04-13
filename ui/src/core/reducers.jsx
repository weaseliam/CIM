import { combineReducers } from 'redux';

export default combineReducers({
  // eslint-disable-next-line
  app: function (state, action) { if (state == null) state = []; return state; }
});
