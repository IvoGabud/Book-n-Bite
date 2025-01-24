import bgImage from "assets/images/rate-products-image.png";
import UserProfileButton from "../components/UserProfileButton";
import React, { useState, useEffect } from "react";
import pizzaImage from "assets/images/pizza.png";
import steakImage from "assets/images/steak.png";
import saladImage from "assets/images/salad.png";
import pastaImage from "assets/images/pasta.png";
import ProductCard from "../components/Product-card";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import RoundedButton from "../components/RoundedButton";

// stranica na kojoj ocjenjivaci ocjenjuju proizvode

const RateProductsPage = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const groupCode = location.state?.groupCode;

  const [products, setProducts] = useState([]);
  const [ratings, setRatings] = useState({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [formError, setFormError] = useState(""); // To display an error if not all products are rated

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

  const handleLeaveGroup = async () => {
    try {
      const response = await fetch("/leave", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        navigate("/");
      } else {
        console.error("Pogreška pri napuštanju grupe:", response.statusText);
      }
    } catch (error) {
      console.error("Došlo je do pogreške:", error);
    }
  };

  const handleSubmitRatings = async () => {
    // Ensure all products are rated
    const unratedProducts = products.filter(
      (product) => !ratings[product.jeloRestoranId]
    );

    if (unratedProducts.length > 0) {
      setFormError("Molimo Vas da ocijenite sva jela prije nastavka!");
      return;
    }

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
      navigate("/waiting-page", { state: { groupCode } });
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

  return (
    <div className="rate-products-page">
      <div className="top-bar-rate-products">
        <div className="code-next-to-text">
          <h2>Kod za vašu grupu: </h2>
          <h1 className="code">{groupCode ? groupCode : "-----"}</h1>
        </div>
        <RoundedButton text="Napusti grupu" onClick={handleLeaveGroup} />
      </div>

      <div
        className="bg-image-rateProducts"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="rate-products-container">
        <div className="rate-products-text">
          <h2>
            Molimo Vas da ocijenite sljedeća jela na ljestvici od jedan do pet.
          </h2>
        </div>
        <div className="products">
          {products.map((product) => (
            <ProductCard
              key={product.jeloRestoranId}
              {...product}
              rating={ratings[product.jeloRestoranId] || 0}
              onRatingChange={(rating) =>
                handleRatingChange(product.jeloRestoranId, rating)
              }
            />
          ))}
        </div>
        {formError && <p className="form-error">{formError}</p>}
        <div className="rateProducts-button">
          <button className="zavrsi-button" onClick={handleSubmitRatings}>
            Završi
          </button>
        </div>
      </div>
    </div>
  );
};

export default RateProductsPage;
