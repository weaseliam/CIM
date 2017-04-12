const webpack = require('webpack');
const baseConfig = require('./webpack.config.base');

const HOST = process.env.HOST || '127.0.0.1';
const PORT = process.env.PORT || '3000';

const webpackConfig = {};

webpackConfig.entry = [
  'webpack-dev-server/client?http://' + HOST + ':' + PORT,
  'webpack/hot/only-dev-server',
  'react-hot-loader/patch',
  baseConfig.entry
];

webpackConfig.devtool = process.env.WEBPACK_DEVTOOL || 'eval-source-map';

webpackConfig.output = baseConfig.output;
webpackConfig.output.path = '/' + webpackConfig.output.path;

webpackConfig.resolve = baseConfig.resolve;

webpackConfig.module = baseConfig.module;
webpackConfig.module.loaders.push({
  test: /\.scss$/,
  loaders: ['style-loader', 'css-loader?importLoaders=1&modules&localIdentName=[name]__[local]___[hash:base64:5]', 'postcss-loader', 'sass-loader'],
  exclude: ['node_modules']
});

webpackConfig.devServer = {
  contentBase: './target/dist',
  noInfo: false,
  hot: true,
  inline: true,
  historyApiFallback: true,
  port: PORT,
  host: HOST,
  stats: {
    assets: false,
    colors: true,
    version: false,
    hash: false,
    timings: false,
    chunks: false,
    chunkModules: false
  }
};

webpackConfig.plugins = [
  new webpack.NoEmitOnErrorsPlugin(),
  new webpack.HotModuleReplacementPlugin(),
  new webpack.NamedModulesPlugin(),
  baseConfig.extractTextPlugin,
  baseConfig.htmlWebpackPlugin
];

module.exports = webpackConfig;
