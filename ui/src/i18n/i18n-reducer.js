export const INITIAL_STATE = {
  i18n: {
    language: '',
    messages: {}
  }
};

export default function (state = INITIAL_STATE, action) {
  switch (action.type) {
    default:
      return state;
  }
}
