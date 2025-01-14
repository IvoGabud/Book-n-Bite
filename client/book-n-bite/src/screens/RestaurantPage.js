import React, { useEffect, useState } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";
import pizzaImage from "assets/images/pizza.png";
import triangleIcon from "assets/images/triangle.png";
import locationIcon from "assets/images/location.png";
import { useNavigate } from "react-router-dom";

const RestaurantPage = () => {
  const navigate = useNavigate();
  const [restaurant, setRestaurant] = useState(null);
  const [menu, setMenu] = useState();

  // Function to fetch restaurant data
  const fetchRestaurantData = async () => {
    try {
      const response = await fetch("/restaurant-info");

      if (!response.ok) {
        throw new Error("Failed to fetch restaurant data");
      }

      const data = await response.json();

      setRestaurant(data);
    } catch (error) {
      console.error("Error fetching restaurant data:", error);
    }
  };

  const fetchMenuData = async () => {
    try {
      const response = await fetch("/dishes");

      if (!response.ok) {
        throw new Error("Failed to fetch menu data");
      }

      const data = await response.json();

      setMenu(data);
      console.log(data);
    } catch (error) {
      console.error("Error fetching menu data:", error);
    }
  };

  useEffect(() => {
    fetchRestaurantData();
    fetchMenuData();
  }, []);

  if (!restaurant) {
    return <div>Loading...</div>;
  }

  return (
    <div className="restaurant-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="restauran-page-foreground">
        <div className="restaurant-page-left-part">
          <div className="restaurant-page-title">
            <h2>{restaurant.name}</h2>
          </div>
          <div className="restaurant-info">
            <div className="infos">
              <p>Radno vrijeme: </p>
              <p>
                {restaurant.radnoVrijemeOd} - {restaurant.radnoVrijemeDo}
              </p>
            </div>
            <div className="infos">
              <p>Broj telefona: </p>
              <p>{restaurant.brojTelefona}</p>
            </div>
            <hr />
          </div>

          <div className="restaurant-location">
            <div>
              <p>Lokacija</p>
            </div>
            <div>
              <img
                src={locationIcon}
                alt="location"
                className="location-icon"
              />
            </div>
          </div>
          <hr />
          <div className="restaurant-links">
            <p>Poveznice</p>
            <ul>
              <li className="link">{restaurant.poveznicaSlike}</li>
            </ul>
          </div>
          {/* Restaurant Rating Section */}
          {/* <div className="restaurant-rating">
            <div className="ocjena">
              <p>Ocjena:</p>
            </div>
            <div className="star-rating">
              {[...Array(5)].map((_, index) => (
                <span key={index} className="star">
                  {index < restaurant.rating ? "★" : "☆"}
                </span>
              ))}
              <span className="rating-value">{restaurant.rating}</span>
            </div>
          </div> */}
        </div>

        <div className="restaurant-right-wrapper">
          <div className="restaurant-right-part">
            <div className="options">
              {["brza-hrana", "obicni", "desert", "pica"].map(
                (category) =>
                  menu?.[category]?.length > 0 && (
                    <div key={category} className={category}>
                      <div className="header">
                        <h3>{category.toUpperCase().replace("-", " ")}</h3>
                        <img
                          src={triangleIcon}
                          alt="Strelica"
                          className="triangle-icon"
                        />
                      </div>
                      <div className="broj-jela">
                        {menu[category].map((item, index) => (
                          <div key={index} className="jelo-item">
                            <h4>{item.naziv}</h4>
                          </div>
                        ))}
                      </div>
                      <hr />
                    </div>
                  )
              )}
            </div>

            <div className="product-container">
              <img src={pizzaImage} alt="Pizza" />
              <div className="product-info">
                <h2>Pizza</h2>
                <hr className="divider" />
                <p>Opis jela</p>
                <p>
                  <strong>Cijena:</strong> 15 HRK
                </p>
                <p>
                  <strong>Alergeni:</strong> Gluten
                </p>
              </div>
            </div>
            <div className="add-product-button">
              <RoundedButton
                text={"Dodaj proizvod"}
                onClick={() => navigate("/add-product")}
              />
            </div>
          </div>

          {/* Restaurant Rating Section */}
          {/* <div className="restaurant-rating">
    <div className="ocjena">
      <p>Ocjena:</p>
    </div>
    <div className="star-rating">
      {[...Array(5)].map((_, index) => (
        <span key={index} className="star">
          {index < restaurant.rating ? "★" : "☆"}
        </span>
      ))}
      <span className="rating-value">{restaurant.rating}</span>
    </div>
  </div> */}

          {/* Restaurant Review Section */}
          {/* <div className="review-section">
    <h3>RECENZIJE</h3>
    <div className="reviews">
      {reviews.map((review, index) => (
        <div className="review" key={index}>
          <p>
            <strong>{review.username}</strong>: {review.text}
          </p>
        </div>
      ))}
    </div>
    <div className="add-review">
      <div className="ocjena">
        <div>
          <label className="ocjena-padding">Ocjeni restoran:</label>
        </div>
        <div className="star-rating">
          <span className="star">☆</span>
          <span className="star">☆</span>
          <span className="star">☆</span>
          <span className="star">☆</span>
          <span className="star">☆</span>
        </div>
      </div>
      <textarea placeholder="Dodaj recenziju..."></textarea>
      <div className="submit-button-wrapper">
        <RoundedButton text={"Objavi"} />
      </div>
    </div>
  </div> */}

          <div className="spacer"></div>
        </div>
      </div>
    </div>
  );
};

export default RestaurantPage;
