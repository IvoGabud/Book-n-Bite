import bgImage from "assets/images/rate-products-image.png";
import UserProfileButton from "../components/UserProfileButton";
import pizzaImage from "assets/images/pizza.png";
import steakImage from "assets/images/steak.png";
import saladImage from "assets/images/salad.png";
import { useLocation } from "react-router-dom";

const RateProductsPage = () => {
  const location = useLocation();
  const groupCode = location.state?.groupCode;
  return (
    <div className="rate-products-page">
      <div className="top-bar-rate-products">
        <div className="code-next-to-text">
          <h2>kod za vašu grupu: </h2>
          <h1 className="code">{groupCode ? groupCode : "-----"}</h1>
        </div>

        <div className="top-button">
          <UserProfileButton />
        </div>
      </div>

      <div
        className="bg-image-rateProducts"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div class="rate-products-container">
        <div class="rate-products-text">
          <h2>
            Molimo Vas da ocijenite sljedeća jela na ljestvici od jedan do pet.
          </h2>
        </div>
        <div class="products">
          <div class="product-card">
            <img className="pizza-image" src={pizzaImage}></img>
            <div className="product-info">
              <h2>Naziv jela</h2>
              <hr className="divider" />
              <p>Kraći opis jela...</p>
              <p>
                <strong>cijena:</strong>
              </p>
              <p>
                <strong>alergeni:</strong>
              </p>
              <div class="rating">★★★★☆</div>
            </div>
          </div>
          <div class="product-card">
            <img className="pizza-image" src={steakImage}></img>
            <div className="product-info">
              <h2>Naziv jela</h2>
              <hr className="divider" />
              <p>Kraći opis jela...</p>
              <p>
                <strong>cijena:</strong>
              </p>
              <p>
                <strong>alergeni:</strong>
              </p>
              <div class="rating">★★★★☆</div>
            </div>
          </div>
          <div class="product-card">
            <img className="salad-image" src={saladImage}></img>
            <div className="product-info">
              <h2>Naziv jela</h2>
              <hr className="divider" />
              <p>Kraći opis jela...</p>
              <p>
                <strong>cijena:</strong>
              </p>
              <p>
                <strong>alergeni:</strong>
              </p>
              <div class="rating">★★★★☆</div>
            </div>
          </div>
        </div>

        <div class="rateProducts-button">
          <button class="zavrsi-button">Završi</button>
        </div>
      </div>
    </div>
  );
};

export default RateProductsPage;
