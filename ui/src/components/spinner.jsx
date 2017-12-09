import React, { Component } from 'react';
import PropTypes from 'prop-types';

import { isNilOrEmpty } from '../core/util';

const propTypes = {
  /**
   * The loading text to be used.
   */
  text: PropTypes.string,

  /**
   * The tick milliseconds for the loading animation.
   */
  tickMills: PropTypes.number
};

const defaultProps = {
  text: '',
  tickMills: 200
};

/**
 * Spinner component
 *
 * @extends {Component}
 */
class Spinner extends Component {
  constructor(props) {
    super(props);

    this.sprites = ['◷', '◶', '◵', '◴'];

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
    return isNilOrEmpty(this.props.text) ?
      <div>{this.sprites[this.state.index]}</div> :
      <div>{this.props.text}&nbsp;{this.sprites[this.state.index]}</div>;
  }
}

Spinner.propTypes = propTypes;
Spinner.defaultProps = defaultProps;

export default Spinner;
