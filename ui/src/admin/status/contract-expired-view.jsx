import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import { List } from 'office-ui-fabric-react/lib/List';
import { MessageBar, MessageBarType } from 'office-ui-fabric-react/lib/MessageBar';

import withI18n from '../../i18n/i18n-decorator';
import Pagination from '../../components/pagination';

@withI18n
@connect()
class ContractExpiredView extends Component {
  onRenderListItem = () => (
    <MessageBar
      messageBarType={MessageBarType.severeWarning}
      isMultiline={false}
      truncated
      styles={{ icon: { display: 'none' } }}
    >
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      Morbi luctus, purus a lobortis tristique, odio augue pharetra metus,
      ac placerat nunc mi nec dui. Vestibulum aliquam et nunc semper scelerisque.
      Curabitur vitae orci nec quam condimentum porttitor et sed lacus.
      Vivamus ac efficitur leo. Cras faucibus mauris libero, ac placerat erat euismod et.
      Donec pulvinar commodo odio sit amet faucibus. In hac habitasse platea dictumst.
      Duis eu ante commodo, condimentum nibh pellentesque, laoreet enim. Fusce massa lorem,
      ultrices eu mi a, fermentum suscipit magna. Integer porta purus pulvinar,
      hendrerit felis eget, condimentum mauris.
    </MessageBar>
  );

  render() {
    return (
      <Fragment>
        <MessageBar messageBarType={MessageBarType.severeWarning}>
          <span>100 expired contracts.</span>
          <Pagination />
        </MessageBar>
        <List items={[1, 2, 3, 4, 5]} onRenderCell={this.onRenderListItem} />
      </Fragment>
    );
  }
}

export default ContractExpiredView;
