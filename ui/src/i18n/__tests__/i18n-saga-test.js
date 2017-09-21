import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import SagaTester from 'redux-saga-tester';

import { i18nReducer, INITIAL_STATE } from '../i18n-reducer';
import { i18nSagas } from '../i18n-saga';
import { changeLanguageRoutine } from '../i18n-routines';

describe('i18n-saga-test', () => {
  it('should handle change language success', async () => {
    const mock = new MockAdapter(axios);
    const payload = {
      language: 'en',
      messages: {
        'security.context.auth.error': 'Spring security context authentication is null.'
      }
    };
    mock.onGet('/api/dictionary/en').reply(200, payload);

    const sagaTester = new SagaTester({
      initialState: INITIAL_STATE,
      reducers: i18nReducer
    });

    sagaTester.start(i18nSagas);
    expect(sagaTester.getState()).toEqual(INITIAL_STATE);

    sagaTester.dispatch(changeLanguageRoutine.trigger('en'));
    expect(sagaTester.wasCalled(changeLanguageRoutine.TRIGGER)).toBe(true);

    await sagaTester.waitFor(changeLanguageRoutine.SUCCESS);
    expect(sagaTester.wasCalled(changeLanguageRoutine.SUCCESS)).toBe(true);
    expect(sagaTester.getState()).toEqual(payload);
  });

  it('should handle change language fail', async () => {
    const mock = new MockAdapter(axios);
    mock.onGet('/api/dictionary').reply(404);

    const sagaTester = new SagaTester({
      initialState: INITIAL_STATE,
      reducers: i18nReducer
    });

    sagaTester.start(i18nSagas);
    expect(sagaTester.getState()).toEqual(INITIAL_STATE);

    sagaTester.dispatch(changeLanguageRoutine.trigger());
    expect(sagaTester.wasCalled(changeLanguageRoutine.TRIGGER)).toBe(true);

    await sagaTester.waitFor(changeLanguageRoutine.FAILURE);
    expect(sagaTester.wasCalled(changeLanguageRoutine.FAILURE)).toBe(true);
    expect(sagaTester.getState()).toEqual(INITIAL_STATE);
  });
});
