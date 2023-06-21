import React, {useState} from 'react';



export default function EmployeeInformationCard(){
  const[empId,setEmpId]=useState(0);
  const[name,setName]=useState('');
  const[email,setEmail]=useState('');
  const[localAddress,setLocalAddress]=useState('');
  const[permanentAddress,setPermanentAddress]=useState('');


  return(
        <div className="col-lg-8">
        <div className="card mb-4">
          <div className="card-body">
            <div className="row">
            <div className="col-sm-3">
                <p className="mb-0">Employee ID</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{empId} </p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Full Name</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{name}</p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Email</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{email}</p>
              </div>
            </div>
           
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Local Address</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{localAddress}</p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Permanent Address</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{permanentAddress}</p>
              </div>
            </div>
          </div>
        </div>

      </div>
    )
}