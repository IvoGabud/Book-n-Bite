import React from "react";
import RoundedButton from "components/RoundedButton";

const ConfirmationDialog = ({ isOpen, message, onConfirm, onCancel }) => {
  if (!isOpen) return null;

  return (
    <div className="confirmation-dialog">
      <div className="dialog-content">
        <p>{message}</p>
        <div className="dialog-actions">
          <RoundedButton text="Potvrdi" onClick={onConfirm} />
          <RoundedButton text="Otkaži" onClick={onCancel} />
        </div>
      </div>
    </div>
  );
};

export default ConfirmationDialog;
