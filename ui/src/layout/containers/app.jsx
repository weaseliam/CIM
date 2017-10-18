import React, { Component } from 'react';
import { connect } from 'react-redux';
import { DropdownButton, MenuItem } from 'react-bootstrap';
import { autobind } from 'core-decorators';
import { Route } from 'react-router-dom';
import axios from 'axios';

import Header from '../components/header';
import Loading from '../components/loading';
import { bootstrapAppAction, logOutUserAction } from '../app-actions';
import { isNilOrEmpty } from '../../core/util';
import Page1 from './page1';

import styles from './app.scss';

const mapStateToProps = state => ({
  user: state.app.session.user
});

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

  @autobind
  handleLogout() {
    this.props.dispatch(logOutUserAction.trigger());
  }

  render() {
    if (isNilOrEmpty(this.props.user) || isNilOrEmpty(this.props.user.userName)) {
      return <Loading />;
    }

    return (
      <div>
        <div className={styles.headerContainer}>
          <div className={styles.header}>
            <Header companyTitle="CIM Company" userName={this.props.user.userName} />
          </div>
          <div className={styles.userMenu}>
            <DropdownButton bsStyle="default" bsSize="xsmall" pullRight>
              <MenuItem onSelect={this.handleLogout}>Sign out</MenuItem>
            </DropdownButton>
          </div>
        </div>

        <Route exact path="/" component={Page1} />
      </div>
    );
  }
}

export default App;
