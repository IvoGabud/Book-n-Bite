import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import TopBar from "components/TopBar";
import bgImage from "assets/images/waiting_page_icon.png";

const WaitingPage = () => {
  const [isWaiting, setIsWaiting] = useState(true);
  const navigate = useNavigate();
  const location = useLocation();
  const groupCode = location.state?.groupCode;

  const checkWaitingStatus = async () => {
    try {
      const response = await fetch(`/waiting/${groupCode}`);

      if (!response.ok) {
        throw new Error("Failed to fetch waiting status");
      }

      const data = await response.json();

      if (data.status === "ok") {
        setIsWaiting(false);
      }
    } catch (error) {
      console.error("Error checking waiting status:", error);
    }
  };

  useEffect(() => {
    if (groupCode) {
      const intervalId = setInterval(() => {
        checkWaitingStatus();
      }, 5000);

      return () => clearInterval(intervalId);
    }
  }, [groupCode]);

  useEffect(() => {
    if (!isWaiting) {
      navigate("/recommended");
    }
  }, [isWaiting, navigate]);

  return (
    <div className="waiting-requst-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="waiting-page-foreground">
        <div className="waiting-page-text">
          <h1>JOŠ SAMO MALO...</h1>
          <h3>Vaši prijatelji još uvijek ocjenjuju jela.</h3>
        </div>
      </div>
    </div>
  );
};

export default WaitingPage;
