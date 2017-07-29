import React, { Component } from 'react';
import PropTypes from 'prop-types';

/**
 * Loading component
 *
 * @extends {Component}
 */
class Loading extends Component {
  static propTypes = {
    /**
     * The loading text to be used.
     */
    text: PropTypes.string,

    /**
     * The tick milliseconds for the loading animation.
     */
    tickMills: PropTypes.number
  }

  static defaultProps = {
    text: 'Loading',
    tickMills: 200
  }

  constructor(props) {
    super(props);

    this.sprites = ['|', '/', '-', '\\'];

    this.state = {
      index: -1
    };
  }

  componentDidMount() {
    this.setTimer(this.props.tickMills);
  }

  componentWillReceiveProps(nextProps) {
    clearInterval(this.timer);
    this.setTimer(nextProps.tickMills);
  }

  componentWillUnmount() {
    clearInterval(this.timer);
  }

  setTimer(tickMills) {
    this.timer = setInterval(
      () => this.tick(),
      tickMills
    );
  }

  tick() {
    this.setState({
      index: (this.state.index + 1) % this.sprites.length
    });
  }

  render() {
    return (
      <div>{this.props.text}&nbsp;{this.sprites[this.state.index]}</div>
    );
  }
}

export default Loading;
