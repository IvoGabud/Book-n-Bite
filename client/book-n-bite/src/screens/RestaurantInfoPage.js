import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";

const RestaurantInfoPage = () => {
  return (
    <div className="restaurant-info-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="foreground">
        <div class="restaurant-info-text">
          <h2>UNOS PODATAKA O RESTORANU</h2>
        </div>

        <div class="restaurant-info-form-name">
          <label for="naziv restoran">Naziv restorana*</label>
          <input type="text" id="nazivRestoran" name="nazivRestoran" required ></input>
        </div>

        <div class="restaurant-info-form-radnoVrijeme">
          <label for="radno vrijeme">Radno vrijeme*</label>
          <div class="choose-time">
            <label for="odVrijeme">Od</label>
            <input type="time" id="odVrijeme" name="odVrijeme" required />
            <label for="doVrijeme">Do</label>
            <input type="time" id="doVrijeme" name="doVrijeme" required />
          </div>
        </div>

          <div class="restaurant-info-form-adress">
            <label for="adresa">Adresa*</label>
            <input type="text" id="adresa" name="adresa" required ></input>
          </div>

          <div class="restaurant-info-form-telephone">
            <label for="brTelefon">Broj telefona*</label>
            <input type="text" id="brTelefon" name="brTelefon" required ></input>
          </div>

          <div class="restaurant-info-form-link">
            <label for="link">Povezninca*</label>
            <input type="text" id="link" name="link" required ></input>
          </div>

          <div className="addLink">
            <RoundedButton text={"Dodaj poveznicu"} />
          </div>

          <div className="star"> 
            <text>Polja označena zvjezdicom (*) moraju biti popunjena.</text>
          </div>

          <div className="confirm">
            <RoundedButton text={"Potvrdi"} />
          </div>

      </div>
    </div>
  );
};

export default RestaurantInfoPage;
