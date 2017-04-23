import React from 'react';
// eslint-disable-next-line
import { storiesOf } from '@kadira/storybook';
import { withKnobs, text } from '@kadira/storybook-addon-knobs';

import Header from '../header';

const stories = storiesOf('Header', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <div style={{ border: 'dotted 1px blue' }}>
    <Header
      companyTitle={text('Company title', 'Company Title')}
      userName={text('User name', 'User Name')} />
  </div>
));
