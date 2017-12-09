import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, text, number } from '@storybook/addon-knobs';

import Spinner from '../spinner';

const stories = storiesOf('Spinner', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <div>
    <Spinner
      text={text('Text', '')}
      tickMills={number('Tick mills', 200)}
    />
  </div>
));
