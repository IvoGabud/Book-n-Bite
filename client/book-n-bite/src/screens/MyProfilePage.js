import TopBar from "components/TopBar";
import bgImage from "assets/images/my-profile.png";
import RoundedButton from "components/RoundedButton";

// Stranica na kojoj korisnik može vidjeti svoj profil
// Implementirati u 2. reviziji

const MyProfilePage = () => {
  return (
    <div className="my-profile-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="my-profile-foreground">
        <div className="my-profile-title">
          <h2>MOJ PROFIL</h2>
        </div>
        <div className="my-profile-data">
          <div className="my-profile-part">
            <label for="username">Korisničko ime:</label>
            <div class="element">
              <span class="username">username</span>
            </div>
          </div>

          <div className="my-profile-part">
            <label for="ime">Ime:</label>
            <div class="element">
              <span class="Ime">firstName</span>
            </div>
          </div>

          <div className="my-profile-part">
            <div className="element">
              <label htmlFor="prezime">Prezime:</label>
            </div>
            <div class="element">
              <span class="Ime">lastName</span>
            </div>
          </div>
          <div className="my-profile-buttons">
            <RoundedButton text={"Natrag"} />
            <RoundedButton text={"Uredi Profil"} />
          </div>
        </div>


      </div>
    </div>
  );
};

export default MyProfilePage;
