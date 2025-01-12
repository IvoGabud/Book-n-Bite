import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/my-profile.png";
import RoundedButton from "components/RoundedButton";

// Stranica na kojoj korisnik može vidjeti svoj profil
// Implementirati u 2. reviziji

const EditProfilePage = () => {
  return (
    <div className="edit-profile-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="edit-profile-page-foreground">
        <h2 className="Page-title">MOJ PROFIL</h2>
        <form className="profile-form">
          <div className="form-groud">
            <label htmlFor="username">Korisničko ime</label>
            <input type="text" id="username" name="username" placeholder="Username"/>
          </div>
          <div className="form-groud">
            <label htmlFor="firstName">Ime</label>
            <input type="text" id="firstName" name="firstName" placeholder="firstName"/>
          </div>
          <div className="form-groud">
            <label htmlFor="lastName">Prezime</label>
            <input type="text" id="lastName" name="lastName" placeholder="lastName"/>
          </div>
          <div className="form-groud">
            <label htmlFor="email">Prezime</label>
            <input type="email" id="email" name="email" placeholder="nekimail@example.com"/>
          </div>
          <div className="button-group">
            <RoundedButton text={"Odustani"} className="cancel-buttonm" />
            <RoundedButton text={"Spremi Promjene"} className="save-button"/>

          </div>

        </form>

      </div>

    
    </div>
  );
};

export default EditProfilePage;
