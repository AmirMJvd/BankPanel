package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static Controller.transferItemController.*;

public class moreInformationController {

    @FXML
    private Label Amount;

    @FXML
    private Label Code;

    @FXML
    private Label Name;

    @FXML
    private Label cardNumber;

    @FXML
    private Label Date;

    @FXML
    private Label Time;

    String Type = Type123;

    @FXML
    private void initialize() {
        Date.setText(Date123);
        Time.setText(Time123);
        Type = Type123;

    }
}
