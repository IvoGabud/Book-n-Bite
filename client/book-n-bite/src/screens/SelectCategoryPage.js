import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";


  
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
                <div className="category"></div>
                <div className="category"></div>
                <div className="category"></div>
                <div className="category"></div>
            </div>
        </div>
        </div>


    );
};

export default SelectCategoryPage;