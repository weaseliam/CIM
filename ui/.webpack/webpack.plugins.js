const webpack = require('webpack');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const WebpackCleanupPlugin = require('webpack-cleanup-plugin');
const CompressionPlugin = require('compression-webpack-plugin');
const OptimizeCSSAssetsPlugin = require("optimize-css-assets-webpack-plugin");
const UglifyJsPlugin = require("uglifyjs-webpack-plugin");

module.exports = {
  cssExtractPlugin: new MiniCssExtractPlugin({
    filename: 'app.[hash:8].css',
    chunkFilename: 'vendor.[hash:8].css'
  }),

  cssOptimizePlugin: new OptimizeCSSAssetsPlugin({}),

  uglifyJsPlugin: new UglifyJsPlugin({
    cache: true,
    parallel: true,
    sourceMap: true,
    uglifyOptions: {
      compress: false
    }
  }),

  htmlWebpackPlugin: new HtmlWebpackPlugin({
    template: './src/index.html',
    files: {
      css: ['app.[hash:8].css', 'vendor.[hash:8].css'],
      js: ['app.[hash:8].js', 'vendor.[hash:8].js']
    }
  }),

  noEmitOnErrorsPlugin: new webpack.NoEmitOnErrorsPlugin(),

  hotModuleReplacementPlugin: new webpack.HotModuleReplacementPlugin(),

  cleanupPlugin: new WebpackCleanupPlugin(),

  occurrenceOrderPlugin: new webpack.optimize.OccurrenceOrderPlugin(),

  compressionPlugin: new CompressionPlugin({
    test: /\.js$|\.css$|\.html$/,
    filename: "[path].gz[query]",
    threshold: 50000
  })
};
