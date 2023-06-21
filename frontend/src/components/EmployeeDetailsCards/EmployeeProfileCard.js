import {Link, useParams} from "react-router-dom";
import React, {useEffect, useState} from 'react';
import EmployeeService from "../../services/EmployeeService";

export default function EmployeeProfileCard() {
    const[name,setName]=useState('');
    const[department,setDepartmen]=useState('');
    const[localAddress,setLocalAddress]=useState('');




    const {id}= useParams();
    const[employee,setEmployee]=useState([]);
    useEffect(() => {
        EmployeeService.getEmployeeById(id).then((response)=>{
            setEmployee(response.data)
            console.log(response.data);
        }).catch(error=>{
            console.log(error);
        })
    }, []);
    return (
        <div className="col-lg-4">
            <div className="card mb-4">
                <div className="card-body text-center">
                    <h5 className="my-3">{employee.name}</h5>
                    <p className="text-muted mb-1">{department}</p>
                    <p className="text-muted mb-4">{localAddress}</p>
                    <div className="d-flex justify-content-center mb-2">
                        <button type="button" className="btn btn-primary" style={{ backgroundColor: "green" }}>
                            Update
                        </button>
                        <a href="https://mail.google.com/mail/u/0/#inbox?compose=new">
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