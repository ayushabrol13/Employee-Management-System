import React from 'react'

const HeaderComponent = () => {
  return (
    <div>
        <header>
            <nav className="navbar navbar-light bg-light">
                <div>
                    <a href='https://ninjacart.in/'>
                        <img className='ninjacart-logo' src="https://ninjacart.in/images/logo.png"></img>
                    </a>
                </div>
                <h1 style={styles.heading} >Storm-Breaker</h1>
            </nav>
        </header>
    </div>
  )
}

const styles = {
    heading: {
        color: "#009B37",
        fontfamily: 'Poppins',
      fontSize: '24px',
      fontWeight: 'bold',
      margin: '12px'
    }
  };
export default HeaderComponent