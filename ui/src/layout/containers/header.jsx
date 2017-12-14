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
import { loggedInUserSelector } from '../app-selector';
import withI18n from '../../i18n/i18n-hoc';
import { changeLanguageAction } from '../../i18n/i18n-actions';

import styles from './header.scss';

const mapStateToProps = state => ({
  user: loggedInUserSelector(state)
});

@withRouter
@withI18n
@connect(mapStateToProps)
class Header extends Component {
  handleLogout = () => {
    this.props.dispatch(logOutUserAction.trigger());
  }

  handleSelectPage = (eventKey) => {
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

  handleChangeLanguage = (language) => {
    this.props.dispatch(changeLanguageAction.trigger(language));
  }

  render() {
    return (
      <div className={styles.header}>
        <div className={styles.companyAndNav}>
          <div className={styles.company} />

          <div className={styles.nav}>
            <Nav bsStyle="tabs" activeKey={this.computeActiveKey()} onSelect={this.handleSelectPage}>
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
            {this.props.i18n.languages.map(language =>
              <MenuItem
                key={language}
                eventKey={language}
                onSelect={this.handleChangeLanguage}
                disabled={this.props.i18n.language === language}
              >
                {this.props.t(`ui.usermenu.language.${language}`)}
              </MenuItem>
            )}
            <MenuItem divider />
            <MenuItem onSelect={this.handleLogout}>
              {this.props.t('ui.usermenu.logout')}
            </MenuItem>
          </DropdownButton>
        </div>
      </div>
    );
  }
}

export default Header;
