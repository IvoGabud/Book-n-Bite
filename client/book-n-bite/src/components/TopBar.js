import UserProfileButton from "./UserProfileButton";
import { Link } from "react-router-dom";

// Gornja traka aplikacije

const TopBar = ({ username }) => {
  return (
    <div className="top-bar">
      <Link to="/" className="top-bar-link">
        <h1 className="top-bar-text">BOOK 'N BITE</h1>
      </Link>
      <UserProfileButton username={username} />
    </div>
  );
};

export default TopBar;
