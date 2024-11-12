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
import RegisterPage from "screens/RegisterPage";
import SelectCategoryPage from "screens/SelectCategoryPage";
import MyProfilePage from "screens/MyProfilePage";
import RateProductsPage from "screens/RateProductsPage";
import WaitingPage from "screens/WaitingPage";

function App() {

  return (<RateProductsPage />)

}
export default App;
