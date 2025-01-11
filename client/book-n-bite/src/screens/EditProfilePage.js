import TopBar from "components/TopBar";
import bgImage from "assets/images/my-profile.png";
import RoundedButton from "components/RoundedButton";

// Stranica na kojoj korisnik može vidjeti svoj profil
// Implementirati u 2. reviziji

const EditProfilePage = () => {
  return (
    <div className="edit-profile-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

    
    </div>
  );
};

export default EditProfilePage;
