import { configure } from '@storybook/react';
import '../node_modules/font-awesome/css/font-awesome.css';
import '../src/styles/styles.css';

const req = require.context('../src', true, /\.story\.jsx?$/);

function loadStories() {
  req.keys().forEach(req)
}

configure(loadStories, module);
