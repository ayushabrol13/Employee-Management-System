import React, {useEffect, useState} from "react";
import EmployeeService from "../../services/EmployeeService";
export default function CreateEmployeeAuth(){
    const [mail,setEmail]= useState('');
    const [password,setPassword]=useState('');
    const[name,setName]=useState('');
    const[empId,setEmpId]=useState(0);

    const [aadharNo,setAadhar]= useState('');
    const [panNo,setPan]=useState('');
    const[depId,setDepId]=useState(0);
    const [localAddress,setLocalAddress]= useState('');
    const [permanentAddress,setPermanentAddress]=useState('');
    const [departments,setDepartments]=useState([{}]);

    useEffect( () => {
        EmployeeService.getDepartment().then((response)=>{
            setDepartments(response.data);
        }).catch(error=>{
            console.log(error);
        });

    },[]);
    const saveEmployeeAuth =async (e) => {



        e.preventDefault();
        const department={depId};
        const employee = {empId, name, mail, password, department};
        const identity = {empId,panNo, aadharNo, employee};
        const address = {empId,localAddress, permanentAddress, employee};
        await EmployeeService.createEmployee(employee).then((response)=>{
            setEmpId(response.data.empId);
        });
        await EmployeeService.createEmployeeIdentity(identity);
        await EmployeeService.createEmployeeAddress(address);
        alert("successfull");
    }
    const dep_items= departments.map((dep)=> <option value={dep.depId}>{dep.depId} - {dep.designation} {dep.depName}</option>)

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
                                        required="true"
                                        onChange={(e) => setEmail(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Password</label>
                                    <input
                                        type="password"
                                        placeholder="Enter the password"
                                        name="password"
                                        className="form-control"
                                        value={password}
                                        required="true"
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
                                        required="true"
                                        onChange={(e) => setName(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label">Department Id  -</label>
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
                                    <label className="form-label">Aadhar Number</label>
                                    <input
                                        type="text"
                                        placeholder="Enter the Aadhar Number"
                                        name="aadharNo"
                                        className="form-control"
                                        value={aadharNo}
                                        required="true"
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
                                        required="true"
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
                                        required="true"
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
                                        required="true"
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