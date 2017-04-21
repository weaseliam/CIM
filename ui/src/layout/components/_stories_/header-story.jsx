import React from 'react';
// eslint-disable-next-line
import { storiesOf } from '@kadira/storybook';

import Header from '../header';

storiesOf('Header', module)
  .add('default', () => (
    <div style={{ border: 'dotted 1px blue' }}>
      <Header />
    </div>
  ));
