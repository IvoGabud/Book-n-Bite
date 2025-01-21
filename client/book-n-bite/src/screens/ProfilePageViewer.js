import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/my-profile.png";
import RoundedButton from "components/RoundedButton";
import { useNavigate, useLocation } from "react-router-dom"; // Import useLocation

const ProfilePageViewer = () => {
  const [userData, setUserData] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const location = useLocation(); // Get location to access the query params

  const fetchUserData = async (korisnikId) => {
    setLoading(true);
    try {
      const response = await fetch(`/get-user/${korisnikId}`); // Fetch user data with the korisnikId
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.json();
      setUserData(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    // Extract korisnikId from URL search params
    const korisnikId = new URLSearchParams(location.search).get("id");
    if (korisnikId) {
      fetchUserData(korisnikId);
    } else {
      setError("Nema ID-a u URL-u");
    }
  }, [location.search]); // Re-run effect when the location changes

  return (
    <div className="my-profile-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="my-profile-foreground">
        <div className="my-profile-title">
          <h2>INFORMACIJE O KORISNIKU</h2>
        </div>

        {loading && <p>Učitavanje podataka...</p>}
        {error && <p className="error">{error}</p>}
        {!loading && !error && (
          <div className="my-profile-data">
            <div className="my-profile-part">
              <label htmlFor="username">Korisničko ime:</label>
              <div className="element">
                <span className="username">{userData.username}</span>
              </div>
            </div>

            <div className="my-profile-part">
              <label htmlFor="ime">Ime:</label>
              <div className="element">
                <span className="Ime">{userData.firstName}</span>
              </div>
            </div>

            <div className="my-profile-part">
              <label htmlFor="prezime">Prezime:</label>
              <div className="element">
                <span className="Ime">{userData.lastName}</span>
              </div>
            </div>
          </div>
        )}

        <div className="my-profile-buttons">
          <RoundedButton text="Natrag" onClick={() => navigate(-1)} />
        </div>
      </div>
    </div>
  );
};

export default ProfilePageViewer;
