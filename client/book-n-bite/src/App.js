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
import Register from "./screens/Register";

function App() {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const [loadingUser, setLoadingUser] = React.useState(true);
  const [user, setUser] = React.useState(null);

  React.useEffect(() => {
    fetch("/is-logged-in").then((response) => {
      setLoadingUser(false);

      if (response.status === 200) {
        return response.json().then((data) => {
          console.log("User data", data);
          setIsLoggedIn(true);
        });
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
        <Route
          path="/"
          element={
            isLoggedIn ? (
              user?.isRegistered ? (
                <JoinGroupPage />
              ) : (
                <Register />
              )
            ) : (
              <LandingPage />
            )
          }
        />
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
