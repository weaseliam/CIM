import React, { Component } from 'react';
import { connect } from 'react-redux';

import Loader from '../components/loader';
import { appLoadingContentSelector } from './app-selector';

const mapStateToProps = state => ({
  loading: appLoadingContentSelector(state)
});

@connect(mapStateToProps)
class LoaderView extends Component {
  render() {
    const { loading } = this.props;

    return (
      <React.Fragment>
        <Loader loading={loading} />
      </React.Fragment>
    );
  }
}

export default LoaderView;
