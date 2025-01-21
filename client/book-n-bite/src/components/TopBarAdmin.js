import { Link } from "react-router-dom";
import RoundedButton from "components/RoundedButton"; // Assuming you have this component

// Gornja traka aplikacije bez ikone profila

const TopBarAdmin = () => {
  const handleLogout = () => {
    window.location.href = "/logout";
  };

  return (
    <div className="top-bar">
      <Link to="/" className="top-bar-link">
        <h1 className="top-bar-text">BOOK 'N BITE</h1>
      </Link>

      <div className="logout-button">
        <RoundedButton text="Odjavite se" onClick={handleLogout} />
      </div>
    </div>
  );
};

export default TopBarAdmin;
