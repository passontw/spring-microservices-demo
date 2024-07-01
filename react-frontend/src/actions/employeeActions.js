import types from 'constants/actionTypes';

export const getEmployeeByIdAction = (payload) => ({
  type: types.GET_EMPLYEE_BY_ID,
  payload,
});