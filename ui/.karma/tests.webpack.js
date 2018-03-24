require("babel-polyfill");

// Configure enzyme
const enzyme = require('enzyme');
const adapter = require('enzyme-adapter-react-16');
enzyme.configure({ adapter: new adapter() });

// Test files to run
const context = require.context('../src', true, /\.test\.jsx?$/);
context.keys().forEach(context);
