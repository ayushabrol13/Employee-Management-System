import React from "react"
import { useState } from "react"


export default function EmployeeList(){
    const[employee,setEmployee]=useState([]);
    return(
    <div className="col">
        <div className="card">
            <h2 className="text-center">Employees</h2>
            <table className="table table-bordered table -striped">
                <thead>
                    <th>Employee Id</th>
                    <th>Name</th>
                    <th>Department</th>
                </thead>
                <tbody>
                    
                </tbody>
            </table>

        </div>


    </div>
    );
};