/* eslint-disable */

import 'babel-polyfill';

import React from 'react';
import { render } from 'react-dom';
import { AppContainer } from 'react-hot-loader';

import Root from './core/root';
import store from './core/store';
import routes from './core/routes';

const renderRootComponent = (RootComponent) => {
  const targetElement = document.getElementById('root');

  render(
    <AppContainer>
      <RootComponent store={store} routes={routes} />
    </AppContainer>,
    targetElement
  );
}

renderRootComponent(Root);

if (module && module.hot) {
  module.hot.accept('./core/root.jsx', () => {
    const NextRoot = require('./core/root.jsx').default;
    renderRootComponent(NextRoot);
  });
}
