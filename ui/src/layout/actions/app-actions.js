export const FETCH_LOGGED_IN_USER = 'FETCH_LOGGED_IN_USER';

export const fetchLoggedInUser = (payload = null, phase = '') => ({
  type: `${FETCH_LOGGED_IN_USER}${phase}`,
  payload
});
