import React from 'react';
import { mount } from 'enzyme';

import Header from '../header';

describe('header-test', () => {
  it('renders', () => {
    const wrapper = mount(<Header />);

    expect(wrapper.find(Header).length).toBe(1);
  });

  it('has correct props', () => {
    const wrapper = mount(
      <Header companyTitle="Microshit" userName="John Doe" />
    );

    const selector = wrapper.find(Header);
    expect(selector.length).toBe(1);
    expect(selector.props().companyTitle).toBe('Microshit');
    expect(selector.props().userName).toBe('John Doe');
  });
});
