import React from "react";

const FooterComponent = () => {
  return (
    <footer className="footer bg-white text-center text-white sticky-bottom"  >
      {/* Grid container */}
      <div className="container p-4 pb-0">
        {/* Section: Social media */}
        <section className="mb-4">
          {/* Facebook */}
          <a
            className="btn text-white btn-floating m-1"
            style={{ backgroundColor: "#3b5998" }}
            href="https://www.facebook.com/ninjacart/"
            role="button"
          >
            <i className="fa fa-facebook-f" />
          </a>
          {/* Twitter */}
          <a
            className="btn text-white btn-floating m-1"
            style={{ backgroundColor: "#55acee" }}
            href="https://twitter.com/ninjacart"
            role="button"
          >
            <i className="fa fa-twitter" />
          </a>

          {/* Instagram */}
          <a
            className="btn text-white btn-floating m-1"
            style={{ backgroundColor: "#ac2bac" }}
            href="https://www.instagram.com/ninjacart_official/"
            role="button"
          >
            <i className="fa fa-instagram" />
          </a>
          {/* Linkedin */}
          <a
            className="btn text-white btn-floating m-1"
            style={{ backgroundColor: "#0082ca" }}
            href="https://www.linkedin.com/company/ninja-cart/"
            role="button"
          >
            <i class="fa fa-linkedin"></i>
          </a>
        </section>
        {/* Section: Social media */}
      </div>
      {/* Grid container */}
      {/* Copyright */}
      <div
        className="text-center p-3"
        style={{ backgroundColor: "#009B37" }}
      >
        <a className="text-white" href="https://ninjacart.in/">
          ninjacart.com
        </a>
      </div>
      {/* Copyright */}
    </footer>
  );
};
export default FooterComponent;
