import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";
import hamburger from "assets/images/hamburger.svg";
import plate from "assets/images/plate.svg";
import cake from "assets/images/cake.svg";
import drink from "assets/images/drink.svg";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import TopBarHome from "components/TopBarHome";
import TopBarBack from "components/TopBarBack";

const categories = [
  { name: "brza-hrana", img: hamburger, displayName: "Brza hrana" },
  { name: "obicni", img: plate, displayName: "Obični obroci" },
  { name: "desert", img: cake, displayName: "Deserti" },
  { name: "pica", img: drink, displayName: "Pića" },
];

const SelectCategoryPage = () => {
  const navigate = useNavigate();

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
        navigate("/rate-products", { state: { groupCode: data.grupaKod } });
      } else {
        console.error("Neuspješan odabir kategorije");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="select-category-page">
      <TopBarBack />
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
              <div className="category-text">{category.displayName}</div>
              <div className="overlay"></div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default SelectCategoryPage;
