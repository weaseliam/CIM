const path = require('path');
const baseRules = require('./webpack.rules.base');

module.exports = {
  entry: {
    app: ['./src/index.jsx']
  },

  devtool: 'cheap-source-map',

  output: {
    publicPath: '',
    path: path.resolve(__dirname, '../target/dist'),
    filename: 'app.[hash:8].js',
    chunkFilename: 'vendor.[hash:8].js'
  },

  resolve: {
    extensions: ['.js', '.jsx']
  },

  module: {
    exprContextCritical: false,
    rules: baseRules
  },

  optimization: {
    splitChunks: {
      cacheGroups: {
        default: false,
        vendors: false,
        vendor: {
          test: /[\\/]node_modules[\\/]/,
          name: 'vendor',
          chunks: 'all'
        }
      }
    }
  }
};
