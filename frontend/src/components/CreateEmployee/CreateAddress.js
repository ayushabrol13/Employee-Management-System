import React,{useState} from "react";
export default function CreateAddress(){
    const [localAddress,setLocalAddress]= useState('');
    const [permanentAddress,setPermanentAddress]=useState('');

    const saveEmployeeAddress =(e)=>{
        e.preventDefault();

        const address={localAddress,permanentAddress};
        console.log(address);
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
                                    <label className="form-label">Local Address</label>
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
                                    <label className="form-label">Pan Number</label>
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



                                 <button className="btn btn-success" onClick={(e)=> saveEmployeeAddress(e)} >Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
};