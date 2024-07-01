import { combineReducers } from 'redux';
import customization from './customizationReducer';
import task from './taskReducer';
import auth from './authReducer';
import employee from './employeeReducer';

const appReducer = combineReducers({
  task,
  auth,
  employee,
  customization,
});

const rootReducer = (state, action) => {
  return appReducer(state, action);
};

export default rootReducer;
