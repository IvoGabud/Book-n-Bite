import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";
import pizzaImage from "assets/images/pizza.png";
import triangleIcon from "assets/images/triangle.png";
import locationIcon from "assets/images/location.png";
import {AdvancedMarker, APIProvider, Map, Pin} from "@vis.gl/react-google-maps";
import React, {useState} from "react";

const RestaurantPageOverview = () => {
  const [address, setAddress] = useState("");
  const [open, setOpen] = useState(false);
  const position = { lat: 45.81, lng: 15.96 };
  const getAddress = (lat, lng) => {
    const geocoder = new window.google.maps.Geocoder();
    const latLng = new window.google.maps.LatLng(lat, lng);

    geocoder.geocode({ location: latLng }, (results, status) => {
      if (status === "OK" && results[0]) {
        setAddress(results[0].formatted_address);
      } else {
        setAddress("Address not found");
      }
    });
  };

  getAddress(position.lat, position.lng);

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
            <h2>NAZIV RESTORANA</h2>
          </div>
          <div className="restaurant-info">
            <div className="infos">
              <p>Radno vrijeme: </p>
              <p>08:00 - 22:00</p>
            </div>
            <div className="infos">
              <p>Broj telefona: </p>
              <p>...</p>
            </div>
            <hr />
          </div>

          <div className="restaurant-location">
            <div>
              <p>Lokacija: {address}</p>
            </div>
            <div>
              <APIProvider apiKey="AIzaSyA0TIFpItE6V-VzGyhfrNY9TwJjH5ZWP-I">
                <div style={{height: "35vh", width: "100%"}}>
                  <Map center={position} mapId="7920952787de8caf">
                    <AdvancedMarker position={position} onClick={() => setOpen(true)}>
                      <Pin background={"grey"} borderColor={"green"} glyphColor={"purple"}/>
                    </AdvancedMarker>

                    {open}
                  </Map>
                </div>
              </APIProvider>
            </div>
          </div>
          <hr/>
          <div className="restaurant-links">
            <p>Poveznice</p>
            <ul>
              <li>link1...</li>
              <li>link2...</li>
            </ul>
          </div>

          <div className="restaurant-rating">
            <div className="ocjena">
              <p>Ocjena:</p>
            </div>
            <div className="star-rating">
              <span className="star">★</span>
              <span className="star">★</span>
              <span className="star">★</span>
              <span className="star">★</span>
              <span className="star">☆</span>
              <span className="rating-value">4.5</span>

            </div>

          </div>
          <div className="restaurant-buttons">
            <RoundedButton text={"Uredi"} />
            <RoundedButton text={"Obriši profil"} />
          </div>
        </div>

        <div className="restaurant-right-wrapper">
          <div className="restaurant-right-part">
            <div className="options">
              <div className="brza-hrana">
                <div className="header">
                  <h3>BRZA HRANA</h3>
                  <img
                    src={triangleIcon}
                    alt="Strelica"
                    className="triangle-icon"
                  />
                </div>

                <div className="broj-jela">
                  <p>prvo jelo</p>
                  <p className="drugo-jelo">drugo jelo</p>
                  <p>treće jelo</p>
                </div>
                <hr />
              </div>
              <div className="Deserti">
                <div className="header">
                  <h3>DESERTI</h3>
                  <img
                    src={triangleIcon}
                    alt="Strelica"
                    className="triangle-icon"
                  />
                </div>
                <hr />
              </div>
              <div className="piće">
                <div className="header">
                  <h3>PIĆE</h3>
                  <img
                    src={triangleIcon}
                    alt="Strelica"
                    className="triangle-icon"
                  />
                </div>
              </div>
            </div>

            <div className="product-container">
              <img src={pizzaImage} alt="Pizza" />
              <div className="product-info">
                <h2>drugo jelo</h2>
                <hr className="divider" />
                <p>Opis jela</p>
                <p>
                  <strong>Cijena:</strong>
                </p>
                <p>
                  <strong>Alergeni:</strong>
                </p>
              </div>
            </div>
            <div className="add-product-button">
              <RoundedButton text={"Dodaj proizvod"} />
            </div>
          </div>

          <div className="review-section">
            <h3>RECENZIJE</h3>

            <div className="reviews">
              <div className="review">
                <p><strong>Username1</strong>: Sample text prve recenzije....</p>
              </div>
              <div className="review">
                <p><strong>Username2</strong>: Sample text druge recenzije....</p>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  );
};

export default RestaurantPageOverview;
