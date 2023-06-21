import React,{useState} from "react";
import {Link} from 'react-router-dom';
import EmployeeService from "../../services/EmployeeService";
export default function CreateEmployeeAuth(){
    const [mail,setEmail]= useState('');
    const [salary,setPassword]=useState('');
    const[name,setName]=useState('');
    const[empId,setEmpId]=useState(0);

    const [aadharNo,setAadhar]= useState('');
    const [panNo,setPan]=useState('');
    const department={depId:2};
    const [localAddress,setLocalAddress]= useState('');
    const [permanentAddress,setPermanentAddress]=useState('');
    const saveEmployeeAuth =(e)=>{
        e.preventDefault();
        const employee={empId,name,mail,salary,department};
        const identity={empId,panNo,aadharNo};
        const address={empId,localAddress,permanentAddress};
        EmployeeService.createEmployee(employee);
       // EmployeeService.createEmployeeIdentity(identity);
        //EmployeeService.createEmployeeAddress(address);
        alert("successfull");
        window.location.href = "http://localhost:3000";


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
                                    <label className="form-label">Email</label>
                                    <input
                                        type="email"
                                        placeholder="Enter the Email"
                                        name="email"
                                        className="form-control"
                                        value={mail}
                                        onChange={(e) => setEmail(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Password</label>
                                    <input
                                        type="number"
                                        placeholder="Enter the password"
                                        name="salary"
                                        className="form-control"
                                        value={salary}
                                        onChange={(e) => setPassword(e.target.value)}
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
                                    <label className="form-label">Employee Id</label>
                                    <input
                                        type="number"
                                        placeholder="Enter the employee id"
                                        name="empid"
                                        className="form-control"
                                        value={empId}
                                        onChange={(e) => setEmpId(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Aadhar Number</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the Aadhar Number"
                                        name="aadharNo"
                                        className="form-control"
                                        value={aadharNo}
                                        onChange={(e) => setAadhar(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Pan Number</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the name"
                                        name="panNo"
                                        className="form-control"
                                        value={panNo}
                                        onChange={(e) => setPan(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Local Address</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the local address"
                                        name="localAddress"
                                        className="form-control"
                                        value={localAddress}
                                        onChange={(e) => setLocalAddress(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Parmanent Address</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the permanent address"
                                        name="parmanentAddress"
                                        className="form-control"
                                        value={permanentAddress}
                                        onChange={(e) => setPermanentAddress(e.target.value)}
                                    >
                                    </input>

                                </div>



                                <button className="btn btn-success" onClick={(e)=> saveEmployeeAuth(e)} >Next</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
};