const authState = {
  isAuth: false,
};

const customizationState = {
  isOpen: [], // for active default menu
  fontFamily: `'Roboto', sans-serif`,
  borderRadius: 12,
  opened: true,
};


const taskState = {
  rows: [],
  totalCount: 0,
};

const employeeState = {
  info: {},
};
const initialState = {
  auth: authState,
  task: taskState,
  employee: employeeState,
  customization: customizationState,
};

export default initialState;
