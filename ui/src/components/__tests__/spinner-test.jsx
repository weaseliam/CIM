import React from 'react';
import { mount } from 'enzyme';

import Spinner from '../spinner';

describe('loading-test', () => {
  it('renders', () => {
    const wrapper = mount(<Spinner />);

    expect(wrapper.find(Spinner).length).toBe(1);
  });

  it('has correct props', () => {
    const wrapper = mount(
      <Spinner text="Se incarca" tickMills={500} />
    );

    const selector = wrapper.find(Spinner);
    expect(selector.length).toBe(1);
    expect(selector.props().text).toBe('Se incarca');
    expect(selector.props().tickMills).toBe(500);
  });
});
