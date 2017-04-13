import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware, { END } from 'redux-saga';

import rootReducer from './reducers';
import rootSaga from './sagas';
import DevTools from './dev-tools';

const configureStore = () => {
  // eslint-disable-next-line
  const initialState = window.__INITIAL_STATE__;

  const sagaMiddleware = createSagaMiddleware();
  const enhancer = process.env.NODE_ENV === 'production' ?
    applyMiddleware(sagaMiddleware) :
    compose(
      applyMiddleware(sagaMiddleware),
      DevTools.instrument()
    );

  const store = createStore(
    rootReducer,
    initialState,
    enhancer
  );

  if (module && module.hot) {
    module.hot.accept('./reducers', () => {
      // eslint-disable-next-line
      const nextRootReducer = require('./reducers').default;
      store.replaceReducer(nextRootReducer);
    });
  }

  store.close = () => store.dispatch(END);
  store.runSaga = sagaMiddleware.run;
  store.runSaga(rootSaga);

  return store;
};

export default configureStore();
