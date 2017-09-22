const ExtractTextPlugin = require('extract-text-webpack-plugin');
const baseConfig = require('./webpack.config.base');
const plugins = require('./webpack.plugins');

const webpackConfig = baseConfig;

webpackConfig.module.loaders.push({
  test: /\.scss$/,
  loader: ExtractTextPlugin.extract({ fallback: 'style-loader', use: 'css-loader?sourceMap&modules&localIdentName=[name]__[local]___[hash:base64:5]!postcss-loader!sass-loader?outputStyle=expanded' }),
  exclude: ['node', 'node_modules']
});

webpackConfig.plugins = [
  plugins.cleanupPlugin,
  plugins.definePlugin,
  plugins.uglifyJsPlugin,
  plugins.occurrenceOrderPlugin,
  plugins.extractTextPlugin,
  plugins.commonsChunkPlugin,
  plugins.htmlWebpackPlugin
];

module.exports = webpackConfig;
