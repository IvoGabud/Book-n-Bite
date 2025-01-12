import userProfileImg from "../assets/icons/profile_icon.svg";
import { useNavigate } from "react-router-dom";
// Komponenta koja prikazuje korisničko ime i ikonu korisničkog profila

const TopBar = () => {
  const navigate = useNavigate();
  return (
    <button
      className="user-profile-button rounded-button"
      onClick={() => navigate("/profile-page")}
    >
      <img
        className="user-profile-icon"
        src={userProfileImg}
        alt="User profile icon"
      />
      <span className="username-text">Username</span>
    </button>
  );
};

export default TopBar;
