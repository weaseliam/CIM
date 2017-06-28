import React from 'react';
import { connect } from 'react-redux';

const mapStateToProps = state => ({
  i18n: state.i18n
});

const withI18N = BaseComponent =>
  connect(mapStateToProps)(props =>
    <BaseComponent {...props} translate={code => `${code} translated`} />);

export default withI18N;
