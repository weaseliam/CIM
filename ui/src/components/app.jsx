import React, { Component } from 'react';

import styles from './app.scss';

// eslint-disable-next-line
export default class App extends Component {
  render() {
    return (
      <div>
        <h1 className={styles.h1}>It Works !</h1>
        <p>This React project just works including
          <span className={styles.redBg}> css modules</span> styles and hot reloading.<br />
          Click browser inspect to see for yourself :P
        </p>
        <p>Enjoy!</p>
      </div>
    );
  }
}
