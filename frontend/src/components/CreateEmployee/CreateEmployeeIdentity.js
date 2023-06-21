import React,{useState} from "react";
import {Link} from 'react-router-dom';
export default function CreateEmployeeIdentity(){
    const [aadharNo,setAadhar]= useState('');
    const [panNo,setPan]=useState('');

    const saveEmployeeIdentity =(e)=>{
        e.preventDefault();

        const identity={aadharNo,panNo};
        console.log(identity);
        window.location.href = "http://localhost:3000/sign-up-address";

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

                                <button className="btn btn-success" onClick={(e)=> saveEmployeeIdentity(e)} >Next</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
};