import { useState } from "react";

export default function ManageEmployee(){
    
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
                    <th>Action</th>
                </thead>
                <tbody>
                    
                </tbody>
            </table>

        </div>


    </div>
    );
    
};