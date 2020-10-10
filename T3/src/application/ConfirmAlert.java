package application;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public abstract class ConfirmAlert extends Alert {
    /**
     * Create ConfirmAlert that displays a window to confirm.
     * 
     * @param text
     */
    public ConfirmAlert(final String text) {
        super(AlertType.CONFIRMATION);
        setTitle("Aroha Explore");
        setHeaderText(text);
        setContentText("Are you ok with this?");
        // Show Alert
        Optional<ButtonType> result = showAndWait();
        if (result.get() == ButtonType.OK) {
            handleConfirm();
        }
    }

    /**
     * Runs when Alert is confirmed
     */
    protected abstract void handleConfirm();
}
