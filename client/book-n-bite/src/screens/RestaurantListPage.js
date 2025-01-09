import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";

const RestaurantListPage = () => {
  const restaurants = [
    { name: "Restoran1", blocked: false },
    { name: "Restoran2", blocked: false },
    { name: "Restoran3", blocked: true },
    { name: "Restoran4", blocked: true },
    { name: "Restoran5", blocked: false },
  ];

  return (
    <div className="reviewer-list-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="content-container">
        <h1 className="page-title">LISTA RESTORANA</h1>
        <div className="reviewer-list">
          {restaurants.map((restaurant, index) => (
            <div className="reviewer-row" key={index}>
              <div className="reviewer-name">{restaurant.name}</div>
              <div className="actions">
                <RoundedButton
                  text={restaurant.blocked ? "Odblokiraj račun" : "Blokiraj račun"}
                />
                <RoundedButton text="Obriši račun" />
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default RestaurantListPage;
