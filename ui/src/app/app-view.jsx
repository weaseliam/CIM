import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Route } from 'react-router-dom';
import axios from 'axios';
import { withRouter } from 'react-router';

import Spinner from '../components/spinner';
import { bootstrapAppAction } from './app-actions';
import AdminPage from '../admin/layout/admin-page';
import HeaderView from './header-view';
import ReportPage from '../report/layout/report-page';
import { appLoadingSelector, appBootstrapSelector } from '../app/app-selector';

import styles from './app-view.scss';

const mapStateToProps = state => ({
  bootstrap: appBootstrapSelector(state),
  loading: appLoadingSelector(state)
});

@withRouter
@connect(mapStateToProps)
class AppView extends Component {
  componentDidMount() {
    this.props.dispatch(bootstrapAppAction.trigger());
  }

  render() {
    const { loading, bootstrap } = this.props;

    if (!bootstrap) {
      return 'Loading...';
    }

    return (
      <div className={styles.app}>
        <Spinner loading={loading} fillContainer />
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
