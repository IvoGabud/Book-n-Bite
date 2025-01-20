import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";
import ConfirmationDialog from "components/ConfirmationDialog";
import TopBarBack from "components/TopBarBack";

const RestaurantListPage = () => {
  const [restaurants, setRestaurants] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [showDialog, setShowDialog] = useState(false);
  const [restaurantToDelete, setRestaurantToDelete] = useState(null);

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
    setRestaurantToDelete(korisnikId);
    setShowDialog(true);
  };

  const confirmDelete = async () => {
    try {
      const response = await fetch(`delete-account/${restaurantToDelete}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.text();
      alert(data);
      setShowDialog(false);
      fetchRestaurants();
    } catch (err) {
      alert(`Došlo je do greške: ${err.message}`);
      setShowDialog(false);
    }
  };

  const cancelDelete = () => {
    setShowDialog(false);
  };

  return (
    <div className="reviewer-list-page">
      <TopBarBack />
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

      {/* Confirmation Dialog */}
      <ConfirmationDialog
        isOpen={showDialog}
        message="Jeste li sigurni da želite obrisati restoran?"
        onConfirm={confirmDelete}
        onCancel={cancelDelete}
      />
    </div>
  );
};

export default RestaurantListPage;
