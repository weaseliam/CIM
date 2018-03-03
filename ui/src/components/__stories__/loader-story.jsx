import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, number, boolean } from '@storybook/addon-knobs';

import Loader from '../loader';

const stories = storiesOf('Loader', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <Loader />
));

stories.add('with label', () => (
  <div>
    Title
    <Loader
      loading={boolean('Loading', true)}
      size={number('Size', 30)}
    />
  </div>
));
