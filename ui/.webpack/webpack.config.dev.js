const webpackConfig = require('./webpack.config.base');
const plugins = require('./webpack.plugins');
const envConfig = require('../.env.js');
const devRules = require('./webpack.rules.dev');

webpackConfig.mode = 'development';

webpackConfig.devtool = 'inline-source-map';

webpackConfig.module.rules.push(...devRules);

webpackConfig.plugins = [
  plugins.noEmitOnErrorsPlugin,
  plugins.hotModuleReplacementPlugin,
  plugins.cssExtractPlugin,
  plugins.htmlWebpackPlugin
];

webpackConfig.devServer = {
  contentBase: './target/dist',
  noInfo: false,
  hot: true,
  inline: true,
  historyApiFallback: true,
  host: envConfig.DEV_SERVER_HOST,
  port: envConfig.DEV_SERVER_PORT,
  stats: {
    assets: false,
    colors: true,
    version: false,
    hash: false,
    timings: false,
    chunks: false,
    chunkModules: false
  },
  proxy: {
    '/': {
      target: `${envConfig.WEB_SERVER_SCHEME}://${envConfig.WEB_SERVER_HOST}:${envConfig.WEB_SERVER_PORT}/${envConfig.WEB_SERVER_PATH}`,
      secure: envConfig.WEB_SERVER_SCHEME === 'https'
    }
  }
};

module.exports = webpackConfig;
