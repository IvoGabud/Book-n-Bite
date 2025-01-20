import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/restaurant_info.png";
import pizzaImage from "assets/images/pizza.png";
import triangleIcon from "assets/images/triangle.png";
import {
  APIProvider,
  Map,
  AdvancedMarker,
  Pin,
} from "@vis.gl/react-google-maps";
import TopBar from "components/UserProfileButton";
import TopBarAdmin from "components/TopBarAdmin";

const RestaurantPageViewer = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [restaurant, setRestaurant] = useState(null);
  const [menu, setMenu] = useState();
  const [address, setAddress] = useState("");

  const restaurantId = new URLSearchParams(location.search).get("id");

  const fetchRestaurantData = async () => {
    try {
      const response = await fetch(`/get-restaurant/${restaurantId}`);
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
      const response = await fetch(`/dishes/${restaurantId}`);
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

  const getAddress = (lat, lng) => {
    if (!window.google || !window.google.maps) {
      console.error("Google Maps API nije učitan.");
      setAddress("Google Maps API nije dostupan");
      return;
    }

    const geocoder = new window.google.maps.Geocoder();
    const latLng = new window.google.maps.LatLng(lat, lng);

    geocoder.geocode({ location: latLng }, (results, status) => {
      if (status === "OK" && results[0]) {
        setAddress(results[0].formatted_address);
      } else {
        console.error("Geocoding nije uspio:", status);
        setAddress("Address not found");
      }
    });
  };

  const handleMapLoad = () => {
    console.log("Google Maps API učitan.");
    if (restaurant) {
      getAddress(restaurant.latLok, restaurant.lngLok);
    }
  };

  useEffect(() => {
    if (restaurantId) {
      fetchRestaurantData();
    }
    fetchMenuData();
  }, [restaurantId]);

  if (!restaurant) {
    return <div>Loading...</div>;
  }

  return (
    <div className="restaurant-page">
      <TopBarAdmin />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="restauran-page-foreground">
        <div className="restaurant-page-left-part">
          <div className="restaurant-page-title">
            <h2>{restaurant.nazivRestoran}</h2>
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
              <p>Lokacija: {address}</p>
            </div>
            <div>
              <APIProvider apiKey="TVOJ_API_KLJUČ">
                <div style={{ height: "35vh", width: "100%" }}>
                  <Map
                    center={{ lat: restaurant.latLok, lng: restaurant.lngLok }}
                    mapId="7920952787de8caf"
                    onLoad={handleMapLoad}
                    defaultZoom={7}
                  >
                    <AdvancedMarker
                      position={{
                        lat: restaurant.latLok,
                        lng: restaurant.lngLok,
                      }}
                    >
                      <Pin
                        background={"grey"}
                        borderColor={"green"}
                        glyphColor={"purple"}
                      />
                    </AdvancedMarker>
                  </Map>
                </div>
              </APIProvider>
            </div>
          </div>
          <hr />
          <div className="restaurant-links">
            <p>Poveznice</p>
            <ul>
              <li className="link">{restaurant.poveznicaSlike}</li>
            </ul>
          </div>
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
          </div>
        </div>
      </div>
    </div>
  );
};

export default RestaurantPageViewer;
