import 'babel-polyfill';

import React from 'react';
import ReactDOM from 'react-dom';

import Root from './core/root';

import '../node_modules/font-awesome/css/font-awesome.css';
import '../node_modules/bootstrap-css-only/css/bootstrap.css';
import './styles/styles.css';

const render = (Component) => {
  ReactDOM.render(
    <Component />,
    // eslint-disable-next-line no-undef
    document.getElementById('root'),
  );
};

render(Root);
