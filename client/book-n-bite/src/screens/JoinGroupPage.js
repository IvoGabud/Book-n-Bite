import TopBar from "components/TopBar";
import bgImage from "assets/images/join_group_bg.png";
import RoundedButton from "components/RoundedButton";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";

const JoinGroupPage = () => {
  const [groupCode, setGroupCode] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();
  const [userData, setUserData] = useState({});

  const fetchUserData = async () => {
    try {
      const response = await fetch("get-reviewer");
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.json();
      setUserData(data);
    } catch (err) {
      alert(err.message);
    }
  };

  useEffect(() => {
    fetchUserData();
  }, []);

  const handleInputChange = (e) => {
    // Pretvaranje unosa u velika slova
    setGroupCode(e.target.value.toUpperCase());
  };

  const handleJoinClick = async () => {
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
        navigate("/rate-products", { state: { groupCode } });
      } else {
        setErrorMessage("Molimo Vas unesite valjani kod grupe!");
      }
    } catch (error) {
      console.error("Error:", error);
      setErrorMessage("Dogodila se greška. Pokušajte ponovno.");
    }
  };

  return (
    <div className="join-group-page">
      <TopBar username={userData.username} />
      <div className="foreground">
        <h1 className="group-code-text">Unesi kod grupe:</h1>
        <input
          type="text"
          placeholder="AH1345"
          className="code-input-box"
          value={groupCode}
          onChange={handleInputChange}
        />
        <RoundedButton
          className="join-button"
          text="Pridruži se grupi"
          onClick={handleJoinClick}
        />
        {errorMessage && <p className="error-message">{errorMessage}</p>}
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
