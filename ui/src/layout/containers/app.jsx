import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Route } from 'react-router-dom';
import axios from 'axios';
import { withRouter } from 'react-router';

import Loader from '../../components/loader';
import { bootstrapAppAction } from '../app-actions';
import AdminPage from '../../admin/components/admin-page';
import Header from './header';
import ReportPage from '../../report/components/report-page';

import styles from './app.scss';

const mapStateToProps = state => ({
  loading: state.app.loading
});

@withRouter
@connect(mapStateToProps)
class App extends Component {
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
    if (this.props.loading) {
      return <Loader />;
    }

    return (
      <div className={styles.app}>
        <Header />
        <div className={styles.content}>
          <Route exact path="/" component={AdminPage} />
          <Route path="/report" component={ReportPage} />
        </div>
      </div>
    );
  }
}

export default App;
