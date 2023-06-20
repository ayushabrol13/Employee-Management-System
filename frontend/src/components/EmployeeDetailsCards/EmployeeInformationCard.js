export default function EmployeeInformationCard(){
    return(
        <div className="col-lg-8">
        <div className="card mb-4">
          <div className="card-body">
            <div className="row">
            <div className="col-sm-3">
                <p className="mb-0">Employee ID</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">28456 </p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Full Name</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">Johnatan Smith</p>
              </div>
            </div>
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Email</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">example@example.com</p>
              </div>
            </div>
           
            <hr />
            <div className="row">
              <div className="col-sm-3">
                <p className="mb-0">Address</p>
              </div>
              <div className="col-sm-9">
                <p className="text-muted mb-0">Bay Area, San Francisco, CA</p>
              </div>
            </div>
          </div>
        </div>

      </div>
    )
}