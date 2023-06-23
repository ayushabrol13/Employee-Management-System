import React from 'react'
import { useState, useEffect } from 'react';

import EmployeeService from "../services/EmployeeService";
import { useParams} from "react-router-dom";



export default function EditEmployeeComponent() {
    const {id}= useParams();
    const [mail, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');

    const [aadharNo, setAadhar] = useState('');
    const [panNo, setPan] = useState('');
    const[depId,setDepId]=useState(0);
    const [localAddress, setLocalAddress] = useState('');
    const [permanentAddress, setPermanentAddress] = useState('');
    const [departments,setDepartments]=useState([{}]);


    const updateEmployeeAuth = async (e) => {
        e.preventDefault();
        const department={depId};
        const empId=parseInt(id);
        const employee = {empId, name, mail, password, department};
        const identity = {empId, panNo, aadharNo,employee};
        const address = {empId, localAddress, permanentAddress,employee};

        await EmployeeService.updateEmployee(employee).then().catch(error => console.log(error));
        await EmployeeService.updateEmployeeIdentity(identity).then().catch(error => console.log(error));
        await EmployeeService.updateEmployeeAddress(address).then().catch(error => console.log(error));
        alert("successfull");
        window.location.href = "http://localhost:3000/view-employee/" + id;
    }
    useEffect( () => {

         EmployeeService.getEmployeeById(id).then((response) => {
            setName(response.data.name);
            setEmail(response.data.mail);
            setPassword(response.data.password);
        }).catch(error => {
            console.log(error);
        });
         EmployeeService.getEmployeeIdentitybyId(id).then((response) => {
            setAadhar(response.data.aadharNo);
            setPan(response.data.panNo);
        }).catch(error => {
            console.log(error);
        });
         EmployeeService.getEmployeeAddressbyId(id).then((response) => {
            setLocalAddress(response.data.localAddress);
            setPermanentAddress(response.data.permanentAddress);
        }).catch(error => {
            console.log(error);
        });
        EmployeeService.getDepartment().then((response)=>{
            setDepartments(response.data);
        }).catch(error=>{
            console.log(error);
        });

    }, []);

    const dep_items= departments.map((dep)=> <option value={dep.depId}>{dep.depId} - {dep.designation} {dep.depName}</option>)

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
                                        placeholder={mail}
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
                                        placeholder={name}
                                        name="name"
                                        className="form-control"
                                        value={name}
                                        onChange={(e) => setName(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Update Department  -</label>
                                    <select
                                        //     name="empid"
                                        //     className="form-control"
                                        value={depId}
                                        //     required="true"
                                        onChange={(e) => setDepId(e.target.value)}
                                        // >
                                    >
                                        {dep_items}
                                    </select>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Update Aadhar Number</label>
                                    <input
                                        type="text"
                                        placeholder={aadharNo}
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
                                        placeholder={panNo}
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
                                        placeholder={localAddress}
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
                                        placeholder={permanentAddress}
                                        name="parmanentAddress"
                                        className="form-control"
                                        value={permanentAddress}
                                        onChange={(e) => setPermanentAddress(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <button className="btn btn-success"  onClick={(e)=> updateEmployeeAuth(e)} >Update</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}