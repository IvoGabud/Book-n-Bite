import UserProfileButton from "./UserProfileButton";
import { Link } from "react-router-dom";

const TopBar = () => {
  return (
    <div className="top-bar">
      <Link
        to="/"
        style={{
          textDecoration: "none",
          color: "inherit",
          display: "inline-block",
        }}
      >
        <h1 className="top-bar-text">BOOK N’ BITE</h1>
      </Link>
      <UserProfileButton />
    </div>
  );
};

export default TopBar;
