const webpack = require('webpack');
const webpackConfig = require('./webpack.config.base');
const loaders = require('./webpack.loaders');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const WebpackCleanupPlugin = require('webpack-cleanup-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

webpackConfig.output.filename = '[chunkhash].js';

webpackConfig.module.loaders.push({
  test: /\.scss$/,
  loader: ExtractTextPlugin.extract({ fallback: 'style-loader', use: 'css-loader?sourceMap&localIdentName=[local]___[hash:base64:5]!postcss-loader!sass-loader?outputStyle=expanded' }),
  exclude: ['node_modules']
});

webpackConfig.plugins = [
  new WebpackCleanupPlugin(),
  new webpack.DefinePlugin({
    'process.env': {
      NODE_ENV: '"production"'
    }
  }),
  new webpack.optimize.UglifyJsPlugin({
    compress: {
      warnings: false,
      screw_ie8: true,
      drop_console: true,
      drop_debugger: true
    }
  }),
  new webpack.optimize.OccurrenceOrderPlugin(),
  new ExtractTextPlugin({
    filename: '[chunkhash].css',
    allChunks: true
  }),
  new HtmlWebpackPlugin({
    template: './src/index.html',
    files: {
      css: ['[chunkhash].css'],
      js: [webpackConfig.output.filename]
    }
  })
];

module.exports = webpackConfig;
