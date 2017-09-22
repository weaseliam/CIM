const path = require('path');
const loaders = require('./webpack.loaders');
const pkgJson = require('../package.json');

module.exports = {
  entry: {
    app: ['./src/index.jsx'],
    vendor: Object.keys(pkgJson.dependencies)
  },

  devtool: 'cheap-source-map',

  output: {
    publicPath: '',
    path: path.resolve(__dirname, '../target/dist'),
    filename: 'app.[hash:8].js'
  },

  resolve: {
    extensions: ['.js', '.jsx']
  },

  module: {
    exprContextCritical: false,
    loaders
  }
};
