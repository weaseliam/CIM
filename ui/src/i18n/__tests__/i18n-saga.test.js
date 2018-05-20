import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import SagaTester from 'redux-saga-tester';

import { i18nReducer, INITIAL_STATE as I18N_INITIAL_STATE } from '../i18n-reducer';
import { i18nSagas } from '../i18n-saga';
import { changeLanguageAction } from '../i18n-actions';
import * as i18nc from '../i18n-constants';

const INITIAL_STATE = {
  i18n: I18N_INITIAL_STATE
};

describe('i18n-saga-test', () => {
  it('should handle change language success', async () => {
    const mock = new MockAdapter(axios);
    const payload = {
      language: 'ro',
      messages: {
        [i18nc.HEADER_USERMENU_LOGOUT]: 'Delogare'
      }
    };
    mock.onGet('/api/dictionary/ro').reply(200, payload);

    const sagaTester = new SagaTester({
      initialState: INITIAL_STATE,
      reducers: {
        i18n: i18nReducer
      }
    });

    sagaTester.start(i18nSagas);
    expect(sagaTester.getState()).toEqual(INITIAL_STATE);

    sagaTester.dispatch(changeLanguageAction.trigger('ro'));
    expect(sagaTester.wasCalled(changeLanguageAction.TRIGGER)).toBe(true);

    await sagaTester.waitFor(changeLanguageAction.SUCCESS);
    expect(sagaTester.getState().i18n).toEqual({
      ...I18N_INITIAL_STATE,
      ...payload
    });
  });

  it('should handle change language fail', async () => {
    const mock = new MockAdapter(axios);
    mock.onGet('/api/dictionary').reply(404);

    const sagaTester = new SagaTester({
      initialState: INITIAL_STATE,
      reducers: {
        i18n: i18nReducer
      }
    });

    sagaTester.start(i18nSagas);
    expect(sagaTester.getState()).toEqual(INITIAL_STATE);

    sagaTester.dispatch(changeLanguageAction.trigger());
    expect(sagaTester.wasCalled(changeLanguageAction.TRIGGER)).toBe(true);

    expect(sagaTester.wasCalled(changeLanguageAction.SUCCESS)).toBe(false);

    expect(sagaTester.getState()).toEqual(INITIAL_STATE);
  });
});
