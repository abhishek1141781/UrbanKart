import React from "react";

const Footer = () => {
  return (
    <footer className="mb-0 text-center bg-dark text-white">
      <div className="container"> {/* Wrap the content in a container */}
        <div className="row">
          <div className="col-md-8 offset-md-2"> {/* Adjust column width */}
            <p>&copy; {new Date().getFullYear()} Urbankart. All rights reserved.</p>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
