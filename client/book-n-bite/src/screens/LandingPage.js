import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";
import { useState } from "react";
import heroImage from "assets/images/hero.png";
import { Link } from "react-router-dom";
import { APP_PATH } from "constants.js";
import RoundedButton from "components/RoundedButton";
import { useNavigate } from "react-router-dom";

// Pocetna stranica aplikacije

const LandingPage = () => {
  const navigate = useNavigate();
  return (
    <div className="landing-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${heroImage})` }}
      />
      <div className="overlay">
        <h1>BOOK N’ BITE</h1>
        <p>Decide together, dine better.</p>
        {/* Salje korisnika na stranicu za Google autentifikaciju */}
        <RoundedButton
          text="Nastavi koristeći Google"
          onClick={() =>
            (window.location.href = `${APP_PATH}/oauth2/authorization/google`)
          }
        />
      </div>
    </div>
  );
};

export default LandingPage;
