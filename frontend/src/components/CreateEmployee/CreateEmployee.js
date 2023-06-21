import React,{useState} from "react";
import {Link} from 'react-router-dom';
export default function CreateEmployee(){
    const [name,setName]= useState('');
    const [empId,setEmpId]=useState(0);
    const [salary,setSalary]=useState(0);

    const saveEmployee =(e)=>{
        e.preventDefault();

        const employee={empId,name,salary};
        console.log(employee);
        window.location.href = "http://localhost:3000/sign-up-identity";

    }

    return(
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h2 className="text-center">Sign Up</h2>
                        <div className="card-body">
                            <form>
                                <div className="form-group mb-2">
                                    <label className="form-label">Employee Id</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the Employee ID"
                                        name="empId"
                                        className="form-control"
                                        value={empId}
                                        onChange={(e) => setEmpId(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Name</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the name"
                                        name="name"
                                        className="form-control"
                                        value={name}
                                        onChange={(e) => setName(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Salary</label>
                                    <input
                                        type="number"
                                        placeholder="Enter the salary"
                                        name="salary"
                                        className="form-control"
                                        value={salary}
                                        onChange={(e) => setSalary(e.target.value)}
                                    >
                                    </input>

                                </div>

                                    <button className="btn btn-success" to="/sign-up-identity" onClick={(e)=> saveEmployee(e)} >Next</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
};