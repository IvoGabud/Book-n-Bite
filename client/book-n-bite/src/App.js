import JoinGroupPage from "./screens/JoinGroupPage";
import * as React from "react";
import "./App.css";
import LandingPage from "./screens/LandingPage";
import RestaurantInfoPage from "./screens/RestaurantInfoPage";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import NotFoundPage from "./screens/NotFoundPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const [loadingUser, setLoadingUser] = React.useState(true);

  React.useEffect(() => {
    fetch("http://localhost:8080/request").then((response) => {
      setLoadingUser(false);

      if (response.status === 200) {
        console.log("response", response);
        setIsLoggedIn(true);
      } else {
        setIsLoggedIn(false);
      }
    });
  }, []);

  if (loadingUser) {
    return <div>Loading...</div>;
  }

  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route
          path="/join-group"
          element={
            isLoggedIn ? <JoinGroupPage /> : <Navigate to="/not-found" />
          }
        />
        <Route
          path="/restaurant-info"
          element={
            isLoggedIn ? <RestaurantInfoPage /> : <Navigate to="/not-found" />
          }
        />
        <Route path="/not-found" element={<NotFoundPage />} />
        <Route path="*" element={<Navigate to="/not-found" />} />
      </Routes>
    </Router>
  );
}

export default App;
