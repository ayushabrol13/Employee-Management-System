import React from 'react'

const HeaderComponent = () => {
  return (
    <div>
        <header>
            <nav className="navbar navbar-light bg-light ">
                <div>
                    <a href='https://ninjacart.in/'>
                        <img className='ninjacart-logo mx-3' src="https://ninjacart.in/images/logo.png"></img>
                    </a>
                </div>
                <h1 className="mx-3" style={styles.heading} >StormBreaker</h1>
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
      margin: '12px',
        paddingLeft:'5%'
    }
  };
export default HeaderComponent