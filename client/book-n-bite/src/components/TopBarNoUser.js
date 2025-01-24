import { Link } from "react-router-dom";

// Gornja traka aplikacije bez ikone profila

const TopBarNoUser = () => {
  return (
    <div className="top-bar">
      <Link to="/" className="top-bar-link">
        <h1 className="top-bar-text">BOOK 'N BITE</h1>
      </Link>
    </div>
  );
};

export default TopBarNoUser;
