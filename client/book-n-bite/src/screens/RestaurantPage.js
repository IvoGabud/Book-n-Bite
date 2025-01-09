import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";
import pizzaImage from "assets/images/pizza.png";
import triangleIcon from "assets/images/triangle.png"
import locationIcon from "assets/images/location.png"


const RestaurantPage = () => {
  return (
    <div className="restaurant-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
        <div className="restauran-page-foreground">

            <div className="restaurant-page-left-part">

                <div className="restaurant-page-title">
                    <h2>NAZIV RESTORANA</h2>
                </div>

                <div className="restaurant-info">
                    <div className="infos">
                        <p>Radno vrijeme: </p>
                        <p>08:00 - 22:00</p>
                    </div>
                    <div className="infos">
                        <p>Broj telefona: </p>
                        <p>...</p>
                    </div>
                    <hr/>

                </div>

                <div className="restaurant-location">
                    <div>
                        <p>Lokacija</p>
                    </div>
                    <div>
                        <img src={locationIcon} alt="location" className="location-icon"/>
                    </div>
                </div>
                <hr/>
                <div className="restaurant-links">
                    <p>Poveznice</p>
                    <ul>
                        <li>link1...</li>
                        <li>link2...</li>
                    </ul>
                </div>
                
                <div className="restaurant-buttons">
                    <RoundedButton text={"Uredi"}/>
                    <RoundedButton text={"Obriši profil"}/>
                </div>

            </div>

            <div className="restaurant-right-part">
                
                <div className="options">
                    <div className="brza-hrana">
                        
                        <div className="header">
                            <h3>BRZA HRANA</h3>
                            <img src={triangleIcon} alt="Strelica" className="triangle-icon"/>
                        </div>

                        <div className="broj-jela">
                            <p>prvo jelo</p>
                            <p className="drugo-jelo">drugo jelo</p>
                            <p>treće jelo</p>
                        </div>
                        <hr/>
                    </div>
                    <div className="Deserti">
                        <div className="header">
                            <h3>DESERTI</h3>
                            <img src={triangleIcon} alt="Strelica" className="triangle-icon" />
                        </div>
                        <hr/>
                    </div>
                    <div className="piće">
                        <div className="header">
                            <h3>PIĆE</h3>
                            <img src={triangleIcon} alt="Strelica" className="triangle-icon" />
                        </div>
                        
                    </div>

                </div>

                <div className="product-container">
                <img src={pizzaImage} alt="Pizza"></img>
                    <div className="product-info">
                        <h2>drugo jelo</h2>
                        <hr className="divider" />
                        <p>Opis jela</p>
                        <p>
                        <strong>Cijena:</strong> 
                        </p>
                        <p>
                        <strong>Alergeni:</strong> 
                        </p>
                    </div>
                </div>
                <div className="add-product-button">
                    <RoundedButton text={"Dodaj proizovod"}/>
                </div>

            </div>
      </div>
    </div>
  );
};

export default RestaurantPage;
