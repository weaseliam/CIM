import React, { Component } from 'react';
import { connect } from 'react-redux';

const mapStateToProps = state => ({
  i18n: state.i18n
});

const withI18N = function (WrappedComponent) {
  @connect(mapStateToProps)
  class i18n extends Component {
    render() {
      return <WrappedComponent {...this.props} />;
    }
  }

  return i18n;
};

export default withI18N;
