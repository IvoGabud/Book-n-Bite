import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";
import { useState } from "react";
import heroImage from "assets/images/hero.png";
import TopBar from "components/TopBar";
import { Link } from "react-router-dom";
import axios from "axios";

const LandingPage = () => {
  const [username, setUsername] = useState(null);
  return (
    <div className="landing-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${heroImage})` }}
      />
      <div className="overlay">
        <h1>BOOK N’ BITE</h1>
        <p>Decide together, dine together.</p>
      </div>
      <Link
        to="/join-group"
        style={{
          textDecoration: "none",
          color: "inherit",
          display: "inline-block",
        }}
      >
        <h1 className="top-bar-text">BOOK N’ BITE</h1>
      </Link>
    </div>
  );
};

axios.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("authToken");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default LandingPage;
