import heroImage from "assets/images/hero.png";
import RoundedButton from "components/RoundedButton";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegisterPage = () => {
  // React hooks
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [profileType, setProfileType] = useState("OCJENJIVAC");
  const [validationErrors, setValidationErrors] = useState({});
  const navigate = useNavigate();

  // Function to validate form data
  const validateForm = () => {
    const errors = {};

    // Username validation
    if (!username.trim()) {
      errors.username = "Korisničko ime je obavezno.";
    }

    // First name validation (only letters and non-empty)
    if (!firstName.trim()) {
      errors.firstName = "Ime je obavezno.";
    } else if (!/^[A-Za-zČĆŠĐŽčćšđž]+$/.test(firstName)) {
      errors.firstName = "Ime smije sadržavati samo slova.";
    }

    // Last name validation (only letters and non-empty)
    if (!lastName.trim()) {
      errors.lastName = "Prezime je obavezno.";
    } else if (!/^[A-Za-zČĆŠĐŽčćšđž]+$/.test(lastName)) {
      errors.lastName = "Prezime smije sadržavati samo slova.";
    }

    setValidationErrors(errors);
    return Object.keys(errors).length === 0; // Return true if no errors
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validate form data before sending
    if (!validateForm()) {
      return; // Prevent submission if validation fails
    }

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

      // If registration is successful, navigate to the next page
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
          {validationErrors.username && (
            <p className="error">{validationErrors.username}</p>
          )}
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
          {validationErrors.firstName && (
            <p className="error">{validationErrors.firstName}</p>
          )}
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
          {validationErrors.lastName && (
            <p className="error">{validationErrors.lastName}</p>
          )}
        </div>
        <div className="profile-selection">
          <p>Izraditi profil kao:</p>
          <div className="radio-buttons">
            <label>
              <input
                type="radio"
                name="profileType"
                value="OCJENJIVAC"
                checked={profileType === "OCJENJIVAC"}
                onChange={(e) => setProfileType(e.target.value)}
              />
              Ocjenjivač
            </label>
            <label>
              <input
                type="radio"
                name="profileType"
                value="RESTORAN"
                checked={profileType === "RESTORAN"}
                onChange={(e) => setProfileType(e.target.value)}
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
