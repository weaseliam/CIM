import React, { Component } from 'react';
import { connect } from 'react-redux';
import {
  DropdownButton,
  MenuItem,
  Nav,
  NavItem
} from 'react-bootstrap';
import { withRouter } from 'react-router';

import { logOutUserAction } from '../app-actions';

import styles from './header.scss';

const mapStateToProps = state => ({
  user: state.app.session.user
});

@connect(mapStateToProps)
class Header extends Component {
  handleLogout = () => {
    this.props.dispatch(logOutUserAction.trigger());
  }

  handleSelect = (eventKey) => {
    switch (eventKey) {
      case 'admin':
        this.props.history.push('/');
        break;

      case 'report':
        this.props.history.push('/report');
        break;

      default:
        break;
    }
  }

  computeActiveKey = () => {
    switch (this.props.location.pathname) {
      case '/report':
        return 'report';

      default:
        return 'admin';
    }
  }

  render() {
    return (
      <div className={styles.header}>
        <div className={styles.companyAndNav}>
          <div className={styles.company} />

          <div className={styles.nav}>
            <Nav bsStyle="tabs" activeKey={this.computeActiveKey()} onSelect={this.handleSelect}>
              <NavItem eventKey="admin">Administration</NavItem>
              <NavItem eventKey="report">Reports</NavItem>
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

export default withRouter(Header);
