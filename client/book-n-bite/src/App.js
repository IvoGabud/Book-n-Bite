import logo from "./logo.svg";
import "./App.css";
import { GoogleLogin } from "@react-oauth/google";
import { jwtDecode } from "jwt-decode";
import { useState } from "react";

function App() {
  const [username, setUsername] = useState(null);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Book 'n Bite</h1>
        <GoogleLogin
          onSuccess={(credentialResponse) => {
            const decoded = jwtDecode(credentialResponse?.credential);
            console.log(decoded);
            setUsername(decoded.name);
          }}
          onError={() => {
            console.log("Login Failed");
          }}
        />
        {username && <p>Logged in as, {username}!</p>}
      </header>
    </div>
  );
}

export default App;
