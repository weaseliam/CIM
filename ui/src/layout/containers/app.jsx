import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { DropdownButton, MenuItem } from 'react-bootstrap';
import { autobind } from 'core-decorators';

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
    return (
      <div>
        <div className={styles.headerContainer}>
          <div className={styles.header}>
            <Header companyTitle="CIM Company" userName={this.props.user.userName} />
          </div>
          <div className={styles.userMenu}>
            <DropdownButton bsStyle="default" bsSize="xsmall" pullRight>
              <MenuItem onSelect={this.handleLogout}>Logout</MenuItem>
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
