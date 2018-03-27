import React, { Component } from 'react';
import { connect } from 'react-redux';
import { CommandBar } from 'office-ui-fabric-react/lib/CommandBar';
import { ContextualMenuItemType } from 'office-ui-fabric-react/lib/ContextualMenu';
import { withRouter } from 'react-router';

import { logOutUserAction } from './app-actions';
import { loggedInUserSelector, appLoadingContentSelector } from './app-selector';
import withI18n from '../i18n/i18n-hoc';
import { changeLanguageAction } from '../i18n/i18n-actions';
import Loader from '../components/loader';

import styles from './header-view.scss';

const mapStateToProps = state => ({
  user: loggedInUserSelector(state),
  loadingContent: appLoadingContentSelector(state)
});

@withRouter
@withI18n
@connect(mapStateToProps)
class HeaderView extends Component {
  getSelectedPage = () => {
    switch (this.props.location.pathname) {
      case '/report':
        return 'report';

      default:
        return 'admin';
    }
  }

  handleSelectPage = (e, pageItem) => {
    switch (pageItem.key) {
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

  handleLogout = () => {
    this.props.dispatch(logOutUserAction.trigger());
  }

  handleChangeLanguage = (e, languageItem) => {
    this.props.dispatch(changeLanguageAction.trigger(languageItem.key));
  }

  createUserMenuItems = () => {
    // language options
    const items = this.props.i18n.languages.map(language => ({
      key: language,
      name: this.props.t(`ui.usermenu.language.${language}`),
      disabled: this.props.i18n.language === language,
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
      name: this.props.t('ui.usermenu.logout'),
      onClick: this.handleLogout
    });

    return items;
  }

  createItems = () => {
    const items = [];

    // admin
    items.push({
      name: 'Administration',
      key: 'admin',
      itemType: ContextualMenuItemType.Header,
      iconProps: {
        iconName: 'Admin'
      },
      disabled: this.getSelectedPage() === 'admin',
      onClick: this.handleSelectPage
    });

    // report
    items.push({
      name: 'Reports',
      key: 'report',
      itemType: ContextualMenuItemType.Header,
      iconProps: {
        iconName: 'Chart'
      },
      disabled: this.getSelectedPage() === 'report',
      onClick: this.handleSelectPage
    });

    return items;
  }

  createFarItems = () => {
    const farItems = [];

    // user menu
    farItems.push({
      name: this.props.user.userName,
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
    const { loadingContent } = this.props;

    return (
      <div className={styles.header}>
        <div className={styles.nav} >
          <div className={styles.company} />
          <div className={styles.commandbar} >
            <CommandBar
              items={this.createItems()}
              farItems={this.createFarItems()}
            />
          </div>
        </div>
        <Loader loading={loadingContent} />
      </div>
    );
  }
}

export default HeaderView;
