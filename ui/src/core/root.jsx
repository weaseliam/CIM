import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter as Router } from 'react-router-dom';

import store from './store';
import routes from './routes';
import DevTools from './dev-tools';

const Root = () => (
  <Provider store={store}>
    <div>
      <Router>
        {routes}
      </Router>
      {process.env.NODE_ENV !== 'production' ? <DevTools /> : null}
    </div>
  </Provider>
);

export default Root;
