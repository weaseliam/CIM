import React, { Component } from 'react';
import { Button } from 'react-bootstrap';

import WithI18n from '../../i18n/i18n-hoc';

import styles from './app.scss';

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
          Testing bootstrap:
          <Button bsStyle="success">Success</Button>
        </p>
        <p>
          Testing font-awesome:
          <i className="fa fa-check fa-2x" aria-hidden="true" />
        </p>
        <p>
          Testing <a href="/swagger-ui.html" target="_blank" rel="noopener noreferrer">swagger</a>
        </p>
        <p>
          Testing i18n<br />
          Current language: {this.props.i18n.language}<br />
          Translation test: {this.props.translate('session.user.notFoundInDB')}
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

export default WithI18n(Page1);
