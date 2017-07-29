import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { DropdownButton, MenuItem } from 'react-bootstrap';
import { autobind } from 'core-decorators';

import Header from '../components/header';
import Loading from '../components/loading';
import { bootstrapAppAction, logOutUserAction } from '../app-actions';
import { isNilOrEmpty } from '../../core/util';

import styles from './app.scss';

const mapStateToProps = state => ({
  user: state.app.session.user
});

@connect(mapStateToProps)
class App extends Component {
  static propTypes = {
    children: PropTypes.node
  }

  static defaultProps = {
    children: []
  }

  componentDidMount() {
    this.props.dispatch(bootstrapAppAction());
  }

  @autobind
  handleLogout() {
    this.props.dispatch(logOutUserAction());
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

        {this.props.children}
      </div>
    );
  }
}

export default App;
