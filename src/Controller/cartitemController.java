package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Card;

public class cartitemController {

    @FXML
    private Label CardNum;

    @FXML
    private Label DepositNum;

    @FXML
    private Label ShebaNum;

    @FXML
    private Label month;

    @FXML
    private Label year;

    @FXML
    private Label inventory;

    @FXML
    private Button ReceiveInventory;

    private Card card;

    public void setData(Card card) {
        this.card = card;
        CardNum.setText(card.getCardNum());
        DepositNum.setText(card.getDepositNum());
        ShebaNum.setText(card.getShebaNum());
        year.setText(card.getyear());
        month.setText(card.getMonth());
        inventory.setText(card.getInventory());
    }

    @FXML
    void ReceiveInventory(ActionEvent event) {
        inventory.setVisible(true);
        ReceiveInventory.setVisible(false);
    }


}
