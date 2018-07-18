const webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const WebpackCleanupPlugin = require('webpack-cleanup-plugin');
const CompressionPlugin = require('compression-webpack-plugin');

module.exports = {
  extractTextPlugin: new ExtractTextPlugin({
    filename: 'style.[hash:8].css',
    allChunks: true
  }),

  htmlWebpackPlugin: new HtmlWebpackPlugin({
    template: './src/index.html',
    files: {
      css: ['style.[hash:8].css'],
      js: ['app.[hash:8].js', 'vendor.[hash:8].js']
    }
  }),

  commonsChunkPlugin: new webpack.optimize.CommonsChunkPlugin({
    name: 'vendor',
    filename: 'vendor.[hash:8].js',
    minChunks: Infinity
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

  occurrenceOrderPlugin: new webpack.optimize.OccurrenceOrderPlugin(),

  compressionPlugin: new CompressionPlugin({
    asset: "[path].gz[query]",
    algorithm: "gzip",
    test: /\.js$|\.css$|\.html$/,
    threshold: 10240,
    minRatio: 0.8
  })
};
