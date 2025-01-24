import { useState } from "react";
import { useNavigate } from "react-router-dom";
import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";

import React, { useMemo } from "react";

import { GoogleMap, useLoadScript, Marker } from "@react-google-maps/api";
import usePlacesAutocomplete, {
  getGeocode,
  getLatLng,
} from "use-places-autocomplete";
import {
  Combobox,
  ComboboxInput,
  ComboboxPopover,
  ComboboxList,
  ComboboxOption,
} from "@reach/combobox";
import "@reach/combobox/styles.css";

let latLokGlobal = 999;
let lngLokGlobal = 999;

function Map({ setSelected }) {
  const [center, setCenter] = useState({ lat: 45.81, lng: 15.98 });
  const [selected, setSelectedLoc] = useState(null);

  return (
    <>
      <div className="places-container">
        <PlacesAutocomplete
          setSelected={(location) => {
            setSelectedLoc(location);
            setCenter(location);
          }}
        />
      </div>

      <GoogleMap
        zoom={10}
        center={center} // Dinamički centar mape
        mapContainerStyle={{
          width: "100%",
          height: "100%",
          position: "relative",
        }}
      >
        {selected && <Marker position={selected} />}
      </GoogleMap>
    </>
  );
}

const PlacesAutocomplete = ({ setSelected }) => {
  const {
    ready,
    value,
    setValue,
    suggestions: { status, data },
    clearSuggestions,
  } = usePlacesAutocomplete();

  const handleSelect = async (address) => {
    setValue(address, false);
    clearSuggestions();

    const results = await getGeocode({ address });
    const { lat, lng } = await getLatLng(results[0]);
    latLokGlobal = lat;
    lngLokGlobal = lng;
    setSelected({ lat, lng }); // Pass selected location coordinates
  };

  return (
    <Combobox onSelect={handleSelect}>
      <ComboboxInput
        value={value}
        onChange={(e) => setValue(e.target.value)}
        disabled={!ready}
        className="combobox-input"
        placeholder="Pretraži adresu"
      />
      <ComboboxPopover>
        <ComboboxList>
          {status === "OK" &&
            data.map(({ place_id, description }) => (
              <ComboboxOption key={place_id} value={description} />
            ))}
        </ComboboxList>
      </ComboboxPopover>
    </Combobox>
  );
};

const RestaurantInfoPage = () => {
  const [nazivRestoran, setNazivRestoran] = useState("");
  const [odVrijeme, setOdVrijeme] = useState("");
  const [doVrijeme, setDoVrijeme] = useState("");
  const [brTelefon, setBrTelefon] = useState("");
  const [link, setLink] = useState("");
  const [locationSelected, setLocationSelected] = useState(false);

  const navigate = useNavigate();

  const validatePhone = (phone) => {
    const phoneRegex = /^[+]?[\d\s]+$/; // Allows numbers, spaces, and an optional leading plus
    return phoneRegex.test(phone);
  };

  // Validate URL format
  const validateURL = (url) => {
    const urlRegex =
      /^(https?:\/\/)?([a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)+)(:[0-9]+)?(\/[^\s]*)?$/;
    return urlRegex.test(url);
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Check if all required fields are filled
    if (!nazivRestoran || !odVrijeme || !doVrijeme || !brTelefon) {
      alert("Molimo popunite sva obavezna polja označena sa *.");
      return;
    }

    // Check if the name is valid (e.g. not too short or too long)
    if (nazivRestoran.length < 3 || nazivRestoran.length > 100) {
      alert("Naziv restorana mora imati između 3 i 100 znakova.");
      return;
    }

    // Check if phone number is valid
    if (!validatePhone(brTelefon)) {
      alert("Broj telefona nije u ispravnom formatu.");
      return;
    }

    // Check if URL is valid (optional)
    if (link && !validateURL(link)) {
      alert("Poveznica nije ispravna.");
      return;
    }

    // Check if a location has been selected on the map
    if (latLokGlobal === 999 || lngLokGlobal === 999) {
      alert("Molimo unesite valjanu lokaciju.");
      return;
    }

    const formData = {
      nazivRestoran,
      odVrijeme,
      doVrijeme,
      latLok: latLokGlobal,
      lngLok: lngLokGlobal,
      brTelefon,
      link,
    };

    try {
      const response = await fetch("/restaurant-info", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        console.log("Podaci o restoranu su uspješno poslani.");
        navigate(0);
      } else {
        console.error("Greška pri slanju podataka.");
      }
    } catch (error) {
      console.error("Pogreška:", error);
    }
  };

  const { isLoaded } = useLoadScript({
    googleMapsApiKey: "AIzaSyA0TIFpItE6V-VzGyhfrNY9TwJjH5ZWP-I",
    libraries: ["places"],
  });

  const center = useMemo(() => ({ lat: 43.45, lng: -80.49 }), []);
  const [selected, setSelected] = useState(null);

  // Modify the setSelected function to trigger location selection
  const handleLocationSelect = (location) => {
    setSelected(location);
    setLocationSelected(true);
  };

  if (!isLoaded) return <div>Loading...</div>;

  return (
    <div className="restaurant-info-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <form className="foreground" onSubmit={handleSubmit}>
        <div className="restaurant-info-text">
          <h2>UNOS PODATAKA O RESTORANU</h2>
        </div>

        <div className="restaurant-info-form-name">
          <label htmlFor="nazivRestoran">Naziv restorana*</label>
          <input
            type="text"
            id="nazivRestoran"
            name="nazivRestoran"
            value={nazivRestoran}
            onChange={(e) => setNazivRestoran(e.target.value)}
            required
          />
        </div>

        <div className="restaurant-info-form-radnoVrijeme">
          <label htmlFor="radnoVrijeme">Radno vrijeme*</label>
          <div className="choose-time">
            <label htmlFor="odVrijeme">Od</label>
            <input
              type="time"
              id="odVrijeme"
              name="odVrijeme"
              value={odVrijeme}
              onChange={(e) => setOdVrijeme(e.target.value)}
              required
            />
            <label htmlFor="doVrijeme">Do</label>
            <input
              type="time"
              id="doVrijeme"
              name="doVrijeme"
              value={doVrijeme}
              onChange={(e) => setDoVrijeme(e.target.value)}
              required
            />
          </div>
        </div>

        <div
          className="restaurant-info-form-adress"
          style={{ height: "30vh", width: "100%" }}
        >
          <label htmlFor="adresa">Adresa*</label>
          <Map setSelected={handleLocationSelect} />
        </div>

        <div className="restaurant-info-form-telephone">
          <label htmlFor="brTelefon">Broj telefona*</label>
          <input
            type="text"
            id="brTelefon"
            name="brTelefon"
            value={brTelefon}
            onChange={(e) => setBrTelefon(e.target.value)}
            required
          />
        </div>

        <div className="restaurant-info-form-link">
          <label htmlFor="link">Poveznica</label>
          <input
            type="text"
            id="link"
            name="link"
            value={link}
            onChange={(e) => setLink(e.target.value)}
          />
        </div>

        <div className="confirm">
          <RoundedButton
            text={"Potvrdi"}
            type="submit"
            disabled={!locationSelected}
          />
        </div>
        <div className="star">
          <text>Polja označena zvjezdicom (*) moraju biti popunjena.</text>
        </div>
      </form>
    </div>
  );
};

export default RestaurantInfoPage;
