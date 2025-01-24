import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/my-profile.png";
import RoundedButton from "components/RoundedButton";

const EditProfilePage = () => {
  const [formData, setFormData] = useState({
    username: "",
    firstName: "",
    lastName: "",
  });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [validationErrors, setValidationErrors] = useState({});
  const navigate = useNavigate();

  // Fetch user data from the server
  const fetchUserData = async () => {
    try {
      const response = await fetch("get-reviewer");
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.json();
      setFormData({
        username: data.username || "",
        firstName: data.firstName || "",
        lastName: data.lastName || "",
      });
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchUserData();
  }, []);

  // Handle input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  // Validate form data
  const validateForm = () => {
    const errors = {};

    // Username validation
    if (!formData.username.trim()) {
      errors.username = "Korisničko ime je obavezno.";
    }

    // First name validation (only letters)
    if (!formData.firstName.trim()) {
      errors.firstName = "Ime je obavezno.";
    } else if (!/^[A-Za-zČĆŠĐŽčćšđž]+$/.test(formData.firstName)) {
      errors.firstName = "Ime smije sadržavati samo slova.";
    }

    // Last name validation (only letters)
    if (!formData.lastName.trim()) {
      errors.lastName = "Prezime je obavezno.";
    } else if (!/^[A-Za-zČĆŠĐŽčćšđž]+$/.test(formData.lastName)) {
      errors.lastName = "Prezime smije sadržavati samo slova.";
    }

    setValidationErrors(errors);
    return Object.keys(errors).length === 0;
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);

    // Validate form
    if (!validateForm()) {
      return;
    }

    try {
      const response = await fetch("update-reviewer", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }

      navigate("/profile-page");
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div className="edit-profile-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="edit-profile-page-foreground">
        <h2 className="Page-title">MOJ PROFIL</h2>
        {loading ? (
          <p>Učitavanje podataka...</p>
        ) : error ? (
          <p className="error">{error}</p>
        ) : (
          <form className="profile-form" onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="username">Korisničko ime</label>
              <input
                type="text"
                id="username"
                name="username"
                placeholder="Username"
                value={formData.username}
                onChange={handleInputChange}
              />
              {validationErrors.username && (
                <p className="error">{validationErrors.username}</p>
              )}
            </div>
            <div className="form-group">
              <label htmlFor="firstName">Ime</label>
              <input
                type="text"
                id="firstName"
                name="firstName"
                placeholder="Ime"
                value={formData.firstName}
                onChange={handleInputChange}
              />
              {validationErrors.firstName && (
                <p className="error">{validationErrors.firstName}</p>
              )}
            </div>
            <div className="form-group">
              <label htmlFor="lastName">Prezime</label>
              <input
                type="text"
                id="lastName"
                name="lastName"
                placeholder="Prezime"
                value={formData.lastName}
                onChange={handleInputChange}
              />
              {validationErrors.lastName && (
                <p className="error">{validationErrors.lastName}</p>
              )}
            </div>
            <div className="button-group">
              <RoundedButton
                text={"Odustani"}
                className="cancel-button"
                onClick={() => navigate("/profile-page")}
              />
              <RoundedButton
                text={"Spremi Promjene"}
                className="save-button"
                type="submit"
              />
            </div>
          </form>
        )}
      </div>
    </div>
  );
};

export default EditProfilePage;
