import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";
import TopBarBack from "components/TopBarBack";
import { useNavigate } from "react-router-dom"; // Import useNavigate

const VerificationListPage = () => {
  const navigate = useNavigate(); // Initialize navigate hook
  const [restaurants, setRestaurants] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchRestaurantsForVerification = async () => {
    setLoading(true);
    try {
      const response = await fetch("get-verifications");
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.json();
      setRestaurants(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchRestaurantsForVerification();
  }, []);

  const handleVerify = async (korisnikId) => {
    try {
      const response = await fetch(`verify/${korisnikId}`, {
        method: "POST",
      });
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.text();
      fetchRestaurantsForVerification();
    } catch (err) {
      alert(`Došlo je do greške: ${err.message}`);
    }
  };

  const handleDelete = async (korisnikId) => {
    try {
      const response = await fetch(`delete-account/${korisnikId}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.text();
      alert(data);
      fetchRestaurantsForVerification();
    } catch (err) {
      alert(`Došlo je do greške: ${err.message}`);
    }
  };

  // Navigate to the restaurant profile page
  const handleNavigateToRestaurant = (restaurantId) => {
    navigate(`/restaurant?id=${restaurantId}`);
  };

  return (
    <div className="reviewer-list-page">
      <TopBarBack />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="content-container">
        <h1 className="page-title">LISTA ZA VERIFIKACIJU</h1>
        {loading && <p>Učitavanje...</p>}
        {error && <p className="error">{error}</p>}
        <div className="reviewer-list">
          {!loading &&
            !error &&
            restaurants.map((restaurant, index) => (
              <div className="reviewer-row" key={index}>
                <div className="reviewer-name">{restaurant.nazivRestoran}</div>
                <div className="actions">
                  <RoundedButton
                    text="Potvrdi"
                    onClick={() => handleVerify(restaurant.korisnikId)}
                  />
                  <RoundedButton
                    text="Obriši račun"
                    onClick={() => handleDelete(restaurant.korisnikId)}
                  />
                  {/* Added button to navigate to restaurant profile */}
                  <RoundedButton
                    text="Pogledaj profil"
                    onClick={() =>
                      handleNavigateToRestaurant(restaurant.korisnikId)
                    }
                  />
                </div>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};

export default VerificationListPage;
