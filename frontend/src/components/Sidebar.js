import React from 'react';
import { motion } from 'framer-motion';

const Sidebar = () => {
  return (
    <motion.div
      initial={{ x: '-100%' }}
      animate={{ x: 0 }}
      transition={{ duration: 0.5 }}
      style={styles.sidebar}
    >
      <ul style={styles.menu}>
        <motion.li
          whileHover={{ scale: 1.1 }}
          whileTap={{ scale: 0.9 }}
          style={styles.menuItem}
        >
          Home
        </motion.li>
        <motion.li
          whileHover={{ scale: 1.1 }}
          whileTap={{ scale: 0.9 }}
          style={styles.menuItem}
        >
          Dashboard
        </motion.li>
        <motion.li
          whileHover={{ scale: 1.1 }}
          whileTap={{ scale: 0.9 }}
          style={styles.menuItem}
        >
          Services
        </motion.li>
        <motion.li
          whileHover={{ scale: 1.1 }}
          whileTap={{ scale: 0.9 }}
          style={styles.menuItem}
        >
          Contact
        </motion.li>
      </ul>
    </motion.div>
  );
};

const styles = {
  sidebar: {
    width: '250px',
    height: '100vh',
    backgroundColor: '#f1f1f1',
    padding: '20px',
  },
  menu: {
    listStyle: 'none',
    padding: 0,
    margin: 0,
  },
  menuItem: {
    marginBottom: '10px',
    fontSize: '16px',
    fontWeight: 'bold',
    color: '#009B37',
    cursor: 'pointer',
  },
};

export default Sidebar;
