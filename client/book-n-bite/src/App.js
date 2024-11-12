import JoinGroupPage from "screens/JoinGroupPage";
import "./App.css";
import LandingPage from "./screens/LandingPage";
import RestaurantInfoPage from "./screens/RestaurantInfoPage";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NotFoundPage from "screens/NotFoundPage";
import SelectCategoryPage from "screens/SelectCategoryPage";
import VerificationRequest from "screens/VerificationRequestPage";
import WaitingPage from "screens/WaitingPage";
import MyProfilePage from "screens/MyProfilePage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/join-group" element={<JoinGroupPage />} />
        <Route path="/restaurant-info" element={<RestaurantInfoPage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="/select-category" element={<SelectCategoryPage />} />
        <Route path="/verification-request" element={<VerificationRequest />} />
        <Route path="/waiting" element={<WaitingPage />} />
        <Route path="/my-profile" element={<MyProfilePage />} />



      </Routes>
    </Router>
  );
}

export default App;
