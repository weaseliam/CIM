import 'babel-polyfill';

import React from 'react';
import ReactDOM from 'react-dom';
import { initializeIcons } from 'office-ui-fabric-react/lib/Icons';

import Root from './core/root';

import '../node_modules/office-ui-fabric-react/dist/css/fabric.css';
import '../node_modules/font-awesome/css/font-awesome.css';
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
