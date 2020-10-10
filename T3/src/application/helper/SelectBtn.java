package application.helper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SelectBtn extends Button {
    /**
     * Input QuestionModel and auto generates button
     * 
     * @param question
     */
    public SelectBtn(String select) {
        super(select);
        // make width fill space
        setMaxWidth(Double.MAX_VALUE);
        // Set Font
        setStyle("-fx-font-size:18");

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) getScene().getWindow();
                stage.close();
            }
        });
    }
}
