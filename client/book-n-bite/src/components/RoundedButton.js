import React from "react";

const RoundedButton = ({ className, text, onClick }) => {
  return (
    <button className={`rounded-button ${className}`} onClick={onClick}>
      {text}
    </button>
  );
};

export default RoundedButton;
