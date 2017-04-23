import React from 'react';
import { mount } from 'enzyme';

import Header from '../header';

describe('<Header />', () => {
  it('renders', () => {
    const wrapper = mount(<Header />);

    expect(wrapper.find(Header).length).toBe(1);
  });
});
