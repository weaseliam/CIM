import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, text } from '@storybook/addon-knobs';

import Header from '../header';

const stories = storiesOf('Header', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <div style={{ border: 'dotted 1px blue' }}>
    <Header
      companyTitle={text('Company title', 'Company Title')}
      userName={text('User name', 'User Name')}
    />
  </div>
));
