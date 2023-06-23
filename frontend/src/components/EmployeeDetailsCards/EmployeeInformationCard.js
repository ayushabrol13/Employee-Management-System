import React, {useEffect, useState} from 'react';
import EmployeeService from "../../services/EmployeeService";
import {useParams} from "react-router-dom";


export default function EmployeeInformationCard(){
  const {id}= useParams();
  const[employee,setEmployee]=useState([]);
  const[address,setAddress]=useState([]);
  useEffect(() => {
    EmployeeService.getEmployeeById(id).then((response)=>{
      setEmployee(response.data)
    }).catch(error=>{
      console.log(error);
    });

    EmployeeService.getEmployeeAddressbyId(id).then((response) => {
      setAddress(response.data);
    }).catch(error=>{
      console.log(error);
    });
  }, []);




  return(
        <div className="col-lg-8">
        <div className="card mb-4">
          <div className="card-body">
            <div className="row">
            <div className="col-sm-3">
                <p className="mb-0">Employee ID</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{employee.empId} </p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Full Name</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{employee.name}</p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Email</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{employee.mail}</p>
              </div>
            </div>
           
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Local Address</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{address.localAddress}</p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Permanent Address</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">{address.permanentAddress}</p>
              </div>
            </div>
          </div>
        </div>

      </div>
    )
}