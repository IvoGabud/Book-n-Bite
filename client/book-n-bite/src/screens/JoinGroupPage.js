import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";
import RoundedButton from "components/RoundedButton";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

const JoinGroupPage = () => {
  //react hooks
  const [groupCode, setGroupCode] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  //funkcija koja salje post request na server sa unesenim kodom grupe
  const handleJoinClick = async () => {
    //ako nije unesen kod
    if (!groupCode) {
      setErrorMessage("Molimo Vas unesite valjani kod grupe!");
      return;
    }

    try {
      const response = await fetch("/join-group", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ groupCode: groupCode }),
      });

      if (response.status === 200) {
        //ako je kod grupe valjan, prebaci korisnika na stranicu za ocjenjivanje proizvoda
        navigate("/rate-products", { state: { groupCode } });
      } else {
        //ako kod grupe nije valjan
        setErrorMessage("Molimo Vas unesite valjani kod grupe!");
      }
    } catch (error) {
      console.error("Error:", error);
      setErrorMessage("Dogodila se greška. Pokušajte ponovno.");
    }
  };

  return (
    <div className="join-group-page">
      <TopBar />
      <div className="foreground">
        <h1 className="group-code-text">Unesi kod grupe:</h1>
        <input
          type="text"
          placeholder="AH1345"
          className="code-input-box"
          value={groupCode}
          onChange={(e) => setGroupCode(e.target.value)}
        />
        <RoundedButton
          className="join-button"
          text="Pridruži se grupi"
          onClick={handleJoinClick}
        />
        {errorMessage && <p className="error-message">{errorMessage}</p>}{" "}
        <p className="no-group-text">Nemaš grupu?</p>
        <RoundedButton
          text="Stvori novu grupu"
          onClick={() => navigate("/select-category")}
        />
      </div>
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
    </div>
  );
};

export default JoinGroupPage;
