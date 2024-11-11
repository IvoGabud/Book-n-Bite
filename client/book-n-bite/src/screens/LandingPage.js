import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";
import { useState } from "react";
import heroImage from "assets/images/hero.png";
import TopBar from "components/TopBar";

const LandingPage = () => {
  const [username, setUsername] = useState(null);
  return (
    <div className="landing-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${heroImage})` }}
      />
      <div className="overlay">
        <h1>BOOK N’ BITE</h1>
        <p>Decide together, dine together.</p>
      </div>
      <div className="login-button">
        <GoogleLogin
          onSuccess={(credentialResponse) => {
            console.log(credentialResponse);
            const decoded = jwtDecode(credentialResponse?.credential);
            console.log(decoded);
            setUsername(decoded.name);
          }}
          onError={() => {
            console.log("Login Failed");
          }}
        />
      </div>
    </div>
  );
};

export default LandingPage;
