import React from 'react';
import { Provider } from 'react-redux';
import { HashRouter as Router } from 'react-router-dom';

import { store } from './store';
import AppView from '../app/app-view';

const Root = () => (
  <Provider store={store}>
    <React.Fragment>
      <Router>
        <AppView />
      </Router>
    </React.Fragment>
  </Provider>
);

export default Root;
