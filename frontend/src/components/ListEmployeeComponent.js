import React, { useEffect, useState } from 'react'
import EmployeeService from '../services/EmployeeService'
import { Link } from 'react-router-dom'

export const ListEmployeeComponent = () => {

   const [employees, setEmployees] =useState ([])
    useEffect(() => {
        EmployeeService.getAllEmployee().then((response)=>{
            setEmployees(response.data)
            console.log(response.data);
        }).catch(error=>{
            console.log(error);
        })
    }, [])
    
  return (
    <div className="container">
        <h2 className='text-center'>List Employees</h2>
        <Link to ="/add-employee" className="btn btn-primary mb-2">Add Employee</Link>  
        <table className='table table-bordered table-striped'>
            <thead>
                <th>Employee ID</th>
                <th>Employee Email</th>
                <th>Employee Name</th>
                <th>Employee Salary</th>
                <th>Employee Department Id</th>
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
                            <td>{employee.salary}</td>
                            <td>{employee.dep_id}</td>
                            <td>
                                <Link className="btn btn-info" to={`/edit-employee/${employee.empId}`}>Update</Link>
                                <Link className="btn btn-danger" to={`/edit-employee/${employee.empId}`}>Delete</Link>

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