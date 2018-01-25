import React from 'react';
import { Provider } from 'react-redux';
import { HashRouter as Router } from 'react-router-dom';
import { hot } from 'react-hot-loader';

import { store } from './store';
import App from '../layout/containers/app';
import DevTools from './dev-tools';

const Root = () => (
  <Provider store={store}>
    <div>
      <Router>
        <App />
      </Router>
      {process.env.NODE_ENV !== 'production' ? <DevTools /> : null}
    </div>
  </Provider>
);

export default hot(module)(Root);
