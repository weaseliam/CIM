const webpack = require('webpack');
const baseConfig = require('./webpack.config.base');
const WebpackCleanupPlugin = require('webpack-cleanup-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const webpackConfig = {};

webpackConfig.entry = baseConfig.entry;

webpackConfig.output = baseConfig.output;

webpackConfig.resolve = baseConfig.resolve;

webpackConfig.module = baseConfig.module;
webpackConfig.module.loaders.push({
  test: /\.scss$/,
  loader: ExtractTextPlugin.extract({ fallback: 'style-loader', use: 'css-loader?sourceMap&modules&localIdentName=[name]__[local]___[hash:base64:5]!postcss-loader!sass-loader?outputStyle=expanded' }),
  exclude: ['node_modules']
});

webpackConfig.plugins = [
  new WebpackCleanupPlugin(),
  new webpack.DefinePlugin({
    'process.env.NODE_ENV': JSON.stringify('production')
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
  baseConfig.extractTextPlugin,
  baseConfig.htmlWebpackPlugin
];

module.exports = webpackConfig;
