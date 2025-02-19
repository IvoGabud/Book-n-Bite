import TopBar from "components/TopBar";
import bgImage from "assets/images/RecommendedIcon.png";
import RoundedButton from "components/RoundedButton";
import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import TopBarHome from "components/TopBarHome";

const RecommendedPage = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const groupCode = location.state?.groupCode;
  const [restaurants, setRestaurants] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [userData, setUserData] = useState(null);

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

  const fetchRecommendedRestaurants = async () => {
    try {
      const response = await fetch(`/get-recommended/${groupCode}`);
      if (!response.ok) {
        throw new Error("Failed to fetch recommended restaurants");
      }
      const data = await response.json();
      setRestaurants(data);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchUserData();
    fetchRecommendedRestaurants();
    if (groupCode) {
      fetchRecommendedRestaurants();
    }
  }, [groupCode]);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  const handleNavigateToRestaurant = (restaurantId) => {
    navigate(`/restaurant?id=${restaurantId}`);
  };

  const firstRestaurant = restaurants[0];
  const otherRestaurants = restaurants.slice(1);

  return (
    <div className="recommended-page">
      <TopBarHome />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="recommended-page-container">
        <div className="recommended-page-part1">
          <div>
            <p>Na temelju vaše grupe, preporučujemo vam:</p>
          </div>

          {firstRestaurant && (
            <div className="prviRest">
              <div className="restaurant-header">
                <h2>
                  <span className="restaurant-rank">1.</span>{" "}
                  {firstRestaurant.nazivRestoran}
                  <span className="trophy-icon">🏆</span>
                </h2>
              </div>
              <div>
                <RoundedButton
                  text={"Posjeti stranicu restorana"}
                  onClick={() =>
                    handleNavigateToRestaurant(firstRestaurant.korisnikId)
                  }
                />
              </div>
              {firstRestaurant.rating !== undefined &&
                firstRestaurant.rating !== null && (
                  <div className="rating">
                    {Array.from({ length: 5 }, (_, i) => (
                      <span
                        key={i}
                        className={`star ${
                          i < firstRestaurant.rating ? "filled" : ""
                        }`}
                      >
                        &#9733;
                      </span>
                    ))}
                    <span className="rating-text">
                      {firstRestaurant.rating}
                    </span>
                  </div>
                )}
            </div>
          )}
        </div>

        <div className="recommended-page-part2">
          <div>
            <p>Također preporučujemo:</p>
          </div>
          <div className="grid-container">
            {otherRestaurants.map((restaurant, index) => (
              <div className="grid-item" key={index}>
                <div className="restaurant-name">
                  <h4>
                    <span className="restaurant-rank">{index + 2}.</span>{" "}
                    {restaurant.nazivRestoran}
                  </h4>
                </div>
                <div className="restaurant-rating">
                  {restaurant.rating !== undefined &&
                    restaurant.rating !== null && (
                      <>
                        {Array.from({ length: 5 }, (_, i) => (
                          <span
                            key={i}
                            className={`star ${
                              i < restaurant.rating ? "filled" : ""
                            }`}
                          >
                            &#9733;
                          </span>
                        ))}
                        <span className="rating-text">{restaurant.rating}</span>
                      </>
                    )}
                </div>
                <div className="restaurant-button">
                  <RoundedButton
                    text={"Posjeti stranicu"}
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
    </div>
  );
};

export default RecommendedPage;
