import { combineReducers } from 'redux';

export default combineReducers({
  app: function (state, action) { if (state == null) state = []; return state; }
});
