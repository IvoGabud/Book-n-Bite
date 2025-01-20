import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/my-profile.png";
import RoundedButton from "components/RoundedButton";
import { useNavigate } from "react-router-dom";

const MyProfilePage = () => {
  const [userData, setUserData] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const fetchUserData = async () => {
    setLoading(true);
    try {
      const response = await fetch("get-reviewer");
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
    fetchUserData();
    // mock data za testiranje
    setUserData({
      korisnikId: "110210104235860904869",
      email: "filip.knapic321@gmail.com",
      korisnickoIme: "Filip Knapić",
      userType: "OCJENJIVAC",
      username: "fk54921",
      firstName: "filip",
      lastName: "Knapić",
      groupCode: "123456",
    });
  }, []);

  return (
    <div className="my-profile-page">
      <TopBarNoUser />
      <div className="bg-image" style={{ backgroundImage: `url(${bgImage})` }} />

      <div className="my-profile-foreground">
        <div className="my-profile-title">
          <h2>MOJ PROFIL</h2>
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
          <RoundedButton text="Natrag" onClick={() => navigate("/join-group")} />
          <RoundedButton text="Uredi Profil" onClick={() => navigate("/edit-profile")} />
          <RoundedButton text="Odjavi se" onClick={() => (window.location.href = "/logout")} />
        </div>
      </div>
    </div>
  );
};

export default MyProfilePage;
