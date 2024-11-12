import heroImage from "assets/images/hero.png";
import RoundedButton from "components/RoundedButton";

const RegisterPage = () => {
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
        <div class="form-group">
          <label for="username">Korisničko ime</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            required
          ></input>
        </div>
        <div class="form-group">
          <label for="firstName">Ime</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            required
          ></input>
        </div>
        <div class="form-group">
          <label for="lastName">Prezime</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            required
          ></input>
        </div>

        <div class="form-group-options">
                <label for="profileType">Izraditi profil kao:</label><label>
              <input type="radio" name="profileType" value="user" required ></input>{" "}
              Korisnik
                </label>
                <label>
              <input type="radio" name="profileType" value="restaurant" required
              ></input>{" "}
              Restoran
            </label>
        </div>

        <div className="register-button">
          <RoundedButton text={"Potvrdi"} />
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
