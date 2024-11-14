import heroImage from "assets/images/hero.png";
import RoundedButton from "components/RoundedButton";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegisterPage = () => {
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [profileType, setProfileType] = useState("user");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = {
      username,
      firstName,
      lastName,
    };

    try {
      const response = await fetch("/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        const result = await response.json();
        console.log("Uspjesna registracija:", result);
        navigate("/join-group");
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
              <input type="radio" name="profileType" value="user" />
              Korisnik
            </label>
            <label>
              <input type="radio" name="profileType" value="restaurant" />
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
