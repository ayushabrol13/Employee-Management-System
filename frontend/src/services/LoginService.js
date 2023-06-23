import axios from 'axios'
import EmployeeService from "./EmployeeService";
const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/employees';

class LoginService {
    async getEmployeeById(employeeId,password) {
        axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId).then((response) => {
            //setEmployee(response.data);
            //const originalPassword = employee;
            console.log(typeof(response.data.salary));
            console.log(typeof(password));
            if(response.data.salary==password){
               alert("ok")
            }
            else
                alert("not ok");
        }).catch(error => {
            console.log(error);
            alert(error);
        })
    }
}
export default new LoginService();



