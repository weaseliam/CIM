const webpack = require('webpack');
const webpackConfig = require('./webpack.config.base');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const DashboardPlugin = require('webpack-dashboard/plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const HOST = process.env.HOST || '127.0.0.1';
const PORT = process.env.PORT || '3000';

webpackConfig.entry.unshift('react-hot-loader/patch');

webpackConfig.devtool = process.env.WEBPACK_DEVTOOL || 'eval-source-map';

webpackConfig.output.path = '/' + webpackConfig.output.path;
webpackConfig.output.filename = 'bundle.js';

webpackConfig.module.loaders.push({
  test: /\.scss$/,
  loaders: ['style-loader', 'css-loader?importLoaders=1', 'postcss-loader', 'sass-loader'],
  exclude: ['node_modules']
});

webpackConfig.devServer = {
  contentBase: './target/dist',
  noInfo: true,
  hot: true,
  inline: true,
  historyApiFallback: true,
  port: PORT,
  host: HOST
};

webpackConfig.plugins = [
  new webpack.NoEmitOnErrorsPlugin(),
  new webpack.HotModuleReplacementPlugin(),
  new ExtractTextPlugin({
    filename: 'style.css',
    allChunks: true
  }),
  new DashboardPlugin(),
  new HtmlWebpackPlugin({
    template: './src/index.html',
    files: {
      css: ['style.css'],
      js: [webpackConfig.output.filename]
    }
  })
]

module.exports = webpackConfig;
