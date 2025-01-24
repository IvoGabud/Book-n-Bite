import React, { useState, useEffect } from "react";
import TopBarAdmin from "components/TopBarAdmin";
import bgImage from "assets/images/restaurant_info.png";
import verificationImage from "assets/images/krug.png";

const VerificationRequestPage = () => {
  const [isVerified, setIsVerified] = useState(false);

  useEffect(() => {
    document.title = "Book n' Bite";

    const checkVerificationStatus = async () => {
      try {
        const response = await fetch("/is-logged-in");
        if (response.ok) {
          const data = await response.json();
          if (data?.isVerified) {
            setIsVerified(true);
            window.location.reload();
          }
        }
      } catch (error) {
        console.error("Greška prilikom provjere verifikacije:", error);
      }
    };

    const intervalId = setInterval(checkVerificationStatus, 1000);

    return () => clearInterval(intervalId);
  }, []);

  return (
    <div className="verification-request-page">
      <TopBarAdmin />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="verification-request-foreground">
        <img
          className="verification-picture"
          src={verificationImage}
          alt="Verifikacija"
        />
        <h2>
          Vaš zahtjev za verifikaciju je poslan. <br />
          Nastojat ćemo ga potvrditi u što kraćem roku.
        </h2>
      </div>
    </div>
  );
};

export default VerificationRequestPage;
