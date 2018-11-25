const baseRules = require('../.webpack/webpack.rules.base');
const devRules = require('../.webpack/webpack.rules.dev');

const webpack = {
  mode: 'development',
  devtool: 'inline-source-map',
  resolve: {
    extensions: ['.js', '.jsx']
  },
  module: {
    rules: baseRules.concat(devRules)
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
};

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
    autoWatch: true,
    singleRun: false,
    browserNoActivityTimeout: 60000,

    webpack,

    webpackServer: {
      noInfo: true
    },

    webpackMiddleware: {
      noInfo: true
    }
  });
};
