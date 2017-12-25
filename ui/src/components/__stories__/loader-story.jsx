import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, text, number, boolean } from '@storybook/addon-knobs';

import Loader from '../loader';

const stories = storiesOf('Loader', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <Loader />
));

stories.add('with title', () => (
  <div>
    Title
    <Loader
      loading={boolean('Loading', true)}
      color={text('Color', '#3399ff')}
      size={number('Size', 10)}
    />
  </div>
));
