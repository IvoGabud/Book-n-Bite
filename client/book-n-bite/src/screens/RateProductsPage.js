import bgImage from "assets/images/rate-products-image.png";
import UserProfileButton from "../components/UserProfileButton";
import React, { useState, useEffect } from "react";
import pizzaImage from "assets/images/pizza.png";
import steakImage from "assets/images/steak.png";
import saladImage from "assets/images/salad.png";
import pastaImage from "assets/images/pasta.png";
import ProductCard from "../components/Product-card";
import { useLocation } from "react-router-dom";

// stranica na kojoj ocjenjivaci ocjenjuju proizvode

const RateProductsPage = () => {
  // Dohvati kod grupe s prethodne stranice
  const location = useLocation();

  // Za production
  const groupCode = location.state?.groupCode;

  //Za development
  // const groupCode = "123456";
  // const userId = "123456";

  const [products, setProducts] = useState([]);
  const [ratings, setRatings] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!groupCode) {
      setLoading(false);
      setError("Group code is missing.");
      return;
    }

    const fetchProducts = async () => {
      try {
        const response = await fetch(`/products/${groupCode}`);
        if (!response.ok) {
          throw new Error(`Error fetching products: ${response.statusText}`);
        }
        const data = await response.json();
        setProducts(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, [groupCode]);

  const handleRatingChange = (productId, rating) => {
    setRatings((prevRatings) => ({
      ...prevRatings,
      [productId]: rating,
    }));
  };

  const handleSubmitRatings = async () => {
    try {
      const response = await fetch(`/rating/${groupCode}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(ratings),
      });

      if (!response.ok) {
        throw new Error(`Error submitting ratings: ${response.statusText}`);
      }

      alert("Ratings submitted successfully!");
    } catch (err) {
      setError(err.message);
    }
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  // const products = [
  //   {
  //     idJela: 1,
  //     imageSrc: pizzaImage,
  //     nazivJela: "Margherita",
  //     opisJela: "Klasična pizza s rajčicom i sirom.",
  //     cijena: "50 kn",
  //     alergeni: "Gluten, mlijeko",
  //     initialOcjena: 0,
  //   },
  //   {
  //     idJela: 2,
  //     imageSrc: steakImage,
  //     nazivJela: "Biftek",
  //     opisJela: "Sočni biftek na žaru.",
  //     cijena: "120 kn",
  //     alergeni: "Nema alergena",
  //     initialOcjena: 0,
  //   },
  //   {
  //     idJela: 3,
  //     imageSrc: saladImage,
  //     nazivJela: "Cezar salata",
  //     opisJela: "Hrskava salata s piletinom i dresingom.",
  //     cijena: "45 kn",
  //     alergeni: "Jaja, mlijeko",
  //     initialOcjena: 0,
  //   },
  //   {
  //     idJela: 4,
  //     imageSrc: pastaImage,
  //     nazivJela: "Carbonara",
  //     opisJela: "Tjestenina s pancetom i kremastim umakom.",
  //     cijena: "70 kn",
  //     alergeni: "Gluten, mlijeko, jaja",
  //     initialOcjena: 0,
  //   },
  // ];

  return (
    <div className="rate-products-page">
      <div className="top-bar-rate-products">
        <div className="code-next-to-text">
          <h2>Kod za vašu grupu: </h2>
          {/* Kod grupe zaprimljen na prethodnoj stranici od servera*/}
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
      {/* Placeholder kartice proizvoda, stvarne kartice ce biti dohvacene sa servera u 2. reviziji*/}
      <div class="rate-products-container">
        <div class="rate-products-text">
          <h2>
            Molimo Vas da ocijenite sljedeća jela na ljestvici od jedan do pet.
          </h2>
        </div>
        <div className="products">
          {products.map((product, index) => (
            <ProductCard
              key={product.idJela}
              {...product}
              rating={ratings[product.idJela] || 0}
              onRatingChange={(rating) =>
                handleRatingChange(product.idJela, rating)
              }
            />
          ))}
        </div>
        <div class="rateProducts-button">
          <button class="zavrsi-button" onClick={handleSubmitRatings}>
            Završi
          </button>
        </div>
      </div>
    </div>
  );
};

export default RateProductsPage;
