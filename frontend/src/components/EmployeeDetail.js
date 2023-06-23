import React from "react";
import EmployeeProfileCard from "./EmployeeDetailsCards/EmployeeProfileCard";
import EmployeeInformationCard from "./EmployeeDetailsCards/EmployeeInformationCard";

export default function EmployeeDetail(){
    return(
        <section style={{ backgroundColor: "#ffffff" }}>
        <div className="container py-5">
          
          <div className="row">
            <EmployeeProfileCard />
           <EmployeeInformationCard/>
          </div>
        </div>
      </section>
      
    )
};