export const INITIAL_STATE = {
  i18n: {
    language: '',
    dictionary: {}
  }
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    default:
      return state;
  }
}
