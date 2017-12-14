import React from 'react';
import { connect } from 'react-redux';
import { translate } from './i18n-util';

const mapStateToProps = state => ({
  i18n: state.i18n
});

/**
 * I18n high order component.
 * It is recommended to be used as a decorator @withI18n.
 *
 * ! It must be declared after redux connect !
 * ```js
 * @withI18n
 * @connect(mapStateToProps)
 * class Test extends Component {
 * ...
 * ```
 *
 * @param {React.Component} BaseComponent
 */
const withI18n = BaseComponent =>
  connect(mapStateToProps)(props =>
    <BaseComponent
      {...props}
      t={(code, params) =>
        translate(props.i18n.messages, code, params)}
    />);

export default withI18n;
