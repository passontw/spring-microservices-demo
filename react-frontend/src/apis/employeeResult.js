import server from ".";

export const getEmployeeByIdResult = ({ payload }) =>
    server.get(`employee-service/api/employees/${payload.employeeId}`);
