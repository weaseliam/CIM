import React, { Component } from 'react';
import { connect } from 'react-redux';

import Spinner from '../components/spinner';
import { appLoadingSelector } from '../app/app-selector';

const mapStateToProps = state => ({
  loading: appLoadingSelector(state)
});

@connect(mapStateToProps)
class SpinnerView extends Component {
  render() {
    const { loading } = this.props;

    return (
      <React.Fragment>
        <Spinner loading={loading} fillContainer />
      </React.Fragment>
    );
  }
}

export default SpinnerView;
