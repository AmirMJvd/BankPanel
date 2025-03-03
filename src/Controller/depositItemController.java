package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Deposit;
import model.User;

public class depositItemController {
    @FXML
    private Label DepositType;

    @FXML
    private Label Inventory;

    @FXML
    private Label depostNum;

    @FXML
    private Label shebaNum;

    private Deposit deposit;

    public void setData(Deposit deposit) {
        this.deposit = deposit;
        depostNum.setText(deposit.getdepostNumber());
        Inventory.setText(deposit.getInventory());
        shebaNum.setText(deposit.getShebaNumer());
        DepositType.setText(deposit.getDepositType());
    }
}
