export const BOOTSTRAP_APP = 'BOOTSTRAP_APP';
export const FETCH_LOGGED_IN_USER = 'FETCH_LOGGED_IN_USER';
export const LOG_OUT_USER = 'LOG_OUT_USER';

/**
 * Bootstrap application action.
 * This is called at application start, after successful login.
 */
export const bootstrapAppAction = (payload = undefined, phase = '') => ({
  type: `${BOOTSTRAP_APP}${phase}`,
  payload
});

/**
 * Fetch current logged in user details action.
 */
export const fetchLoggedInUserAction = (payload = undefined, phase = '') => ({
  type: `${FETCH_LOGGED_IN_USER}${phase}`,
  payload
});

/**
 * Log out current user action.
 */
export const logOutUserAction = (phase = '') => ({
  type: `${LOG_OUT_USER}${phase}`
});
