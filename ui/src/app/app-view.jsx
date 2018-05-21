import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Route } from 'react-router-dom';
import { withRouter } from 'react-router';

import { bootstrapAppAction } from './app-actions';
import AdminPage from '../admin/layout/admin-page';
import HeaderView from './header-view';
import ReportPage from '../report/layout/report-page';
import { appBootstrapSelector } from '../app/app-selector';
import SpinnerView from './spinner-view';

import styles from './app-view.scss';

const mapStateToProps = state => ({
  bootstrap: appBootstrapSelector(state)
});

@withRouter
@connect(mapStateToProps)
class AppView extends Component {
  componentDidMount() {
    this.props.dispatch(bootstrapAppAction.trigger());
  }

  render() {
    const { bootstrap } = this.props;

    if (!bootstrap) {
      return 'Loading...';
    }

    return (
      <div className={styles.app}>
        <SpinnerView />
        <HeaderView />
        <div className={styles.content}>
          <Route exact path="/" component={AdminPage} />
          <Route path="/report" component={ReportPage} />
        </div>
      </div>
    );
  }
}

export default AppView;
