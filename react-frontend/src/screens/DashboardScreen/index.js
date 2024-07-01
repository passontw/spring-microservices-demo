import { connect } from "react-redux";
import DashboardScreen from "./view";
import { getEmployeeByIdAction } from "actions/employeeActions";

const mapStateToProps = ({ employee }) => ({ employeeInfo: employee.info });

const mapDispatchToProps = (dispatch) => ({
  handleGetEmployeeById: (payload) => {
    dispatch(getEmployeeByIdAction(payload));
  },
});

export default connect(mapStateToProps, mapDispatchToProps)(DashboardScreen);
