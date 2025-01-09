import TopBar from "components/TopBar";
import bgImage from "assets/images/RecommendedIcon.png";
import RoundedButton from "components/RoundedButton";

// Stranica na kojoj restoran čeka potvrdu verifikacije
// Implementirati u 2. reviziji

const RecommendedPage = () => {
  return (
    <div className="recommended-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="recommended-page-container">
        <div className="recommended-page-part1">
            <div>
              <p>Na temelju vaše grupe, preporučujemo vam</p>
            </div>

            <div className="prviRest">
              <div>
                <h2>PRVI RESTORAN</h2>
              </div>
              <div>
                <RoundedButton text={"Posjeti stranicu restorana"} />
              </div>

            </div>
            
            <div>
              <div className="rating">
                <span class="star filled">&#9733;</span>
                <span class="star filled">&#9733;</span>
                <span class="star filled">&#9733;</span>
                <span class="star filled">&#9733;</span>
                <span class="star">&#9734;</span>
                <span class="rating-text"> 4.0</span>
              </div>

            </div>
          </div>
          
          <div className="recommended-page-part2">
            <div>
                <p>Također preporučujemo:</p>
            </div>
            <div className="grid-container">
    <h4>Drugi restoran</h4>
    <div className="rating">
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="star">&#9734;</span>
      <span className="rating-text">4.0</span>
    </div>
    <RoundedButton text={"Posjeti stranicu"} />

    <h4>Treći restoran</h4>
    <div className="rating">
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="star">&#9734;</span>
      <span className="rating-text">4.0</span>
    </div>
    <RoundedButton text={"Posjeti stranicu"} />

    <h4>Četvrti restoran</h4>
    <div className="rating">
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="star">&#9734;</span>
      <span className="rating-text">4.0</span>
    </div>
    <RoundedButton text={"Posjeti stranicu"} />

    <h4>Peti restoran</h4>
    <div className="rating">
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="starfilled">&#9733;</span>
      <span className="star">&#9734;</span>
      <span className="rating-text">4.0</span>
    </div>
    <RoundedButton text={"Posjeti stranicu"} />
  </div>

          </div>
      </div>
      

    </div>
  );
};

export default RecommendedPage;
