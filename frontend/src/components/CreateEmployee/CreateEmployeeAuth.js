import React,{useState} from "react";
import {Link} from 'react-router-dom';
export default function CreateEmployeeAuth(){
    const [email,setEmail]= useState('');
    const [password,setPassword]=useState('');

    const saveEmployeeAuth =(e)=>{
        e.preventDefault();

        const identity={email,password};
        console.log(identity);
        window.location.href = "http://localhost:3000/sign-up-employee";

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
                                        value={email}
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
                                        onChange={(e) => setPassword(e.target.value)}
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