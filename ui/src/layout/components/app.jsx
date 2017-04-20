import React from 'react';
import { Button } from 'react-bootstrap';

import styles from './app.scss';

const App = () => (
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
    <p>Enjoy!</p>
  </div>
);

export default App;
