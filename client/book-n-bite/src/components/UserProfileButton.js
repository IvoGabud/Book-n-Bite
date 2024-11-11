import userProfileImg from "../assets/icons/profile_icon.svg";
const TopBar = () => {
  return (
    <div className="user-profile-button">
      <img
        className="user-profile-icon"
        src={userProfileImg}
        alt="User profile icon"
      />
      <span className="username-text">Username</span>
    </div>
  );
};

export default TopBar;
