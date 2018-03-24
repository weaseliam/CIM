import React from 'react';
import { mount } from 'enzyme';

import Loader from '../loader';

describe('loading-test', () => {
  it('renders', () => {
    const wrapper = mount(<Loader />);

    expect(wrapper.find(Loader).length).toBe(1);
  });
});
