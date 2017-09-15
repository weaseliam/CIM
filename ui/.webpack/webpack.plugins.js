const webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const WebpackCleanupPlugin = require('webpack-cleanup-plugin');

module.exports = {
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
  }),

  noEmitOnErrorsPlugin: new webpack.NoEmitOnErrorsPlugin(),

  hotModuleReplacementPlugin: new webpack.HotModuleReplacementPlugin(),

  namedModulesPlugin: new webpack.NamedModulesPlugin(),

  cleanupPlugin: new WebpackCleanupPlugin(),

  definePlugin: new webpack.DefinePlugin({
    'process.env.NODE_ENV': JSON.stringify('production')
  }),

  uglifyJsPlugin: new webpack.optimize.UglifyJsPlugin({
    compress: {
      warnings: false,
      screw_ie8: true,
      drop_console: true,
      drop_debugger: true
    }
  }),

  occurrenceOrderPlugin: new webpack.optimize.OccurrenceOrderPlugin()
};
