const getRoot = state =>
  state.i18n;

export const supportedLanguagesSelector = state =>
  getRoot(state).supportedLanguages;

export const currentLanguageSelector = state =>
  getRoot(state).language;
