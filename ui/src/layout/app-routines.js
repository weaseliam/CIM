import { createRoutine } from 'redux-saga-routines';

/**
 * Bootstrap application routine.
 * This is called at application start, after successful login.
 */
export const bootstrapAppRoutine = createRoutine('BOOTSTRAP_APP');

/**
 * Fetch current logged in user details routine.
 */
export const fetchLoggedInUserRoutine = createRoutine('FETCH_LOGGED_IN_USER');

/**
 * Log out current user routine.
 */
export const logOutUserRoutine = createRoutine('LOG_OUT_USER');
