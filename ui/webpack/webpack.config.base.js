const loaders = require('./webpack.loaders');

module.exports = {
  entry: [
    './src/index.jsx'
  ],

  output: {
    publicPath: '',
    path: 'target/dist'
  },

  resolve: {
    extensions: ['.js', '.jsx']
  },

  module: {
    loaders
  }
};
