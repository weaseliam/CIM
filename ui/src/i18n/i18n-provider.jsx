import React, { Component } from 'react';
import { connect } from 'react-redux';

export const i18nContext = React.createContext('i18n');

const mapStateToProps = state => ({
  i18n: state.i18n
});

@connect(mapStateToProps)
class I18nProvider extends Component {
  render() {
    return (
      <i18nContext.Provider value={this.props.i18n}>
        {this.props.children}
      </i18nContext.Provider>
    );
  }
}

export default I18nProvider;
