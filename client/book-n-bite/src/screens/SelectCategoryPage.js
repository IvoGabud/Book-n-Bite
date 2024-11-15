import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";
import hamburger from "assets/images/hamburger.svg";
import plate from "assets/images/plate.svg";
import cake from "assets/images/cake.svg";
import drink from "assets/images/drink.svg";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

// Stranica na kojoj korisnik odabire kategoriju proizvoda

//Popis kategorija proizvoda
const categories = [
  { name: "brza-hrana", img: hamburger },
  { name: "obicni", img: plate },
  { name: "desert", img: cake },
  { name: "pica", img: drink },
];

const SelectCategoryPage = () => {
  const navigate = useNavigate();

  // funkcija koja salje post request na server s odabranom kategorijom

  const handleCategoryClick = async (categoryName) => {
    try {
      const response = await fetch("/create-group", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ kategorijaGrupa: categoryName }),
      });

      if (response.ok) {
        const data = await response.json();
        // ako je odabir kategorije uspjesan, prebaci korisnika na stranicu za ocjenjivanje proizvoda
        navigate("/rate-products", { state: { groupCode: data.groupCode } });
      } else {
        console.error("Neuspjesan odabir kategorije");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="select-category-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="foreground">
        <h2 className="select-category-text">Odaberi kategoriju jela:</h2>
        <div className="categories">
          {categories.map((category) => (
            <div
              key={category.name}
              className="category"
              onClick={() => handleCategoryClick(category.name)}
            >
              <div className="category-image">
                <img src={category.img} alt={`${category.name} icon`} />
              </div>
              <div className="category-text">{category.name}</div>
              <div className="overlay"></div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default SelectCategoryPage;
