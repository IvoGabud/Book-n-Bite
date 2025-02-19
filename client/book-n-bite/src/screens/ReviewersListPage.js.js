import { useState, useEffect } from "react";
import TopBarNoUser from "components/TopBarNoUser";
import bgImage from "assets/images/welcomeBack.png";
import RoundedButton from "components/RoundedButton";
import ConfirmationDialog from "components/ConfirmationDialog";
import TopBarBack from "components/TopBarBack";
import { useNavigate } from "react-router-dom"; // Import useNavigate

const ReviewersListPage = () => {
  const [reviewers, setReviewers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [showDialog, setShowDialog] = useState(false);
  const [reviewerToDelete, setReviewerToDelete] = useState(null);
  const [reviewerToBlock, setReviewerToBlock] = useState(null); // Track reviewer to block/unblock
  const navigate = useNavigate(); // Initialize navigate

  const fetchReviewers = async () => {
    setLoading(true);
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

  useEffect(() => {
    fetchReviewers();
  }, []);

  const handleDelete = (korisnikId) => {
    setReviewerToDelete(korisnikId);
    setShowDialog(true);
  };

  const confirmDelete = async () => {
    try {
      const response = await fetch(`delete-account/${reviewerToDelete}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error(`Greška: ${response.statusText}`);
      }
      const data = await response.text();
      alert(data);
      setShowDialog(false);
      fetchReviewers();
    } catch (err) {
      alert(`Došlo je do greške: ${err.message}`);
      setShowDialog(false);
    }
  };

  const cancelDelete = () => {
    setShowDialog(false);
  };

  const handleBlock = async (korisnikId, isBlocked) => {
    const action = isBlocked ? "odblokirati" : "blokirati";
    if (window.confirm(`Jeste li sigurni da želite ${action} korisnika?`)) {
      try {
        const response = await fetch(`/block/${korisnikId}`, {
          method: "POST",
        });
        if (!response.ok) {
          throw new Error(`Greška: ${response.statusText}`);
        }
        fetchReviewers();
      } catch (err) {
        alert(`Došlo je do greške: ${err.message}`);
      }
    }
  };

  const handleNavigateToProfile = (korisnikId) => {
    navigate(`/profile?id=${korisnikId}`);
  };

  return (
    <div className="reviewer-list-page">
      <TopBarBack />
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
                  <RoundedButton
                    text={
                      reviewer.blokiran ? "Odblokiraj račun" : "Blokiraj račun"
                    }
                    onClick={() =>
                      handleBlock(reviewer.korisnikId, reviewer.blokiran)
                    }
                  />
                  <RoundedButton
                    text="Obriši račun"
                    color="maroon"
                    onClick={() => handleDelete(reviewer.korisnikId)}
                  />
                  {/* Button to view profile */}
                  <RoundedButton
                    text="Pogledaj profil"
                    onClick={() => handleNavigateToProfile(reviewer.korisnikId)} // Navigate to profile
                  />
                </div>
              </div>
            ))}
        </div>
      </div>

      <ConfirmationDialog
        isOpen={showDialog}
        message="Jeste li sigurni da želite obrisati korisnika?"
        onConfirm={confirmDelete}
        onCancel={cancelDelete}
      />
    </div>
  );
};

export default ReviewersListPage;
