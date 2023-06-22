import React from 'react'
import { useState, useEffect } from 'react';

import EmployeeService from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";



export default function EditEmployeeComponent() {
    const [mail, setEmail] = useState('');
    const [salary, setPassword] = useState('');
    const [name, setName] = useState('');

    const [aadharNo, setAadhar] = useState('');
    const [panNo, setPan] = useState('');
    const department = { depId: 2 };
    const [localAddress, setLocalAddress] = useState('');
    const [permanentAddress, setPermanentAddress] = useState('');
    const [empId, setEmpId] = useState(0);
    const navigate = useNavigate();

    const updateEmployeeAuth = (e) => {
        e.preventDefault();
        const employee = { empId, name, mail, salary, department };
        const identity = { empId, panNo, aadharNo };
        const address = { empId, localAddress, permanentAddress };

        EmployeeService.updateEmployee(employee);
        EmployeeService.updateEmployeeIdentity(identity);
        EmployeeService.updateEmployeeAddress(address);
        alert("successfull");
        navigate.push("/employees");
    }
    useEffect(() => {
        EmployeeService.getEmployeeById(empId).then((res) => {
            let employee = res.data;
            setEmail(employee.mail);
            setPassword(employee.salary);
            setName(employee.name);
            setEmpId(employee.empId);
        });
        EmployeeService.getEmployeeIdentityById(empId).then((res) => {
            let identity = res.data;
            setAadhar(identity.aadharNo);
            setPan(identity.panNo);
        });
        EmployeeService.getEmployeeAddressById(empId).then((res) => {
            let address = res.data;
            setLocalAddress(address.localAddress);
            setPermanentAddress(address.permanentAddress);
        });
    }, []);





    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h2 className="text-center">Update Details</h2>
                        <div className="card-body">
                            <form>
                                <div className="form-group mb-2">
                                    <label className="form-label">Update Email</label>
                                    <input
                                        type="email"
                                        placeholder="Enter new Email"
                                        name="email"
                                        className="form-control"
                                        value={mail}
                                        onChange={(e) => setEmail(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Update Name</label>
                                    <input
                                        type="text"
                                        placeholder="Update name"
                                        name="name"
                                        className="form-control"
                                        value={name}
                                        onChange={(e) => setName(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Update Aadhar Number</label>
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
                                    <label className="form-label">Update Pan Number</label>
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
                                    <label className="form-label">Update Local Address</label>
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
                                    <label className="form-label">Update Permanent Address</label>
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

                                <button className="btn btn-success" onClick={(e)=> updateEmployeeAuth(e)} >Update</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}