import { createSelector } from 'reselect';
import { isEmpty } from 'ramda';

const getRoot = state =>
  state.graveowner;

export const graveownerListSelector = state =>
  getRoot(state).list;

export const graveownerSelectedIndexSelector = state =>
  getRoot(state).selectedIndex;

export const selectedGraveownerSelector = createSelector(
  graveownerListSelector,
  graveownerSelectedIndexSelector,
  (list, index) => {
    const { graveowners } = list;

    if (index === null || isEmpty(graveowners) || graveowners.length <= index) {
      return null;
    }

    return graveowners[index];
  }
);
