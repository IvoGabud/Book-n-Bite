import { useState } from "react";
import { useNavigate } from "react-router-dom";
import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";

const RestaurantInfoPage = () => {
  const [nazivRestoran, setNazivRestoran] = useState("");
  const [odVrijeme, setOdVrijeme] = useState("");
  const [doVrijeme, setDoVrijeme] = useState("");
  const [adresa, setAdresa] = useState("");
  const [brTelefon, setBrTelefon] = useState("");
  const [link, setLink] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = {
      nazivRestoran,
      odVrijeme,
      doVrijeme,
      adresa,
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
        navigate("/");
      } else {
        console.error("Greška pri slanju podataka.");
      }
    } catch (error) {
      console.error("Pogreška:", error);
    }
  };

  return (
    <div className="restaurant-info-page">
      <TopBar />
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

        <div className="restaurant-info-form-adress">
          <label htmlFor="adresa">Adresa*</label>
          <input
            type="text"
            id="adresa"
            name="adresa"
            value={adresa}
            onChange={(e) => setAdresa(e.target.value)}
            required
          />
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
          <label htmlFor="link">Poveznica*</label>
          <input
            type="text"
            id="link"
            name="link"
            value={link}
            onChange={(e) => setLink(e.target.value)}
            required
          />
        </div>

        <div className="confirm">
          <RoundedButton text={"Potvrdi"} type="submit" />
        </div>
        <div className="star">
          <text>Polja označena zvjezdicom (*) moraju biti popunjena.</text>
        </div>
      </form>
    </div>
  );
};

export default RestaurantInfoPage;
