import types from "constants/actionTypes";
import cloneDeep from "lodash/cloneDeep";
import initialState from "./initialState";

export default function reducer(
    employee = { ...cloneDeep(initialState.employee) },
  { type, payload }
) {
  switch (type) {
    case types.GET_EMPLYEE_BY_ID_SUCCESS:
        return {
            ...employee,
            info: payload,
        };
    case types.GET_EMPLYEE_BY_ID:
    case types.GET_EMPLYEE_BY_ID_ERROR:
    default:
      return employee;
  }
}
