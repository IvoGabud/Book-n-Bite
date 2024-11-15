import TopBar from "components/TopBar";
import bgImage from "assets/images/waiting_page_icon.png";

// Stranica na kojoj korisnik čeka da njegovi prijatelji ocijene proizvode
// Implementirati u 2. reviziji

const WaitingPage = () => {
  return (
    <div className="waiting-requst-page">
      <TopBar />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="waiting-page-foreground">
        <div className="waiting-page-text">
          <h1>JOŠ SAMO MALO...</h1>
          <h3>Vaši prijatelji još uvijek ocjenjuju jela.</h3>
        </div>
      </div>
    </div>
  );
};

export default WaitingPage;
