const path = require('path');

module.exports = function (config) {
  config.set({
    browsers: [
      'ChromeHeadless'
    ],

    files: [
      'tests.webpack.js'
    ],

    frameworks: [
      'jasmine'
    ],

    preprocessors: {
      'tests.webpack.js': ['webpack', 'sourcemap']
    },

    reporters: ['spec'],

    colors: true,
    logLevel: config.LOG_ERROR,
    autoWatch: true,
    singleRun: false,
    browserNoActivityTimeout: 60000,

    webpack: {
      devtool: 'inline-source-map',
      resolve: {
        extensions: ['.js', '.jsx']
      },
      module: {
        loaders: [
          {
            test: /\.jsx?$/,
            include: path.resolve(__dirname, '../src'),
            exclude: /(node|node_modules)/,
            loader: 'babel-loader'
          },
          {
            test: /\.scss$/,
            include: path.resolve(__dirname, '../src'),
            loader: 'style-loader!css-loader!postcss-loader!sass-loader'
          },
          {
            test: /\.png/,
            include: path.resolve(__dirname, '../src'),
            loader: 'url-loader'
          }
        ]
      },

      cache: true,
      watch: true,

      externals: {
        jsdom: 'window',
        cheerio: 'window',
        'react/addons': true,
        'react/lib/ExecutionEnvironment': true,
        'react/lib/ReactContext': true
      }
    },

    webpackServer: {
      noInfo: true
    },

    webpackMiddleware: {
      noInfo: true
    }
  });
};
