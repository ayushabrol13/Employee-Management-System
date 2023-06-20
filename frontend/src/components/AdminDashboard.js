import EmployeeList from "./DashBoardComponents/EmployeeList";
import ManageEmployee from "./DashBoardComponents/ManageEmployee";

export default function AdminDashboard(){
return(
    <div className="container">
        <div className="row">
            <EmployeeList/>
            <ManageEmployee/>
        </div>
        
    </div>
)
}