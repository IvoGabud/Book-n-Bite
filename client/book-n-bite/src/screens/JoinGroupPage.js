import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";
import RoundedButton from "components/RoundedButton";
import { useNavigate } from "react-router-dom";

const JoinGroupPage = () => {
  const navigate = useNavigate();

  return (
    <div className="join-group-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="foreground">
        <h1 className="group-code-text">Unesi kod grupe:</h1>
        <input type="text" placeholder="AH1345" className="code-input-box" />
        <RoundedButton className="join-button" text="Pridruži se grupi" />
        <p className="no-group-text">Nemaš grupu?</p>
        <RoundedButton
          text="Stvori novu grupu"
          onClick={() => navigate("/select-category")}
        />
      </div>
    </div>
  );
};

export default JoinGroupPage;
