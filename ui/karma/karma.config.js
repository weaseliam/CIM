module.exports = function (config) {
  config.set({
    browsers: [
      'PhantomJS'
    ],
    files: [
      { pattern: 'tests.webpack.js', watched: false },
    ],
    frameworks: [
      'jasmine'
    ],
    preprocessors: {
      'tests.webpack.js': ['webpack', 'sourcemap']
    },
    reporters: ['dots'],
    singleRun: true,
    webpack: {
      cache: true,
      devtool: 'inline-source-map',
      module: {
        loaders: [
          {
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader'
          }
        ]
      },
      watch: true,
      externals: {
        'react/addons': true,
        'react/lib/ExecutionEnvironment': true,
        'react/lib/ReactContext': true
      }
    },
    webpackServer: {
      noInfo: true
    },
    browserNoActivityTimeout: 60000
  });
};
