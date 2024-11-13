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
      const response = await fetch("http://localhost:8080/register", {
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
      <div className="foreground">
        <div className="my-profile-title">
          <h2>REGISTRACIJA</h2>
        </div>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="username">Korisničko ime</label>
            <input
              type="text"
              id="username"
              name="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)} // Bind to state
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="firstName">Ime</label>
            <input
              type="text"
              id="firstName"
              name="firstName"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)} // Bind to state
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="lastName">Prezime</label>
            <input
              type="text"
              id="lastName"
              name="lastName"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)} // Bind to state
              required
            />
          </div>

          <div className="form-group-options">
            <label htmlFor="profileType">Izraditi profil kao:</label>
            <label>
              <input
                type="radio"
                name="profileType"
                value="user"
                checked={profileType === "user"}
                onChange={(e) => setProfileType(e.target.value)} // Bind to state
                required
              />{" "}
              Korisnik
            </label>
            <label>
              <input
                type="radio"
                name="profileType"
                value="restaurant"
                checked={profileType === "restaurant"}
                onChange={(e) => setProfileType(e.target.value)} // Bind to state
                required
              />{" "}
              Restoran
            </label>
          </div>

          <div className="register-button">
            <RoundedButton text={"Potvrdi"} />
          </div>
        </form>
      </div>
    </div>
  );
};

export default RegisterPage;
