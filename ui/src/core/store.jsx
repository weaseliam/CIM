import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware, { END } from 'redux-saga';

import { rootReducer } from './reducers';
import { rootSaga } from './sagas';

const configureStore = () => {
  // eslint-disable-next-line
  const initialState = window.__INITIAL_STATE__;

  const sagaMiddleware = createSagaMiddleware();
  const enhancer = process.env.NODE_ENV === 'production'
    ? applyMiddleware(sagaMiddleware)
    // eslint-disable-next-line
    : (window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose)(
      applyMiddleware(sagaMiddleware)
    );

  const store = createStore(
    rootReducer,
    initialState,
    enhancer
  );

  if (module && module.hot) {
    module.hot.accept('./reducers', () => {
      // eslint-disable-next-line global-require
      const nextRootReducer = require('./reducers').rootReducer;
      store.replaceReducer(nextRootReducer);
    });
  }

  store.close = () => store.dispatch(END);
  store.runSaga = sagaMiddleware.run;
  store.runSaga(rootSaga);

  return store;
};

export const store = configureStore();
