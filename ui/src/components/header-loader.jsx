import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { ProgressIndicator } from 'office-ui-fabric-react/lib/ProgressIndicator';

import style from './header-loader.scss';

/**
 * HeaderLoader component
 *
 * @extends {Component}
 */
class HeaderLoader extends Component {
  static propTypes = {
    loading: PropTypes.bool,
    incrementValue: PropTypes.number,
    incrementDelay: PropTypes.number
  };

  static defaultProps = {
    loading: false,
    incrementValue: 0.01,
    incrementDelay: 100
  };

  constructor(props) {
    super(props);

    this.loadingInterval = null;
  }

  state = {
    loadingPercent: 0
  }

  componentWillReceiveProps(nextProps) {
    if (this.props.loading === nextProps.loading) {
      return;
    }

    if (nextProps.loading) {
      this.setState({ loadingPercent: 0 });
      this.loadingInterval = setInterval(this.tickLoading, nextProps.incrementDelay);
    } else if (this.loadingInterval) {
      clearInterval(this.loadingInterval);
    }
  }

  tickLoading = () => {
    const loadingPercent = this.state.loadingPercent + this.props.incrementValue;
    this.setState({ loadingPercent: loadingPercent > 1 ? 0 : loadingPercent });
  }

  render() {
    const { loading } = this.props;
    const { loadingPercent } = this.state;

    return <ProgressIndicator
      percentComplete={loading ? loadingPercent : 1}
      className={style.headerLoader}
    />;
  }
}

export default HeaderLoader;
