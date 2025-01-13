import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";

const ReviewersListPage = () => {
  const [reviewers, setReviewers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchReviewers = async () => {
      try {
        const response = await fetch("get-reviewers");
        if (!response.ok) {
          throw new Error(`Greška: ${response.statusText}`);
        }
        const data = await response.json();
        setReviewers(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchReviewers();
  }, []);

  return (
    <div className="reviewer-list-page">
      <TopBarNoUser />
      <div
        className="bg-image"
        style={{ backgroundImage: `url(${bgImage})` }}
      />
      <div className="content-container">
        <h1 className="page-title">LISTA OCJENJIVAČA</h1>
        {loading && <p>Učitavanje...</p>}
        {error && <p className="error">{error}</p>}
        <div className="reviewer-list">
          {!loading &&
            !error &&
            reviewers.map((reviewer, index) => (
              <div className="reviewer-row" key={index}>
                <div className="reviewer-name">{reviewer.korisnickoIme}</div>
                <div className="actions">
                  <RoundedButton text={"Blokiraj račun"} />
                  <RoundedButton text="Obriši račun" color="maroon" />
                </div>
              </div>
            ))}
        </div>
      </div>
    </div>
  );
};

export default ReviewersListPage;
