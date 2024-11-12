import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";
import hamburger from "assets/images/hamburger.svg"
import plate from "assets/images/plate.svg"
import cake from "assets/images/cake.svg"
import drink from "assets/images/drink.svg"

  
const SelectCategoryPage = () => {
    return (
        <div className="select-category-page">
        <TopBar />
        <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
        />
        <div className="select-category-foreground">
            <h2 className="select-category-text">Odaberi kategoriju jela:</h2>
            <div className="categories">
                <div className="category">
                    <div className="category-image">
                        <img src={hamburger} alt="hamburger icon" />
                    </div>
                    <div className="category-text">Brza hrana</div>
                </div>
                <div className="category">
                    <div className="category-image">
                        <img src={plate} alt="plate icon" />
                    </div>
                    <div className="category-text">Obična hrana</div>
                </div>
                <div className="category">
                    <div className="category-image">
                        <img src={cake} alt="cake icon" />
                    </div>
                    <div className="category-text">Deserti</div>
                </div>
                <div className="category">
                    <div className="category-image">
                        <img src={drink} alt="drink icon" />
                    </div>
                    <div className="category-text">Piće</div>
                </div>
                    

            </div>
        </div>
        </div>


    );
};

export default SelectCategoryPage;