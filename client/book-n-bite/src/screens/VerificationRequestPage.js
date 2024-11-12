import TopBar from "components/TopBar";
import bgImage from "assets/images/restaurant_info.png";
import verificationImage from "assets/images/krug.png";

  
const VerificationRequestPage = () => {
    return (
        <div className="verification-request-page">
        <TopBar />
        <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
        />
        <div className="verification-request-foreground">
            <img className="verification-picture" src = {verificationImage}></img>
            <h2>Vaš zahtjev za verifikaciju je poslan. <br/> 
            Nastojat ćemo ga potvrdititi u što kraćem roku.
            </h2>
        </div>

        </div>


    );
};

export default VerificationRequestPage;