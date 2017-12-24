import React from 'react';
import { mount } from 'enzyme';

import Spinner from '../spinner';

describe('loading-test', () => {
  it('renders', () => {
    const wrapper = mount(<Spinner />);

    expect(wrapper.find(Spinner).length).toBe(1);
  });
});
