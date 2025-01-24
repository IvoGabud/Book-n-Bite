import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import TopBar from "components/TopBar";
import bgImage from "assets/images/waiting_page_icon.png";
import TopBarNoUser from "components/TopBarNoUser";
import TopBarAdmin from "components/TopBarAdmin";

const WaitingPage = () => {
  return (
    <div className="waiting-requst-page">
      <TopBarAdmin />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />

      <div className="waiting-page-foreground">
        <div className="waiting-page-text">
          <h1>VAŠ KORISNIČKI RAČUN JE TRENUTNO NEDOSTUPAN</h1>
          <h3>Molimo vas kontaktirajte administratora aplikacije.</h3>
        </div>
      </div>
    </div>
  );
};

export default WaitingPage;
