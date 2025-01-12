import heroImage from "assets/images/hero.png";
import RoundedButton from "components/RoundedButton";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegisterPage = () => {
  // react hooks
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [profileType, setProfileType] = useState("OCJENJIVAC");
  const navigate = useNavigate();

  // funkcija koja salje post request na server s podacima o korisniku

  const handleSubmit = async (e) => {
    e.preventDefault(); // sprijeci zadano ponasanje forme

    const formData = {
      username,
      firstName,
      lastName,
      userType: profileType,
    };

    try {
      const response = await fetch("/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });
      // ako je registracija uspjesna, prebaci korisnika na stranicu za pridruzivanje grupi
      if (response.ok) {
        const result = await response.json();
        window.location.reload();
      } else {
        console.error("Neuspjesna registracija");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="register-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${heroImage})` }}
      />
      <form onSubmit={handleSubmit}>
        <h2>REGISTRACIJA</h2>
        <div className="label-input">
          <label htmlFor="username">Korisničko ime</label>
          <input
            type="text"
            id="username"
            name="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="label-input">
          <label htmlFor="firstName">Ime</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
            required
          />
        </div>
        <div className="label-input">
          <label htmlFor="lastName">Prezime</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
            required
          />
        </div>
        <div className="profile-selection">
          <p>Izraditi profil kao:</p>
          <div className="radio-buttons">
            <label>
              <input
                type="radio"
                name="profileType"
                value="user"
                defaultChecked
                checked={profileType === "RESTORAN"}
              />
              Korisnik
            </label>
            <label>
              <input
                type="radio"
                name="profileType"
                value="restaurant"
                checked={profileType === "OCJENJIVAC"}
              />
              Restoran
            </label>
          </div>
        </div>

        <div className="register-button">
          <RoundedButton text={"Potvrdi"} />
        </div>
      </form>
    </div>
  );
};

export default RegisterPage;
