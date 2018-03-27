import { i18nReducer, INITIAL_STATE } from '../i18n-reducer';
import { changeLanguageAction } from '../i18n-actions';

describe('i18n-reducer-test', () => {
  it('should return initial state', () => {
    const state = i18nReducer(undefined, {});

    expect(state).toEqual(INITIAL_STATE);
  });

  it('should handle changeLanguageAction.SUCCESS', () => {
    const payload = {
      language: 'en',
      messages: {
        'ui.usermenu.logout': 'Log out'
      }
    };
    const action = changeLanguageAction.success(payload);
    const state = i18nReducer(undefined, action);

    expect(state).toEqual({
      ...INITIAL_STATE,
      ...payload
    });
  });
});