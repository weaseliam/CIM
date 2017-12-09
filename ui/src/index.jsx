import 'babel-polyfill';

import React from 'react';
import { render } from 'react-dom';
import { AppContainer } from 'react-hot-loader';

import Root from './core/root';

import '../node_modules/font-awesome/css/font-awesome.css';
import '../node_modules/bootstrap-css-only/css/bootstrap.css';
import './styles/styles.css';

const renderRootComponent = (RootComponent) => {
  // eslint-disable-next-line no-undef
  const targetElement = document.getElementById('root');

  render(
    <AppContainer>
      <RootComponent />
    </AppContainer>,
    targetElement
  );
};

renderRootComponent(Root);

if (module && module.hot) {
  module.hot.accept('./core/root.jsx', () => {
    // eslint-disable-next-line global-require
    const NextRoot = require('./core/root.jsx').default;
    renderRootComponent(NextRoot);
  });
}
