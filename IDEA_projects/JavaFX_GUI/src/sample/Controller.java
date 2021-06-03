package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

import java.awt.*;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    private RadioButton radioOne;

    @FXML
    private TextArea textfield1;

    @FXML           // эта аннотация позволяет обращаться к приватным полям (просто так работает этот фреймворк)
    private ComboBox<String> combo;

    @FXML
    public void initialize() { // именно такое название метода - позволяет предобработать коды начальных значений полей компонентов
        combo.getItems().addAll("Option A", "Option B", "Option C");
        combo.getSelectionModel().select("Option B");
    }

    public void startButtonFire() {
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startButton.setText("Pressed");
            }
        });
    }

    public void startRadioOne() {
        radioOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textfield1.setText("radio 1 triggered");
            }
        });
    }

}
