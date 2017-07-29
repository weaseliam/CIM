const genDefaultConfig = require('@storybook/react/dist/server/config/defaults/webpack.config.js');
const baseConfig = require('../.webpack/webpack.config.base');

module.exports = function(config, env) {
  var config = genDefaultConfig(config, env);

  config.module = baseConfig.module;
  config.module.loaders.push({
    test: /\.scss$/,
    loaders: ['style-loader', 'css-loader?importLoaders=1&modules&localIdentName=[name]__[local]___[hash:base64:5]', 'postcss-loader', 'sass-loader'],
    exclude: ['node_modules']
  });

  return config;
};
