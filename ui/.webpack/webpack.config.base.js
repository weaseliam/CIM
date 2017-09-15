const path = require('path');
const loaders = require('./webpack.loaders');

module.exports = {
  entry: ['./src/index.jsx'],

  devtool: 'cheap-source-map',

  output: {
    publicPath: '',
    path: path.resolve(__dirname, '../target/dist'),
    filename: 'bundle.js'
  },

  resolve: {
    extensions: ['.js', '.jsx']
  },

  module: {
    exprContextCritical: false,
    loaders
  }
};
