import { configure } from '@kadira/storybook';
import '../node_modules/font-awesome/css/font-awesome.css';
import '../src/styles/styles.scss';

const req = require.context('../src', true, /-story\.jsx?$/);

function loadStories() {
  req.keys().forEach(req)
}

configure(loadStories, module);
