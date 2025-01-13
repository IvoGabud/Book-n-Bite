import React from "react";
import { useNavigate } from "react-router-dom";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import userIcon from "assets/images/usrIcon.png";
import mealIcon from "assets/images/mealIcon.png";
import checkIcon from "assets/images/krug (2).png";
import RoundedButton from "components/RoundedButton";

const AdminLandingPage = () => {
  const navigate = useNavigate();

  const handleNavigation = (path) => {
    navigate(path);
  };

  return (
    <div className="welcome-back-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="welcome-back-container">
        <h1 className="welcome-text">DOBRODOŠLI NATRAG!</h1>

        <div className="welcome-back-categories">
          <div
            className="category"
            onClick={() => handleNavigation("/reviewers-list")}
            style={{ cursor: "pointer" }}
          >
            <img src={userIcon} alt="User Icon" className="icon" />
            <p className="category-text">Pregled liste ocjenjivača</p>
          </div>

          <div
            className="category"
            onClick={() => handleNavigation("/restaurant-list")}
            style={{ cursor: "pointer" }}
          >
            <img src={mealIcon} alt="Meal Icon" className="icon" />
            <p className="category-text">Pregled liste restorana</p>
          </div>

          <div
            className="category"
            onClick={() => handleNavigation("/verification-list")}
            style={{ cursor: "pointer" }}
          >
            <img src={checkIcon} alt="Check Icon" className="icon" />
            <p className="category-text">Pregled liste za verifikaciju</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminLandingPage;
