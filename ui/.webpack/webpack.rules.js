module.exports = [
  {
    test: /\.jsx?$/,
    exclude: /(node|node_modules)/,
    use: 'babel-loader'
  },
  {
    test: /\.css$/,
    use: ['style-loader', 'css-loader?importLoaders=1', 'postcss-loader']
  },
  {
    test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
    use: 'file-loader'
  },
  {
    test: /\.(woff|woff2)(\?v=\d+\.\d+\.\d+)?$/,
    use: 'url-loader?prefix=font/&limit=5000'
  },
  {
    test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
    use: 'url-loader?limit=10000&mimetype=application/octet-stream'
  },
  {
    test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
    use: 'url-loader?limit=10000&mimetype=image/svg+xml'
  },
  {
    test: /\.gif/,
    exclude: /(node|node_modules)/,
    use: 'url-loader?limit=10000&mimetype=image/gif'
  },
  {
    test: /\.jpg/,
    exclude: /(node|node_modules)/,
    use: 'url-loader?limit=10000&mimetype=image/jpg'
  },
  {
    test: /\.png/,
    exclude: /(node|node_modules)/,
    use: 'url-loader?limit=10000&mimetype=image/png'
  }
];
