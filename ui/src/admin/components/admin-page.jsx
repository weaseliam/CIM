import React from 'react';
import {
  Grid,
  Row,
  Col
} from 'react-bootstrap';

import LeftPanel from './left-panel';
import CenterPanel from './center-panel';
import RightPanel from './right-panel';

const AdminPage = () => (
  <Grid fluid>
    <Row>
      <Col md={2} style={{ borderLeft: '1px dashed grey', borderBottom: '1px dashed grey' }}>
        <LeftPanel />
      </Col>

      <Col md={7} style={{ borderLeft: '1px dashed grey', borderBottom: '1px dashed grey', borderRight: '1px dashed grey' }}>
        <CenterPanel />
      </Col>

      <Col md={3} style={{ borderBottom: '1px dashed grey', borderRight: '1px dashed grey' }}>
        <RightPanel />
      </Col>
    </Row>
  </Grid>
);

export default AdminPage;
