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
import Sidebar from "./components/Sidebar";
import CreateEmployeeFrontend from "./components/CreateEmployeeFrontend";
import EmployeeDetail from "./components/EmployeeDetail";
function App() {
  return (
      <div>
        <Router>
          <HeaderComponent />
          <div className="container">
            <Routes>
              <Route path="/all-employee" element={<ListEmployeeComponent />} />
              <Route path="/" element={<MainPage />} />
              <Route path="/sign-in" element={<LoginForm />} />
              <Route path="/sign-up" element={<CreateEmployeeFrontend />} />
              <Route path="/add-employee" element={<CreateEmployeeFrontend/>} />
              <Route path="/edit-employee" element={<EmployeeDetail/>} />
            </Routes>
          </div>
        </Router>
        <FooterComponent />
      </div>
  );
}

export default App;