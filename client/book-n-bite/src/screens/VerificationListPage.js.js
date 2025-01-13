import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";

const VerificationListPage = () => {
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
      const data = await response.json();
      alert("Verifikacija uspješna!");
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
      const data = await response.json();
      alert("Račun obrisan!");
      fetchRestaurantsForVerification();
    } catch (err) {
      alert(`Došlo je do greške: ${err.message}`);
    }
  };

  return (
    <div className="reviewer-list-page">
      <TopBarNoUser />
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
                </div>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};

export default VerificationListPage;
