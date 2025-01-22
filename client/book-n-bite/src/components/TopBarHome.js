import RoundedButton from "./RoundedButton";
import UserProfileButton from "./UserProfileButton";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

// Gornja traka aplikacije

const TopBar = ({ username }) => {
  const navigate = useNavigate();
  return (
    <div className="top-bar">
      <Link to="/" className="top-bar-link">
        <h1 className="top-bar-text">BOOK 'N BITE</h1>
      </Link>
      <RoundedButton text="Početna stranica" onClick={() => navigate("/")} />
    </div>
  );
};

export default TopBar;
