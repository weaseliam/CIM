const TRIGGER = 'TRIGGER';
const REQUEST = 'REQUEST';
const SUCCESS = 'SUCCESS';
const FAILURE = 'FAILURE';
const FULFILL = 'FULFILL';

const stages = [TRIGGER, REQUEST, SUCCESS, FAILURE, FULFILL];

const identity = i => i;

/**
 * Create a smart action for the specified action name.
 * 
 * Supports 5 constants: TRIGGER, REQUEST, SUCCESS, FAILURE, FULFILL.
 * 
 * Supports 5 functions: trigger(payload), request(payload), success(payload),
 * failure(payload), fulfill(payload).
 * 
 * A payloadCreator function can be provided, it will be called for each supported function call.
 * 
 * @param {string} [actionName=''] 
 * @param {function} [payloadCreator=identity] 
 * @returns 
 */
export const createAction = (actionName = '', payloadCreator = identity) => {
  if (typeof actionName !== 'string') {
    throw new Error('Invalid action name, it should be a string !');
  }

  const action = stages.reduce((result, stage) => {
    const stageActionType = `${actionName}_${stage}`;
    const stageActionCreator = payload => ({
      type: stageActionType,
      payload: payloadCreator(payload),
    });

    return Object.assign(result, {
      [stage]: stageActionType,
      [stage.toLowerCase()]: stageActionCreator,
    });
  }, {});

  return action;
};
