import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, number, boolean } from '@storybook/addon-knobs';

import Loader from '../loader';

const stories = storiesOf('Loader', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <Loader loading />
));

stories.add('with label', () => (
  <div>
    Title
    <Loader
      loading={boolean('loading', true)}
      size={number('size', 30)}
    />
  </div>
));
