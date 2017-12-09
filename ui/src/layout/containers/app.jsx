import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Grid, Row, Col } from 'react-bootstrap';
import { Route } from 'react-router-dom';
import axios from 'axios';

import Spinner from '../../components/spinner';
import { bootstrapAppAction } from '../app-actions';
import AdminPage from '../../admin/components/admin-page';
import Header from './header';

const mapStateToProps = state => ({
  loading: state.app.loading
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

  render() {
    if (this.props.loading) {
      return <Spinner />;
    }

    return (
      <Grid fluid>
        <Row>
          <Col md={12}>
            <Header />
          </Col>
        </Row>

        <Row>
          <Col md={12}>
            <Route exact path="/" component={AdminPage} />
          </Col>
        </Row>
      </Grid>
    );
  }
}

export default App;
