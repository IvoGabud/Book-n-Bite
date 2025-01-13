import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";

const RestaurantListPage = () => {
  const [restaurants, setRestaurants] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchRestaurants = async () => {
    setLoading(true);
    try {
      const response = await fetch("get-restaurants");
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
    fetchRestaurants();
  }, []);

  const handleDelete = async (korisnikId) => {
    const confirmDelete = window.confirm(
      "Are you sure you want to delete this restaurant?"
    );
    if (!confirmDelete) return;

    try {
      const response = await fetch(`delete-account/${korisnikId}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.json();
      alert("Račun obrisan!");
      fetchRestaurants();
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
        <h1 className="page-title">LISTA RESTORANA</h1>
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
                    text={
                      restaurant.blocked ? "Odblokiraj račun" : "Blokiraj račun"
                    }
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

export default RestaurantListPage;
