import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import RoundedButton from "components/RoundedButton";

const JoinGroupPage = () => {
  return (
    <div className="restaurant-info-page">
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="foreground"></div>
    </div>
  );
};

export default JoinGroupPage;
