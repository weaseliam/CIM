import { createAction } from '../core/smart-action';

export const bootstrapAppAction = createAction('BOOTSTRAP_APP');
export const fetchLoggedInUserAction = createAction('FETCH_LOGGED_IN_USER');
export const logOutUserAction = createAction('LOG_OUT_USER');
export const setAppLoadingContentAction = createAction('APP_LOADING_CONTENT');
