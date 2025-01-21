import React, { useState } from "react";
import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";
import { useNavigate } from "react-router-dom";

const AddProductPage = () => {
  const navigate = useNavigate();
  // State variables to hold form values
  const [productName, setProductName] = useState("");
  const [productDescription, setProductDescription] = useState("");
  const [productCategory, setProductCategory] = useState("");
  const [productPrice, setProductPrice] = useState("");
  const [productAllergens, setProductAllergens] = useState("");
  const [productImage, setProductImage] = useState(null);

  // Handle form field changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    switch (name) {
      case "nazivProizvod":
        setProductName(value);
        break;
      case "opisProizvod":
        setProductDescription(value);
        break;
      case "kategorijaProizvod":
        setProductCategory(value);
        break;
      case "cijenaProizvod":
        setProductPrice(value);
        break;
      case "alergeniProizvod":
        setProductAllergens(value);
        break;
      default:
        break;
    }
  };

  const handleFileChange = (e) => {
    setProductImage(e.target.files[0]);
  };

  // Ovdje koristimo formu
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      !productName ||
      !productDescription ||
      !productCategory ||
      !productPrice ||
      !productAllergens ||
      !productImage
    ) {
      alert("Molimo vas popunite sva polja i prenesite sliku proizvoda.");
      return;
    }

    // Ako backend očekuje formData (zbog slike):
    const formData = new FormData();
    formData.append("naziv", productName);
    formData.append("opis", productDescription);
    formData.append("kategorija", productCategory);
    formData.append("cijena", productPrice);
    formData.append("alergeni", productAllergens);
    formData.append("imageSrc", productImage);

    try {
      const response = await fetch("/restaurant-dish", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        throw new Error("Neuspješno stvaranje proizvoda");
      }

      alert("Uspješno stvaranje proizvoda!");
      navigate(-1);
    } catch (error) {
      console.error("Greška prilikom stvaranja proizvoda:", error);
      alert("Greška prilikom stvaranja proizvoda! Molimo vas pokušajte ponovo.");
    }
  };

  return (
    <div className="add-product-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      {/* Jedan jedini <form> koji obuhvaća sve inpute i gumb */}
      <form className="foreground" onSubmit={handleSubmit}>
        <div className="add-product-title">
          <h2>Dodavanje proizvoda</h2>
        </div>

        <div className="add-product-form-name">
          <label htmlFor="nazivProizvod">Naziv proizvoda</label>
          <input
            type="text"
            id="nazivProizvod"
            name="nazivProizvod"
            value={productName}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="add-product-form-description">
          <label htmlFor="opisProizvod">Opis proizvoda</label>
          <input
            type="text"
            id="opisProizvod"
            name="opisProizvod"
            value={productDescription}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="add-product-form-category">
          <label htmlFor="kategorijaProizvod">Kategorija proizvoda</label>
          <input
            type="text"
            id="kategorijaProizvod"
            name="kategorijaProizvod"
            value={productCategory}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="add-product-form-price">
          <label htmlFor="cijenaProizvod">Cijena (EUR)</label>
          <input
            type="text"
            id="cijenaProizvod"
            name="cijenaProizvod"
            value={productPrice}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="add-product-form-allergens">
          <label htmlFor="alergeniProizvod">Alergeni</label>
          <input
            type="text"
            id="alergeniProizvod"
            name="alergeniProizvod"
            value={productAllergens}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="image-upload-box">
          <div className="upload-content">
            <span className="plus-icon">+</span>
            <p>Odaberite ili dovucite sliku proizvoda ovdje</p>
          </div>
          <input
            type="file"
            className="file-input"
            accept="image/*"
            onChange={handleFileChange}
          />
        </div>

        <div className="create-product">
          {/* Gumb s tipom "submit" za slanje forme */}
          <RoundedButton text="Stvori proizvod" />
        </div>
      </form>
    </div>
  );
};

export default AddProductPage;
