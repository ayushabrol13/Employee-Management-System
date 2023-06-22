import {Link, useParams} from "react-router-dom";
import React, {useEffect, useState} from 'react';
import EmployeeService from "../../services/EmployeeService";

export default function EmployeeProfileCard() {
    const[department,setDepartment]=useState([]);
    const[localAddress,setLocalAddress]=useState('');
    const[mailingId,setMailingId]=useState('');


    const {id}= useParams();
    const[employee,setEmployee]=useState([]);
    useEffect(() => {
        EmployeeService.getEmployeeById(id).then((response)=>{
            setEmployee(response.data);
            setDepartment(response.data.department);
            setMailingId('mailto:'+response.data.mail);
            console.log(response.data);
        }).catch(error=>{
            console.log(error);
        })
        EmployeeService.getEmployeeAddressbyId(employee.empId).then((response)=>{
            setLocalAddress(response.data.localAddress);

        }).catch(error=>{
            console.log(error);
        })


    }, []);
    return (
        <div className="col-lg-4">
            <div className="card mb-4">
                <div className="card-body text-center">
                    <i className="fa fa-user fa-5x"></i>
                    <h5 className="my-3">{employee.name}</h5>
                    <p className="text-muted mb-1">{department.designation}</p>
                    <p className="text-muted mb-1">{department.depName}</p>
                    <p className="text-muted mb-4">{localAddress}</p>
                    <div className="d-flex justify-content-center mb-2">
                        <button type="button" className="btn btn-primary" style={{ backgroundColor: "green" }}>
                            Update
                        </button>
                        <a href={mailingId}>
                            <button type="button" className="btn btn-outline-primary ms-1" style={{ color: "green" }}>
                                Email
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    );
}