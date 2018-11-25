const devRules = require('../.webpack/webpack.rules.dev');

module.exports = function (baseConfig, env, defaultConfig) {
  defaultConfig.mode = 'development';
  defaultConfig.module.rules.push(devRules[1]);

  return defaultConfig;
};
