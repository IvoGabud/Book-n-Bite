import RoundedButton from "./RoundedButton";
import UserProfileButton from "./UserProfileButton";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

// Gornja traka aplikacije

const TopBarHome = ({ username }) => {
  const navigate = useNavigate();

  const handleLeaveGroup = async () => {
    try {
      const response = await fetch("/leave", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        navigate("/");
      } else {
        console.error("Pogreška pri napuštanju grupe:", response.statusText);
      }
    } catch (error) {
      console.error("Došlo je do pogreške:", error);
    }
  };

  return (
    <div className="top-bar">
      <Link to="/" className="top-bar-link">
        <h1 className="top-bar-text">BOOK 'N BITE</h1>
      </Link>
      <RoundedButton text="Napusti grupu" onClick={handleLeaveGroup} />
    </div>
  );
};

export default TopBarHome;
