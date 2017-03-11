const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const loaders = require('./webpack.loaders');

module.exports = {
  entry: './src/index.jsx',

  output: {
    publicPath: '',
    path: 'target/dist',
    filename: 'bundle.js'
  },

  resolve: {
    extensions: ['.js', '.jsx']
  },

  module: {
    loaders
  },

  extractTextPlugin: new ExtractTextPlugin({
    filename: 'style.css',
    allChunks: true
  }),

  htmlWebpackPlugin: new HtmlWebpackPlugin({
    template: './src/index.html',
    files: {
      css: ['style.css'],
      js: ['bundle.js']
    }
  })
};
