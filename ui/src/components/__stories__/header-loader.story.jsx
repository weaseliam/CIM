import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, number, boolean } from '@storybook/addon-knobs';

import HeaderLoader from '../header-loader';

const stories = storiesOf('HeaderLoader', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <HeaderLoader />
));

stories.add('custom', () => (
  <HeaderLoader
    loading={boolean('loading', false)}
    incrementValue={number('incrementValue', 0.01)}
    incrementDelay={number('incrementDelay', 100)}
  />
));
