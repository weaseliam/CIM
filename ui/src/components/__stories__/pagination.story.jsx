import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, number } from '@storybook/addon-knobs';
import { action } from '@storybook/addon-actions';

import Pagination from '../pagination';

const stories = storiesOf('Pagination', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <Pagination />
));

stories.add('custom', () => (
  <Pagination
    page={number('page', 1)}
    pages={number('pages', 10)}
    onFirstPage={action('onFirstPage')}
    onPrevPage={action('onPrevPage')}
    onNextPage={action('onNextPage')}
    onLastPage={action('onLastPage')}
  />
));
