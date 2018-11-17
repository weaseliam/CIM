import { createSelector } from 'reselect';

import { graveMapSelector } from '../grave/grave-selector';

const getRoot = state =>
  state.contract;

export const contractListSelector = state =>
  getRoot(state).list;

export const contractListWithGravesSelector = createSelector(
  contractListSelector,
  graveMapSelector,
  ({ contracts = [] }, graves) =>
    contracts.map((contract) => {
      const { graveId } = contract;
      return {
        ...graves[graveId],
        ...contract
      };
    })
);
