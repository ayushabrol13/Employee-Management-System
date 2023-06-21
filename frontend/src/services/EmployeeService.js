import axios from 'axios'
const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/employees';
const EMPLOYEE_BASE_REST_API_URL_IDENTITY = 'http://localhost:8080/api/employees/identity';
class EmployeeService{
    async getAllEmployee(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL);
    }

    async getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);
    }

    async createEmployee(employee){
        return axios.post(EMPLOYEE_BASE_REST_API_URL,employee);
    }
    async createEmployeeIdentity(identity){
        return axios.post(EMPLOYEE_BASE_REST_API_URL_IDENTITY,identity);
    }
    async createEmployeeAddress(address){
        return axios.post(EMPLOYEE_BASE_REST_API_URL+"/address",address);
    }
    async deleteEmployee(empId){
        return axios.delete((EMPLOYEE_BASE_REST_API_URL+"/"+empId));
    }


}

export default new EmployeeService();