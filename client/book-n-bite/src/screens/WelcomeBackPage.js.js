import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import userIcon from "assets/images/usrIcon.png";
import mealIcon from "assets/images/mealIcon.png";
import checkIcon from "assets/images/krug (2).png";
import RoundedButton from "components/RoundedButton";



// Stranica na kojoj restoran čeka potvrdu verifikacije
// Implementirati u 2. reviziji

const WelcomeBackPage = () => {
  return (
    <div className="welcome-back-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="welcome-back-container">
        <h1 className="welcome-text">DOBRODOŠLI NATRAG!</h1>

        <div className="welcome-back-categories">
          <div className="category">
            <img src={userIcon} alt="User Icon" className="icon" />
            <p className="category-text">Pregled liste ocjenjivača</p>

          </div>
          <div className="category">
           <img src={mealIcon} alt="Meal Icon" className="icon" />
            <p className="category-text">Pregled liste obroka</p>
          </div>
          <div className="category">
            <img src={checkIcon} alt="Check Icon" className="icon" />
            <p className="category-text">Pregled liste za verifikaciju</p>
          </div>

        </div>

      </div>

    </div>
  );
};

export default WelcomeBackPage;
