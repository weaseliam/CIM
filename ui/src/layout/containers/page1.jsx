import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import { connect } from 'react-redux';

import withI18n from '../../i18n/i18n-hoc';

import styles from './page1.scss';

const mapStateToProps = state => ({
  userName: state.app.session.user.userName
});

@withI18n
@connect(mapStateToProps)
class Page1 extends Component {
  render() {
    return (
      <div>
        <h1 className={styles.h1}>It Works !</h1>
        <p>
          This React project just works including
          <span className={styles.textBg}> css modules</span> styles and hot reloading.<br />
          Click browser inspect to see for yourself :P
        </p>
        <p>
          <b>Testing bootstrap</b><br />
          <Button bsStyle="success">Success</Button>
        </p>
        <p>
          <b>Testing font-awesome</b><br />
          <i className="fa fa-check fa-2x" aria-hidden="true" />
        </p>
        <p>
          <b>Testing swagger</b><br />
          <a href="/swagger-ui.html" target="_blank" rel="noopener noreferrer">swagger</a>
        </p>
        <p>
          <b>Testing redux</b><br />
          User name from state: {this.props.userName}
        </p>
        <p>
          <b>Testing i18n</b><br />
          Current language: {this.props.i18n.language}<br />
          Translation test: {this.props.t('security.context.auth.error', ['test'])}
        </p>
        <h3>Enjoy!</h3>
      </div>
    );
  }
}

export default Page1;
