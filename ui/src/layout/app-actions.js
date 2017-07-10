export const BOOTSTRAP_APP = 'BOOTSTRAP_APP';
export const FETCH_LOGGED_IN_USER = 'FETCH_LOGGED_IN_USER';
export const LOG_OUT_USER = 'LOG_OUT_USER';

export const bootstrapAppAction = (payload = undefined, phase = '') => ({
  type: `${BOOTSTRAP_APP}${phase}`,
  payload
});

export const fetchLoggedInUserAction = (payload = undefined, phase = '') => ({
  type: `${FETCH_LOGGED_IN_USER}${phase}`,
  payload
});

export const logOutUserAction = (phase = '') => ({
  type: `${LOG_OUT_USER}${phase}`
});
