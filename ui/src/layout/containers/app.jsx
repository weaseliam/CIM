import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

import Header from '../components/header';
import { fetchLoggedInUser } from '../actions/app-actions';

import styles from './app.scss';

const mapStateToProps = state => ({
  user: state.app.session.user
});

@connect(mapStateToProps)
class App extends Component {
  componentWillMount() {
    this.props.dispatch(fetchLoggedInUser());
  }

  render() {
    return (
      <div>
        <Header companyTitle="CIM Company" userName={this.props.user.userName} className={styles.header} />
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
