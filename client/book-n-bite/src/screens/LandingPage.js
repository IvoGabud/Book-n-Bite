import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";
import { useState } from "react";
import heroImage from "assets/images/hero.png";
import { Link } from "react-router-dom";

const LandingPage = () => {
  return (
    <div className="landing-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${heroImage})` }}
      />
      <div className="overlay">
        <h1>BOOK N’ BITE</h1>
        <p>Decide together, dine better.</p>
        <a href="http://localhost:8080/oauth2/authorization/google">Login with Google</a>
      </div>
    </div>
  );
};

export default LandingPage;
