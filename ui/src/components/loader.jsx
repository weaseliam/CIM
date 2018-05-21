import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { ProgressIndicator } from 'office-ui-fabric-react/lib/ProgressIndicator';

import styles from './loader.scss';

const LOADER_ANIMATION_DURATION = 3000;
const LOADER_ANIMATION_THRESHOLD = 2500;

/**
 * Loader component
 */
class Loader extends Component {
  static propTypes = {
    loading: PropTypes.bool
  };

  static defaultProps = {
    loading: false
  };

  constructor(props) {
    super(props);

    this.loadingStartTime = null;
    this.delayInterval = null;
  }

  state = {
    loadingDelayed: false
  };

  componentWillMount() {
    if (this.props.loading === true) {
      this.activateLoading();
    }
  }

  componentWillReceiveProps(nextProps) {
    if (this.props.loading === nextProps.loading) {
      return;
    }

    if (nextProps.loading === true) {
      this.activateLoading();
    } else {
      this.deactivateLoading();
    }
  }

  activateLoading = () => {
    this.delayInterval && clearInterval(this.delayInterval);
    const date = new Date();
    this.loadingStartTime = date.getTime();
    this.setState({ loadingDelayed: true });
  }

  deactivateLoading = () => {
    const date = new Date();
    const stopTime = date.getTime();
    const duration = stopTime - this.loadingStartTime;
    if (duration <= LOADER_ANIMATION_THRESHOLD) {
      this.delayInterval = setInterval(this.handleDelay, LOADER_ANIMATION_DURATION - duration);
    } else {
      this.setState({ loadingDelayed: false });
    }
  }

  handleDelay = () => {
    this.setState({ loadingDelayed: false });
    clearInterval(this.delayInterval);
    this.delayInterval = null;
  }

  render() {
    const { loadingDelayed } = this.state;

    return loadingDelayed
      ? <ProgressIndicator className={styles.loaderActive} />
      : <div className={styles.loaderInactive} />;
  }
}

export default Loader;
