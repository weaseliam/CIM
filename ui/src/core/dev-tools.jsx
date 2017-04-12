/* eslint-disable */

import React from 'react';
import { createDevTools } from 'redux-devtools';
import LogMonitor from 'redux-devtools-log-monitor';
import DockMonitor from 'redux-devtools-dock-monitor';
import Inspector from 'redux-devtools-inspector';

export default createDevTools(
  <DockMonitor
    defaultIsVisible={false}
    toggleVisibilityKey="ctrl-alt-h"
    changePositionKey="ctrl-q"
    changeMonitorKey="ctrl-m"
  >
    <LogMonitor />
    <Inspector />
  </DockMonitor>
);
