import React from 'react';
import { mount } from 'enzyme';

import HeaderLoader from '../header-loader';

describe('loading-test', () => {
  it('renders', () => {
    const wrapper = mount(<HeaderLoader />);

    expect(wrapper.find(HeaderLoader).length).toBe(1);
  });
});
