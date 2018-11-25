import React, { Component } from 'react';
import { connect } from 'react-redux';
import { CommandBar } from 'office-ui-fabric-react/lib/CommandBar';
import { ContextualMenuItemType } from 'office-ui-fabric-react/lib/ContextualMenu';
import { withRouter } from 'react-router';

import { logOutUserAction } from './app-actions';
import { appUserSelector } from './app-selector';
import withI18n from '../i18n/i18n-decorator';
import { changeLanguageAction } from '../i18n/i18n-actions';
import LoaderView from './loader-view';
import * as i18nc from '../i18n/i18n-constants';

import styles from './header-view.scss';

const mapStateToProps = state => ({
  user: appUserSelector(state)
});

@withRouter
@withI18n
@connect(mapStateToProps)
class HeaderView extends Component {
  getSelectedPage = () => {
    const { location } = this.props;

    switch (location.pathname) {
      case '/report':
        return 'report';

      default:
        return 'admin';
    }
  }

  handleSelectPage = (e, pageItem) => {
    const { history } = this.props;

    switch (pageItem.key) {
      case 'admin':
        history.push('/');
        break;

      case 'report':
        history.push('/report');
        break;

      default:
        break;
    }
  }

  handleLogout = () => {
    const { dispatch } = this.props;

    dispatch(logOutUserAction.trigger());
  }

  handleChangeLanguage = (e, languageItem) => {
    const { dispatch } = this.props;

    dispatch(changeLanguageAction.trigger(languageItem.key));
  }

  createUserMenuItems = () => {
    const { i18n, t } = this.props;

    // language options
    const items = i18n.languages.map(language => ({
      key: language,
      text: t(`${i18nc.HEADER_USERMENU_LANGUAGE}.${language}`),
      disabled: i18n.language === language,
      onClick: this.handleChangeLanguage
    }));

    // divider
    items.push({
      key: 'divider1',
      itemType: ContextualMenuItemType.Divider
    });

    // logout
    items.push({
      key: 'logout',
      text: t(i18nc.HEADER_USERMENU_LOGOUT),
      onClick: this.handleLogout
    });

    return items;
  }

  createItems = () => {
    const { t } = this.props;
    const items = [];

    // admin
    items.push({
      text: t(i18nc.HEADER_ADMINISTRATION),
      key: 'admin',
      itemType: ContextualMenuItemType.Header,
      iconProps: {
        iconName: 'Admin'
      },
      disabled: this.getSelectedPage() === 'admin',
      onClick: e => this.handleSelectPage(e, items[0])
    });

    // report
    items.push({
      text: t(i18nc.HEADER_REPORTS),
      key: 'report',
      itemType: ContextualMenuItemType.Header,
      iconProps: {
        iconName: 'Chart'
      },
      disabled: this.getSelectedPage() === 'report',
      onClick: e => this.handleSelectPage(e, items[1])
    });

    return items;
  }

  createFarItems = () => {
    const { user } = this.props;
    const farItems = [];

    // user menu
    farItems.push({
      text: user.userName,
      key: 'userMenu',
      itemType: ContextualMenuItemType.Header,
      iconProps: {
        iconName: 'Contact'
      },
      subMenuProps: {
        items: this.createUserMenuItems()
      }
    });

    return farItems;
  }

  render() {
    return (
      <div className={styles.header}>
        <div className={styles.nav}>
          <div className={styles.company} />
          <div className={styles.commandbar}>
            <CommandBar
              items={this.createItems()}
              farItems={this.createFarItems()}
            />
          </div>
        </div>
        <LoaderView />
      </div>
    );
  }
}

export default HeaderView;
