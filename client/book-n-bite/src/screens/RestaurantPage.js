import React, { useEffect, useState } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";
import pizzaImage from "assets/images/pizza.png";
import triangleIcon from "assets/images/triangle.png";
import { useNavigate } from "react-router-dom";
import {
  APIProvider,
  Map,
  AdvancedMarker,
  Pin,
} from "@vis.gl/react-google-maps";

const RestaurantPage = () => {
  const navigate = useNavigate();
  const [restaurant, setRestaurant] = useState(null);
  const [menu, setMenu] = useState();
  const [address, setAddress] = useState("");
  const [open, setOpen] = useState(false);

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

  // Function to get address using Google Maps Geocoder
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

  // Callback for when the map loads
  const handleMapLoad = () => {
    console.log("Google Maps API učitan.");
    getAddress(restaurant.latLok, restaurant.lngLok);
  };

  useEffect(() => {
    fetchRestaurantData();
    fetchMenuData();

    // Default restaurant data for testing
    // setRestaurant({
    //   nazivRestoran: "naziv",
    //   lokacija: "adresa",
    //   radnoVrijemeOd: "04:26",
    //   radnoVrijemeDo: "16:27",
    //   cjenovniRang: null,
    //   brojTelefona: "095",
    //   poveznicaSlike: "https",
    //   username: "a",
    //   firstName: "a",
    //   lastName: "a",
    //   filled: true,
    //   verified: true,
    // });
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
                  >
                    <AdvancedMarker
                      position={{
                        lat: restaurant.latLok,
                        lng: restaurant.lngLok,
                      }}
                      onClick={() => setOpen(true)}
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
            <div className="add-product-button">
              <RoundedButton
                text={"Dodaj proizvod"}
                onClick={() => navigate("/add-product")}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RestaurantPage;
