import axios from 'axios'
const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/employees';

class EmployeeService{
    getAllEmployee(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL);
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);
    }

    createEmployee(employee){
        return axios.post(EMPLOYEE_BASE_REST_API_URL,employee);
    }
    createEmployeeIdentity(identity){
        return axios.post(EMPLOYEE_BASE_REST_API_URL+"/identity",identity);
    }
    createEmployeeAddress(address){
        return axios.post(EMPLOYEE_BASE_REST_API_URL+"/address",address);
    }


}

export default new EmployeeService();