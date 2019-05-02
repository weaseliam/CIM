import React from 'react';
import { mount } from 'enzyme';

import Pagination from '../pagination';

describe('pagination', () => {
  it('renders', () => {
    const wrapper = mount(<Pagination />);

    expect(wrapper.find(Pagination).length).toBe(1);
  });
});
