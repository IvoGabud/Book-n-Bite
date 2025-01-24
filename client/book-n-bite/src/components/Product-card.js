import React, { useState } from "react";
import PropTypes from "prop-types";

const ProductCard = ({
  imageSrc,
  nazivJela,
  opisJela,
  cijena,
  alergeni,
  initialOcjena,
  onRatingChange,
}) => {
  const [ocjena, setOcjena] = useState(initialOcjena);

  const handleStarClick = (rating) => {
    setOcjena(rating);
    onRatingChange(rating);
  };

  const renderStars = () => {
    return [1, 2, 3, 4, 5].map((star) => (
      <span
        key={star}
        onClick={() => handleStarClick(star)}
        style={{ cursor: "pointer" }}
      >
        {star <= ocjena ? "★" : "☆"}
      </span>
    ));
  };

  return (
    <div className="product-card">
      <img className="pizza-image" src={imageSrc} alt={nazivJela} />
      <div className="product-info">
        <h2>{nazivJela}</h2>
        <hr className="divider" />
        <p>{opisJela}</p>
        <p>
          <strong>Cijena:</strong> {cijena}
        </p>
        <p>
          <strong>Alergeni:</strong> {alergeni}
        </p>
        <div className="rating">{renderStars()}</div>
      </div>
    </div>
  );
};

ProductCard.propTypes = {
  imageSrc: PropTypes.string.isRequired,
  nazivJela: PropTypes.string.isRequired,
  opisJela: PropTypes.string,
  cijena: PropTypes.string.isRequired,
  alergeni: PropTypes.string,
  initialOcjena: PropTypes.number,
};

ProductCard.defaultProps = {
  opisJela: "Kraći opis jela...",
  alergeni: "Nema informacija",
  initialOcjena: 0,
};

export default ProductCard;
