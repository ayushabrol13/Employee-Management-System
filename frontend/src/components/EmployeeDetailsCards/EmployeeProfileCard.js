import { Link } from "react-router-dom";
import React,{useState} from 'react';

export default function EmployeeProfileCard() {
    const[name,setName]=useState('');
    const[department,setDepartmen]=useState('');
    const[localAddress,setLocalAddress]=useState('');

    return (
        <div className="col-lg-4">
            <div className="card mb-4">
                <div className="card-body text-center">
                    <h5 className="my-3">{name}</h5>
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