export const FETCH_LOGGED_IN_USER = 'FETCH_LOGGED_IN_USER';
export const LOG_OUT_USER = 'LOG_OUT_USER';

export const fetchLoggedInUserAction = (payload = null, phase = '') => ({
  type: `${FETCH_LOGGED_IN_USER}${phase}`,
  payload
});

export const logOutUserAction = (phase = '') => ({
  type: `${LOG_OUT_USER}${phase}`
});
