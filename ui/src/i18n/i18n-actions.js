export const CHANGE_LANGUAGE = 'CHANGE_LANGUAGE';

export const changeLanguageAction = (payload = undefined, phase = '') => ({
  type: `${CHANGE_LANGUAGE}${phase}`,
  payload
});
