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

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null);
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
            <div className="form-groud">
              <label htmlFor="username">Korisničko ime</label>
              <input
                type="text"
                id="username"
                name="username"
                placeholder="Username"
                value={formData.username}
                onChange={handleInputChange}
              />
            </div>
            <div className="form-groud">
              <label htmlFor="firstName">Ime</label>
              <input
                type="text"
                id="firstName"
                name="firstName"
                placeholder="Ime"
                value={formData.firstName}
                onChange={handleInputChange}
              />
            </div>
            <div className="form-groud">
              <label htmlFor="lastName">Prezime</label>
              <input
                type="text"
                id="lastName"
                name="lastName"
                placeholder="Prezime"
                value={formData.lastName}
                onChange={handleInputChange}
              />
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
