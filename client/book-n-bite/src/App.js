import JoinGroupPage from "screens/JoinGroupPage";
import "./App.css";
import LandingPage from "./screens/LandingPage";
import RestaurantInfoPage from "./screens/RestaurantInfoPage";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NotFoundPage from "screens/NotFoundPage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/join-group" element={<JoinGroupPage />} />
        <Route path="/restaurant-info" element={<RestaurantInfoPage />} />
        <Route path="*" element={<NotFoundPage />} />
      </Routes>
    </Router>
  );
}

export default App;
