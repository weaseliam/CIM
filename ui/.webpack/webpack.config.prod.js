const ExtractTextPlugin = require('extract-text-webpack-plugin');
const webpackConfig = require('./webpack.config.base');
const plugins = require('./webpack.plugins');

webpackConfig.module.rules.push({
  test: /\.scss$/,
  use: ExtractTextPlugin.extract({ fallback: 'style-loader', use: 'css-loader?sourceMap&modules&localIdentName=[name]__[local]___[hash:base64:5]!postcss-loader!sass-loader?outputStyle=expanded' }),
  exclude: ['node', 'node_modules']
});

webpackConfig.plugins = [
  plugins.cleanupPlugin,
  plugins.definePlugin,
  plugins.uglifyJsPlugin,
  plugins.occurrenceOrderPlugin,
  plugins.extractTextPlugin,
  plugins.commonsChunkPlugin,
  plugins.htmlWebpackPlugin,
  plugins.compressionPlugin
];

module.exports = webpackConfig;
