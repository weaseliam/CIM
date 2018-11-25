import '@babel/polyfill';

import React from 'react';
import ReactDOM from 'react-dom';
import { initializeIcons } from 'office-ui-fabric-react/lib/Icons';

import Root from './core/root';
import './styles/styles.css';

const render = (Component) => {
  ReactDOM.render(
    <Component />,
    // eslint-disable-next-line no-undef
    document.getElementById('root'),
  );
};

initializeIcons();
render(Root);
