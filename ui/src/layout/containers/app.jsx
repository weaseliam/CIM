import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { DropdownButton, MenuItem } from 'react-bootstrap';
import { autobind } from 'core-decorators';
import R from 'ramda';

import Header from '../components/header';
import { fetchLoggedInUserAction, logOutUserAction } from '../actions/app-actions';

import styles from './app.scss';

const mapStateToProps = state => ({
  user: state.app.session.user
});

@connect(mapStateToProps)
class App extends Component {
  componentWillMount() {
    this.props.dispatch(fetchLoggedInUserAction());
  }

  @autobind
  handleLogout() {
    this.props.dispatch(logOutUserAction());
  }

  render() {
    if (R.isEmpty(this.props.user) || R.isNil(this.props.user) ||
        R.isEmpty(this.props.user.userName) || R.isNil(this.props.user.userName)) {
      return null;
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

        {this.props.children}
      </div>
    );
  }
}

App.propTypes = {
  children: PropTypes.node
};

App.defaultProps = {
  children: []
};

export default App;
