import "./App.css";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import MainPage from "./components/MainPage";
import LoginForm from "./components/LoginForm";
import EmployeeDetail from "./components/EmployeeDetail";
import CreateEmployeeIdentity from "./components/CreateEmployee/CreateEmployeeIdentity";
import CreateAddress from "./components/CreateEmployee/CreateAddress";
import CreateEmployeeAuth from "./components/CreateEmployee/CreateEmployeeAuth";
function App() {
  return (
      <div>
        <Router>
          <HeaderComponent />
          <div className="container">
            <Routes>
              <Route path="/" element={<MainPage />} />
              <Route path="/all-employee" element={<ListEmployeeComponent />} />
              <Route path="/sign-in" element={<LoginForm />} />
              <Route path="/edit-employee/:id" element={<EmployeeDetail/>} />
              <Route path="/add-employee" element={<CreateEmployeeAuth/>} />
              <Route path="/sign-up" element={<CreateEmployeeAuth />} />
              <Route path="/sign-up-identity" element={<CreateEmployeeIdentity/>}/>
              <Route path="/sign-up-address" element={<CreateAddress/>}/>
            </Routes>
          </div>
        </Router>
        <FooterComponent />
      </div>
  );
}

export default App;