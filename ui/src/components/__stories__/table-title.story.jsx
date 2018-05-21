import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, number, text } from '@storybook/addon-knobs';
import { action } from '@storybook/addon-actions';

import TableTitle from '../table-title';

const stories = storiesOf('TableTitle', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <TableTitle />
));

stories.add('custom', () => (
  <TableTitle
    results={number('results', 0)}
    title={text('title', 'Sample title')}
    onResetFilter={action('onResetFilter')}
  />
));
