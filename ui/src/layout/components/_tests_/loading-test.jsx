import React from 'react';
import { mount } from 'enzyme';

import Loading from '../loading';

describe('<Loading />', () => {
  it('renders', () => {
    const wrapper = mount(<Loading />);

    expect(wrapper.find(Loading).length).toBe(1);
  });

  it('has correct props', () => {
    const wrapper = mount(
      <Loading text="Se incarca" tickMills={500} />
    );

    const selector = wrapper.find(Loading);
    expect(selector.length).toBe(1);
    expect(selector.props().text).toBe('Se incarca');
    expect(selector.props().tickMills).toBe(500);
  });
});
