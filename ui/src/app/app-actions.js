import { createAction } from '../core/smart-action';

export const bootstrapAppAction = createAction('BOOTSTRAP_APP');
export const fetchAppSessionAction = createAction('FETCH_APP_SESSION');
export const logOutUserAction = createAction('LOG_OUT_USER');
export const setAppLoadingContentAction = createAction('APP_LOADING_CONTENT');
export const setAppLoadingAction = createAction('APP_LOADING');
