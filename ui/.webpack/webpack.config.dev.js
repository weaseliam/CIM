const webpackConfig = require('./webpack.config.base');
const plugins = require('./webpack.plugins');

const HOST = process.env.HOST || '127.0.0.1';
const PORT = process.env.PORT || '3000';
const SERVER_HOST = HOST || '127.0.0.1';
const SERVER_PORT = '8080';

webpackConfig.devtool = 'inline-source-map';

webpackConfig.module.rules.push({
  test: /\.scss$/,
  use: ['style-loader', 'css-loader?importLoaders=1&modules&localIdentName=[name]__[local]___[hash:base64:5]', 'postcss-loader', 'sass-loader'],
  exclude: ['node', 'node_modules']
});

webpackConfig.devServer = {
  contentBase: './target/dist',
  noInfo: false,
  hot: true,
  inline: true,
  historyApiFallback: true,
  port: PORT,
  host: HOST,
  stats: {
    assets: false,
    colors: true,
    version: false,
    hash: false,
    timings: false,
    chunks: false,
    chunkModules: false
  },
  proxy: {
    '/': {
      target: `http://${SERVER_HOST}:${SERVER_PORT}`,
      secure: false
    }
  }
};

webpackConfig.plugins = [
  plugins.noEmitOnErrorsPlugin,
  plugins.hotModuleReplacementPlugin,
  plugins.namedModulesPlugin,
  plugins.extractTextPlugin,
  plugins.commonsChunkPlugin,
  plugins.htmlWebpackPlugin
];

module.exports = webpackConfig;
