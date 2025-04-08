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

    @FXML
    private Label Date;

    @FXML
    private Label DepositName;

    private Deposit deposit;

    public void setData(Deposit deposit) {
        this.deposit = deposit;
        DepositName.setText(deposit.getDepositName());
        depostNum.setText(deposit.getdepostNumber());
        Inventory.setText(deposit.getInventory());
        shebaNum.setText(deposit.getShebaNumer());
        DepositType.setText(deposit.getDepositType());
        Date.setText(deposit.getDepositDate());
    }

}
