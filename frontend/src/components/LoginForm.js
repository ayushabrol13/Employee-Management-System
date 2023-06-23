import React, {useEffect, useState} from 'react';
import { motion } from 'framer-motion';
import EmployeeService from "../services/EmployeeService";
import LoginService from "../services/LoginService";
export default function Login(){
  const [empId, setEmpId] = useState('');
  const [password, setPassword] = useState('');

  return (
    <div style={styles.container}>
      <motion.div
        initial={{ scale: 0 }}
        animate={{ scale: 1 }}
        transition={{ duration: 0.5 }}
        style={styles.card}
      >
        <h2 style={styles.title}>Login Form</h2>
        <form >
          <div>
            <label htmlFor="username">Employee Id</label>
            <input
              type="number"
              id="username"
              value={empId}
              onChange={(e) => setEmpId(e.target.value)}
              style={styles.input}
            />
          </div>
          <div>
            <label htmlFor="password">Password</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              style={styles.input}
            />
          </div>
          <button
            type=""
           // whileHover={{ scale: 1.1 }}
            //whileTap={{ scale: 0.9 }}
            style={styles.button}
            onClick={(e) =>{
              LoginService.getEmployeeById(empId,password)
            }}
          >
            Login
          </button>
        </form>
      </motion.div>
    </div>
  );
};

const styles = {
  container: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100vh',
  },
  card: {
    width: '300px',
    padding: '20px',
    borderRadius: '8px',
    background: 'rgba(255, 255, 255, 0.9)',
    boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
  },
  title: {
    fontSize: '20px',
    fontWeight: 'bold',
    margin: '0 0 20px 0',
    color: '#333',
  },
  input: {
    width: '100%',
    padding: '8px',
    marginBottom: '10px',
    borderRadius: '4px',
    border: '1px solid #ccc',
  },
  button: {
    width: '100%',
    padding: '10px',
    fontSize: '16px',
    fontWeight: 'bold',
    border: 'none',
    borderRadius: '4px',
    background: '#009B37',
    color: '#fff',
    cursor: 'pointer',
  },
};

