import axios from 'axios'
const DEPARTMENT_BASE_REST_API_URL = 'http://localhost:8080/api/departments';
const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/employees';
const EMPLOYEE_BASE_REST_API_URL_IDENTITY = 'http://localhost:8080/api/employees/identity';
class EmployeeService{
    async getAllEmployee(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL);
    }

    async getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);
    }


    async getEmployeeIdentitybyId(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL+"/identity/"+employeeId);
    }

    async getEmployeeAddressbyId(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL+"/address/"+employeeId);
    }
    async getDepartment(){
        return axios.get(DEPARTMENT_BASE_REST_API_URL);
    }
    async getDepartmentById(depId){
        return axios.get(DEPARTMENT_BASE_REST_API_URL+"/"+depId);
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

    async updateEmployee(employee){
        console.log("empOK")
        return axios.put(EMPLOYEE_BASE_REST_API_URL,employee);
    }
    async updateEmployeeIdentity(identity){
        console.log("IdOk")

        return axios.put(EMPLOYEE_BASE_REST_API_URL+"/identity",identity);
    }
    async updateEmployeeAddress(address){
        console.log("AddOk")

        return axios.put(EMPLOYEE_BASE_REST_API_URL+"/address",address);
    }

}

export default new EmployeeService();