import React, { useEffect, useState } from 'react'
import EmployeeService from '../services/EmployeeService'
import { Link } from 'react-router-dom'

export const ListEmployeeComponent = () => {
    const [designation,setDesignation]=useState((''));
   const [employees, setEmployees] =useState ([])
    useEffect(() => {
        EmployeeService.getAllEmployee().then((response)=>{
            setEmployees(response.data);

        }).catch(error=>{
        })
    }, [])
    const saveEmployeeAuth =(e,id)=>{
    EmployeeService.deleteEmployee(id);
    alert("Employee with id "+id+" deleted successfully");
    window.location.href="http://localhost:3000/all-employee";
    }
    
  return (
    <div className="container">
        <h2 className='text-center'>List Employees</h2>
        <Link to ="/add-employee" className="btn btn-primary mb-2">Add Employee</Link>  
        <table className='table table-bordered table-striped'>
            <thead>
                <th>Employee ID</th>
                <th>Email</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Actions</th>
            </thead>
            { <tbody>
                {
                    employees.map(
                        employee =>
                        <tr key={employee.empId}>
                            <td>{employee.empId}</td>
                            <td>{employee.mail}</td>
                            <td>{employee.name}</td>
                            <td>{employee.department===null?'':employee.department.designation}</td>
                            <td>
                                <Link className="btn btn-info" to={`/view-employee/${employee.empId}`}>View</Link>
                                <button className="btn btn-danger" style={{marginLeft:"5%"}} onClick={(e)=> saveEmployeeAuth(e,employee.empId) }>Delete</button>

                            </td>
                        </tr>
                    )
                }
            </tbody> }
        </table>
    </div>
  )
}
export default ListEmployeeComponent