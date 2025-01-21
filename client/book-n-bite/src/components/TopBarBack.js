import RoundedButton from "./RoundedButton";
import { Link, useNavigate } from "react-router-dom";

// Gornja traka aplikacije

const TopBar = ({ username }) => {
  const navigate = useNavigate();

  return (
    <div className="top-bar">
      <Link to="/" className="top-bar-link">
        <h1 className="top-bar-text">BOOK 'N BITE</h1>
      </Link>
      <RoundedButton onClick={() => navigate(-1)} text="Natrag" />
    </div>
  );
};

export default TopBar;
