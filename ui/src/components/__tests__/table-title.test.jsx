import React from 'react';
import { mount } from 'enzyme';

import TableTitle from '../table-title';

describe('table-title', () => {
  it('renders', () => {
    const wrapper = mount(<TableTitle />);

    expect(wrapper.find(TableTitle).length).toBe(1);
  });
});
