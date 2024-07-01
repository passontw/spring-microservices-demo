import {put, call, select} from 'redux-saga/effects';
import types from 'constants/actionTypes';
import { getEmployeeByIdResult } from 'apis/employeeResult';

const okGetEmployeeById = (payload) => {
    return {
      type: types.GET_EMPLYEE_BY_ID_SUCCESS,
      payload
    };
  };
  
  const errGetEmployeeById = (message) => {
    return {
      type: types.GET_EMPLYEE_BY_ID_ERROR,
      payload: {
        message,
      },
    };
  };
  
  export function* getEmployeeByIdSaga({payload}) {
    try {
      const {data: response} = yield call(getEmployeeByIdResult, {
          payload,
      });
      yield put(okGetEmployeeById(response));
    } catch (error) {
      yield put(errGetEmployeeById(error.response.data.message));
    }
  }
  