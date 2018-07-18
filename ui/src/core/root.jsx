import React from 'react';
import { Provider } from 'react-redux';
import { HashRouter as Router } from 'react-router-dom';

import { store } from './store';
import AppView from '../app/app-view';

const Root = () => (
  <Provider store={store}>
    <Router>
      <AppView />
    </Router>
  </Provider>
);

export default Root;
