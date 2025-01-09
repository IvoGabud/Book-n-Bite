import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";

// Stranica na kojoj restoran čeka potvrdu verifikacije
// Implementirati u 2. reviziji

const AddProductPage = () => {
  return (
    <div className="add-product-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="foreground">
        <div className="add-product-title">
          <h2>Dodavanje proizvoda</h2>
        </div>

        <div className="add-product-form-name">
          <label htmlFor="nazivProizvod">Naziv proizvoda</label>
          <input
            type="text"
            id="nazivProizvod"
            name="nazivProizvod"
            required
            ></input>
        </div>
        <div className="add-product-form-description">
          <label htmlFor="opisProizvod">Opis proizvoda</label>
          <input
            type="text"
            id="opisProizvod"
            name="opisProizvod"
            required
            ></input>
        </div>
        <div className="add-product-form-category">
          <label htmlFor="kategorijaProizvod">Kategorija proizvoda</label>
          <input
            type="text"
            id="kategorijaProizvod"
            name="kategorijaProizvod"
            required
            ></input>
        </div>
        <div className="add-product-form-price">
          <label htmlFor="cijenaProizvod">Cijena (EUR)</label>
          <input
            type="text"
            id="cijenaProizvod"
            name="cijenaProizvod"
            required
            ></input>
        </div>
        <div className="add-product-form-allergens">
          <label htmlFor="alergeniProizvod">Alergeni</label>
          <input
            type="text"
            id="alergeniProizvod"
            name="alergeniProizvod"
            required
          ></input>
        </div>
        
        <div className="image-upload-box">
          <div className="upload-content">
            <span class="plus-icon">+</span>
            <p>Odaberite ili dovucite sliku proizvoda ovdje</p>
          </div>
          <input type="file" class="file-input" accept="image/*"></input>
        </div>

        <div className="create-product">
          <RoundedButton text={"Stvori proizvod"}/>
        </div>

      </div>
    </div>
  );
};

export default AddProductPage;
