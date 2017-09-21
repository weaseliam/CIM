import { i18nReducer, INITIAL_STATE } from '../i18n-reducer';
import { changeLanguageRoutine } from '../i18n-routines';

describe('i18n-reducer-test', () => {
  it('should return initial state', () => {
    const state = i18nReducer(undefined, {});

    expect(state).toEqual(INITIAL_STATE);
  });

  it('should handle changeLanguageRoutine.SUCCESS', () => {
    const payload = {
      language: 'en',
      messages: {
        'security.context.auth.error': 'Spring security context authentication is null.'
      }
    };
    const action = changeLanguageRoutine.success(payload);
    const state = i18nReducer(undefined, action);

    expect(state).toEqual(payload);
  });
});
