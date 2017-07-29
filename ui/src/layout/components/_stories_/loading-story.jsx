import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, text, number } from '@storybook/addon-knobs';

import Loading from '../loading';

const stories = storiesOf('Loading', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <div>
    <Loading
      text={text('Text', 'Loading')}
      tickMills={number('Tick mills', 500)}
    />
  </div>
));
