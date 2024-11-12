import bgImage from "assets/images/rate-products-image.png";
import UserProfileButton from "../components/UserProfileButton";

const RateProductsPage = () => {
    return (
        <div className="rate-products-page">
            <div className="top-bar-rate-products">
                <div className="code-next-to-text">
                    <h2>kod za vašu grupu: </h2>
                    <h1 className="code">LD6658</h1>
                </div>

                <div className="top-button">
                <UserProfileButton />
                </div>
            </div>

            <div
              className="bg-image"
              style={{ backgroundImage: `url(${bgImage})` }}
            />
        </div>
    );
};

export default RateProductsPage;
