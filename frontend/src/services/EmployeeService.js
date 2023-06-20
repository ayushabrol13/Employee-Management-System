import axios from 'axios'
const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/employees';

class EmployeeService{
    getAllEmployee(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL);
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);
    }
}

export default new EmployeeService();