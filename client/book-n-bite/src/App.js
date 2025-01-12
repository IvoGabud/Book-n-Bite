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
import RegisterPage from "./screens/RegisterPage";
import SelectCategoryPage from "screens/SelectCategoryPage";
import RateProductsPage from "screens/RateProductsPage";
import AddProductPage from "screens/AddProductPage";
import VerificationRequestPage from "screens/VerificationRequestPage";
import MyProfilePage from "screens/MyProfilePage";
import RestaurantPage from "screens/RestaurantPage";
import RecommendedPage from "screens/RecommendedPage";
import welcomeBackPage from "screens/WelcomeBackPage.js";
import WelcomeBackPage from "screens/WelcomeBackPage.js";
import ReviewerListPage from "screens/ReviewListPage.js";
import RestaurantListPage from "screens/RestaurantListPage";
import VerificationListPage from "screens/VerificationListPage.js";
import EditProfilePage from "screens/EditProfilePage";
import RestaurantPageOverview from "screens/RestaurantPageOverview";

function App() {
  //react hooks
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  const [loadingUser, setLoadingUser] = React.useState(true);
  const [user, setUser] = React.useState(null);
  const [userType, setUserType] = React.useState("");

  //provjerava je li korisnik prijavljen te prima informacije o korisniku
  React.useEffect(() => {
    document.title = "Book n' Bite";
    fetch("/is-logged-in").then((response) => {
      setLoadingUser(false);

      if (response.status === 200) {
        return response.json().then((data) => {
          //data sadrzi informacije o korisniku medu kojima je i informacija je li korisnik vec registriran
          setUser(data);
          setUserType(data.userType);
          setIsLoggedIn(true);
        });
      } else {
        setIsLoggedIn(false);
      }
    });
    console.log("userType: ", userType);
  }, []);

  //prikazuje se kada su informacije o korisniku u procesu dohvata
  if (loadingUser) {
    return <div>Loading...</div>;
  }

  return (
    <Router>
      <Routes>
        {/* provjera je li korisnik prijavljen te je li prethodno registriran i prikaz specificne stranice u ovisnosti o tome*/}
        <Route
          path="/"
          element={
            isLoggedIn ? (
              user?.isRegistered === true ? (
                userType === "RESTORAN" ? (
                  <RestaurantInfoPage />
                ) : userType === "OCJENJIVAC" ? (
                  <JoinGroupPage />
                ) : userType === "ADMINISTRATOR" ? (
                  <VerificationListPage />
                ) : (
                  (console.log("Unknown user type"), (<NotFoundPage />))
                )
              ) : (
                (console.log(
                  "user:",
                  user,
                  "isLoggedIn:",
                  isLoggedIn,
                  "user.isRegistered:",
                  user?.isRegistered,
                  "user?.isRegistered === true:",
                  user?.isRegistered === true
                ),
                (<RegisterPage />))
              )
            ) : (
              <LandingPage />
            )
          }
        />
        {/* Prikaz preostalih stranica ukoliko su korisnic prijavljeni*/}
        <Route
          path="/restaurant-info"
          element={
            isLoggedIn ? <RestaurantInfoPage /> : <Navigate to="/not-found" />
          }
        />
        <Route
          path="/join-group"
          element={
            isLoggedIn ? <JoinGroupPage /> : <Navigate to="/not-found" />
          }
        />
        <Route
          path="/select-category"
          element={
            isLoggedIn ? <SelectCategoryPage /> : <Navigate to="/not-found" />
          }
        />
        <Route
          path="/rate-products"
          element={
            isLoggedIn ? <RateProductsPage /> : <Navigate to="/not-found" />
          }
        />
        <Route
          path="/profile-page"
          element={
            isLoggedIn ? <MyProfilePage /> : <Navigate to="/not-found" />
          }
        />
        <Route path="/test" element={<MyProfilePage />} />
        {/* Prikaz stranice za nepostojecu rutu*/}
        <Route path="/not-found" element={<NotFoundPage />} />
        <Route path="*" element={<Navigate to="/not-found" />} />
      </Routes>
    </Router>
  );
}

export default App;
