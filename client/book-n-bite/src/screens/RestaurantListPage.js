import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";
import ConfirmationDialog from "components/ConfirmationDialog";
import TopBarBack from "components/TopBarBack";
import { useNavigate } from "react-router-dom"; // Import useNavigate

const RestaurantListPage = () => {
  const navigate = useNavigate(); // Initialize navigate hook
  const [restaurants, setRestaurants] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [showDialog, setShowDialog] = useState(false);
  const [restaurantToDelete, setRestaurantToDelete] = useState(null);
  const [restaurantToBlock, setRestaurantToBlock] = useState(null); // Track restaurant to block/unblock

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

  const handleBlock = async (korisnikId, isBlocked) => {
    const action = isBlocked ? "odblokirati" : "blokirati";
    if (window.confirm(`Jeste li sigurni da želite ${action} restoran?`)) {
      try {
        const response = await fetch(`/block/${korisnikId}`, {
          method: "POST",
        });
        if (!response.ok) {
          throw new Error(`Greška: ${response.statusText}`);
        }
        fetchRestaurants();
      } catch (err) {
        alert(`Došlo je do greške: ${err.message}`);
      }
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
                      restaurant.blokiran
                        ? "Odblokiraj račun"
                        : "Blokiraj račun"
                    }
                    onClick={() =>
                      handleBlock(restaurant.korisnikId, restaurant.blokiran)
                    }
                  />
                  <RoundedButton
                    text="Obriši račun"
                    onClick={() => handleDelete(restaurant.korisnikId)}
                  />
                  {/* Added button t  o navigate to restaurant profile */}
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
