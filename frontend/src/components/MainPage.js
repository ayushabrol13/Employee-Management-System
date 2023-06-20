import React from 'react';
import { motion } from 'framer-motion';
import { Link } from 'react-router-dom';

const ButtonComponent = () => {
  const handleUserButtonClick = () => {
    console.log('User Button Clicked');
    // Add your user button logic here
  };

  const handleAdminButtonClick = () => {
    console.log('Admin Button Clicked');
    // Add your admin button logic here
  };

  const handleSignUpButtonClick = () => {
    console.log('Sign Up Button Clicked');
    // Add your sign up button logic here
  };

  return (
    <div style={styles.container}>
      <motion.div style={styles.card}>
        <h2 style={styles.title}>Login as</h2>
        <div style={styles.buttonContainer}>
          <Link to="/sign-in">
          <motion.button
            onClick={handleUserButtonClick}
            style={styles.button}
            whileHover={{ scale: 1.1 }}
            whileTap={{ scale: 0.9 }}
          >
            User
          </motion.button>
          </Link>
          <Link to="/sign-in">
          <motion.button
            
            style={styles.button}
            whileHover={{ scale: 1.1 }}
            whileTap={{ scale: 0.9 }}
          >
            Admin
          </motion.button>
          </Link>
        </div>
        <div style={styles.line} />
        <Link to="/sign-up">
        <motion.button
          onClick={handleSignUpButtonClick}
          style={{ ...styles.button, background: '#ff9900' }}
          whileHover={{ scale: 1.1 }}
          whileTap={{ scale: 0.9 }}
        >
          Sign Up
        </motion.button>
        </Link>
      </motion.div>
    </div>
  );
};

const styles = {
  container: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '80vh',
  },
  card: {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: '10px',
    padding: '20px',
    boxShadow: '0 11px 11px rgba(0, 0, 0, 0.1)',
    background: '#d9ffdd',
    maxWidth: '400px',
    margin: '0 auto',
  },
  title: {
    fontSize: '20px',
    fontWeight: 'bold',
    margin: '0 0 20px 0',
    color: '#333',
  },
  buttonContainer: {
    display: 'flex',
    marginBottom: '10px',
  },
  button: {
    margin: '10px',
    padding: '10px 20px',
    fontSize: '16px',
    fontWeight: 'bold',
    border: 'none',
    borderRadius: '4px',
    background: '#009B37',
    color: '#fff',
    cursor: 'pointer',
  },
  line: {
    width: '100%',
    height: '1px',
    background: '#ccc',
    margin: '10px 0',
  },
};

export default ButtonComponent;
