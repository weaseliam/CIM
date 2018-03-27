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

import styles from './app-view.scss';

const mapStateToProps = state => ({
  loading: state.app.loading
});

@withRouter
@connect(mapStateToProps)
class AppView extends Component {
  componentDidMount() {
    this.registerHttpInterceptors();
    this.props.dispatch(bootstrapAppAction.trigger());
  }

  registerHttpInterceptors() {
    axios.interceptors.request.use(
      config => config,
      (error) => {
        // eslint-disable-next-line
        alert(error);
        return Promise.reject(error);
      }
    );
    axios.interceptors.response.use(
      config => config,
      (error) => {
        // eslint-disable-next-line
        alert(error);
        return Promise.reject(error);
      }
    );
  }

  render() {
    const { loading } = this.props;

    return (
      <Spinner
        loading={loading}
        fillContainer
        renderChildren={false}
        className={styles.app}
        classNameWhenLoading={styles.loading}
      >
        <HeaderView />
        <div className={styles.content}>
          <Route exact path="/" component={AdminPage} />
          <Route path="/report" component={ReportPage} />
        </div>
      </Spinner>
    );
  }
}

export default AppView;
