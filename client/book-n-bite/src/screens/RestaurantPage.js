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
import TopBarAdmin from "components/TopBarAdmin";

const RestaurantPage = () => {
  const navigate = useNavigate();
  const [restaurant, setRestaurant] = useState(null);
  const [menu, setMenu] = useState();
  const [expandedCategory, setExpandedCategory] = useState(null);
  const [selectedProduct, setSelectedProduct] = useState(null);
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
      const firstCategory = Object.keys(data)[0];
      if (firstCategory && data[firstCategory]?.length > 0) {
        setExpandedCategory(firstCategory); // Expand the first category by default
        setSelectedProduct(data[firstCategory][0]);
      }
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
    getAddress(restaurant.latLok, restaurant.lngLok);
  };

  useEffect(() => {
    fetchRestaurantData();
    fetchMenuData();
  }, []);

  const toggleCategory = (category) => {
    setExpandedCategory((prev) => (prev === category ? null : category));
  };

  const handleProductClick = (product) => {
    setSelectedProduct(product);
  };

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
                      onClick={() => setOpen(true)}
                    >
                      <Pin />
                    </AdvancedMarker>
                  </Map>
                </div>
              </APIProvider>
            </div>
          </div>
          <hr />
          <div className="restaurant-links">
            <p>Poveznica</p>
            <ul>
              <li className="link">{restaurant.poveznicaSlike}</li>
            </ul>
          </div>
        </div>

        <div className="restaurant-right-wrapper">
          <div className="restaurant-right-part">
            <div className="options">
              {Object.keys(menu || {}).map((category) => (
                <div key={category} className={category}>
                  <div
                    className="header"
                    onClick={() => toggleCategory(category)}
                    style={{ cursor: "pointer" }}
                  >
                    <h3>{category.toUpperCase().replace("-", " ")}</h3>
                    <img
                      src={triangleIcon}
                      alt="Strelica"
                      className={`triangle-icon ${
                        expandedCategory === category ? "expanded" : ""
                      }`}
                    />
                  </div>
                  {expandedCategory === category && (
                    <div className="broj-jela">
                      {menu[category]?.map((item, index) => (
                        <div
                          key={index}
                          className="jelo-item"
                          onClick={() => handleProductClick(item)}
                          style={{
                            cursor: "pointer",
                            color:
                              selectedProduct?.nazivJela === item.nazivJela
                                ? "#3d130c"
                                : "inherit",
                          }}
                        >
                          <h4>{item.nazivJela}</h4>
                        </div>
                      ))}
                    </div>
                  )}
                  <hr />
                </div>
              ))}
            </div>
            <div className="product-container">
              {selectedProduct ? (
                <>
                  <img
                    src={selectedProduct.imageSrc}
                    alt={selectedProduct.nazivJela}
                  />
                  <div className="product-info">
                    <h2>{selectedProduct.nazivJela}</h2>
                    <hr className="divider" />
                    <p>{selectedProduct.opisJela}</p>
                    <p>
                      <strong>Cijena:</strong> {selectedProduct.cijena} EUR
                    </p>
                    <p>
                      <strong>Alergeni:</strong> {selectedProduct.alergeni}
                    </p>
                  </div>
                </>
              ) : (
                <p>Odaberite proizvod za prikaz informacija.</p>
              )}
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
