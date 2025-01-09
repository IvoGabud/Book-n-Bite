import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";

const ReviewerListPage = () => {
  const reviewers = [
    { username: "Username1", blocked: false },
    { username: "Username2", blocked: false },
    { username: "Username3", blocked: false },
    { username: "Username4", blocked: true },
    { username: "Username5", blocked: false },
  ];

  return (
    <div className="reviewer-list-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="content-container">
        <h1 className="page-title">LISTA OCJENJIVAČA</h1>
        <div className="reviewer-list">
          {reviewers.map((reviewer, index) => (
            <div className="reviewer-row" key={index}>
              <div className="reviewer-name">{reviewer.username}</div>
              <div className="actions">
                <RoundedButton
                  text={reviewer.blocked ? "Odblokiraj račun" : "Blokiraj račun"}
                />
                <RoundedButton text="Obriši račun" color="maroon" />
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default ReviewerListPage;
