import { createAction } from '../core/smart-action';

/**
 * Bootstrap application action.
 * This is called at application start, after successful login.
 */
export const bootstrapAppAction = createAction('BOOTSTRAP_APP');

/**
 * Fetch current logged in user details action.
 */
export const fetchLoggedInUserAction = createAction('FETCH_LOGGED_IN_USER');

/**
 * Log out current user action.
 */
export const logOutUserAction = createAction('LOG_OUT_USER');
