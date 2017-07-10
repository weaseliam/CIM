import React from 'react';
import { connect } from 'react-redux';
import { translate } from './i18n-util';

const mapStateToProps = state => ({
  i18n: state.i18n
});

const withI18N = BaseComponent =>
  connect(mapStateToProps)(props =>
    <BaseComponent
      {...props}
      t={(code, params) =>
        translate(props.i18n.messages, code, params)}
    />);

export default withI18N;
