import React, { Component } from 'react';
import { connect } from 'react-redux';
import {
  DropdownButton,
  MenuItem,
  Nav,
  NavItem
} from 'react-bootstrap';
import { autobind } from 'core-decorators';

import { logOutUserAction } from '../app-actions';

import styles from './header.scss';

const mapStateToProps = state => ({
  user: state.app.session.user
});

@connect(mapStateToProps)
class Header extends Component {
  @autobind
  handleLogout() {
    this.props.dispatch(logOutUserAction.trigger());
  }

  handleSelect(eventKey) {
    console.log(`selected ${eventKey}`);
  }

  render() {
    return (
      <div className={styles.header}>
        <div className={styles.companyAndNav}>
          <div className={styles.company} />

          <div className={styles.nav}>
            <Nav bsStyle="tabs" activeKey="1" onSelect={this.handleSelect}>
              <NavItem eventKey="1">Administration</NavItem>
              <NavItem eventKey="2">Reports</NavItem>
              <NavItem eventKey="3">Others</NavItem>
            </Nav>
          </div>
        </div>

        <div className={styles.user}>
          <DropdownButton
            id={'header-user-menu'}
            title={this.props.user.userName}
            bsStyle="default"
            bsSize="xsmall"
            pullRight
          >
            <MenuItem>Romana</MenuItem>
            <MenuItem>English</MenuItem>
            <MenuItem divider />
            <MenuItem onSelect={this.handleLogout}>Sign out</MenuItem>
          </DropdownButton>
        </div>
      </div>
    );
  }
}

export default Header;
