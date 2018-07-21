import React from 'react';
import { Provider } from 'react-redux';
import { HashRouter as Router } from 'react-router-dom';

import { store } from './store';
import AppView from '../app/app-view';
import I18nProvider from '../i18n/i18n-provider';

const Root = () => (
  <Provider store={store}>
    <I18nProvider>
      <Router>
        <AppView />
      </Router>
    </I18nProvider>
  </Provider>
);

export default Root;
