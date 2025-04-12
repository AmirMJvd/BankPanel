package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.CheckHistoryItem;

public class CheckhistoryItemController {
    @FXML
    private Label Date;

    @FXML
    private Label Time;

    @FXML
    private Label Type;

    @FXML
    private Label codeLabel;

    @FXML
    private Label statusLabel;


    public void setData(CheckHistoryItem item) {
        Date.setText(item.getDate());
        Time.setText(item.getTime());
        Type.setText(item.getType());
        codeLabel.setText(item.getCode());
        statusLabel.setText(item.getStatus());  // اضافه کردن statusLabel
    }
}
