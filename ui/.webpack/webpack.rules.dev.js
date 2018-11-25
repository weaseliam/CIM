module.exports = [
  {
    test: /\.css$/,
    use: [
      'style-loader',
      'css-loader',
      'postcss-loader'
    ]
  },
  {
    test: /\.scss$/,
    use: [
      'style-loader',
      'css-loader?modules&localIdentName=[name]__[local]___[hash:base64:5]',
      'postcss-loader',
      'sass-loader'
    ]
  }
];
