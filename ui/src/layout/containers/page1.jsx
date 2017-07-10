import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import { connect } from 'react-redux';

import withI18n from '../../i18n/i18n-hoc';

import styles from './app.scss';

const mapStateToProps = state => ({
  userName: state.app.session.user.userName
});

@withI18n
@connect(mapStateToProps)
class Page1 extends Component {
  componentDidUpdate() {
  }

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
          Testing bootstrap<br />
          <Button bsStyle="success">Success</Button>
        </p>
        <p>
          Testing font-awesome<br />
          <i className="fa fa-check fa-2x" aria-hidden="true" />
        </p>
        <p>
          Testing <a href="/swagger-ui.html" target="_blank" rel="noopener noreferrer">swagger</a>
        </p>
        <p>
          Testing redux<br />
          User name from state: {this.props.userName}
        </p>
        <p>
          Testing i18n<br />
          Current language: {this.props.i18n.language}<br />
          Translation test: {this.props.t('session.user.notFoundInDB', ['test'])}
        </p>
        <p>Enjoy!</p>
      </div>
    );
  }
}

Page1.propTypes = {
};

Page1.defaultProps = {
};

export default Page1;
