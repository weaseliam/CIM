import React from 'react';

import styles from './app.scss';

const App = () => (
  <div>
    <h1 className={styles.h1}>It Works !</h1>
    <p>This React project just works including
      <span className={styles.redBg}> css modules</span> styles and hot reloading.<br />
      Click browser inspect to see for yourself :P
    </p>
    <p>Enjoy!</p>
  </div>
);

export default App;
