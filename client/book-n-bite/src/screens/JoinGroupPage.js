import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";

const JoinGroupPage = () => {
  return (
    <div className="join-group-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
    </div>
  );
};

export default JoinGroupPage;
