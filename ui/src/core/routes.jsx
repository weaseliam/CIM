import React from 'react';
import { Route } from 'react-router-dom';

import App from '../layout/containers/app';
import Page1 from '../layout/containers/page1';

export const routes = (
  <App>
    <Route exact path="/" component={Page1} />
  </App>
);
