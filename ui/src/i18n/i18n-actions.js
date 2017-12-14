import { createAction } from '../core/smart-action';

/**
 * Change language action.
 */
export const changeLanguageAction = createAction('CHANGE_LANGUAGE');

/**
 * Fetch supported languages action.
 */
export const fetchSupportedLanguagesAction = createAction('FETCH_SUPPORTED_LANGUAGES');
