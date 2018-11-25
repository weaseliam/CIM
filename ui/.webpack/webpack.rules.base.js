module.exports = [
  {
    test: /\.jsx?$/,
    use: 'babel-loader'
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
    use: 'url-loader?limit=10000&mimetype=image/gif'
  },
  {
    test: /\.jpg/,
    use: 'url-loader?limit=10000&mimetype=image/jpg'
  },
  {
    test: /\.png/,
    use: 'url-loader?limit=10000&mimetype=image/png'
  }
];
