import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs } from '@storybook/addon-knobs';

import Loader from '../loader';

const stories = storiesOf('Loader', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <Loader />
));
