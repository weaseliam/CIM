const webpackConfig = require('./webpack.config.base');
const plugins = require('./webpack.plugins');
const prodRules = require('./webpack.rules.prod');

webpackConfig.mode = 'production';

webpackConfig.module.rules.push(...prodRules);

webpackConfig.optimization.minimizer = [
  plugins.uglifyJsPlugin,
  plugins.cssOptimizePlugin
]

webpackConfig.plugins = [
  plugins.cleanupPlugin,
  plugins.occurrenceOrderPlugin,
  plugins.cssExtractPlugin,
  plugins.htmlWebpackPlugin,
  plugins.compressionPlugin
];

module.exports = webpackConfig;
