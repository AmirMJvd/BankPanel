package Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Deposit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDepositItemController {
    @FXML
    private Label Date;

    @FXML
    private Label DepositName;

    @FXML
    private Label DepositType;

    @FXML
    private Label Inventory;

    @FXML
    private Label depostNum;

    @FXML
    private Label shebaNum;

    private Deposit deposit;

    private EmployeeController EmployeeController;

    private Node rootNode;

    public void setItemNode(Node node) {
        this.rootNode = node;
    }

    public Node getItemNode() {
        return this.rootNode;
    }


    public void setData(Deposit deposit, EmployeeController employeeController) {
        this.deposit = deposit;
        this.EmployeeController = employeeController;
        DepositName.setText(deposit.getDepositName());
        depostNum.setText(deposit.getdepostNumber());
        Inventory.setText(deposit.getInventory());
        shebaNum.setText(deposit.getShebaNumer());
        DepositType.setText(deposit.getDepositType());
        Date.setText(deposit.getDepositDate());
    }

    @FXML
    void CloseDeposite(MouseEvent event) {
        String accountNum = depostNum.getText().trim(); // از TextField بگیر
        File file = new File("userID.txt");

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            List<String> updatedLines = new ArrayList<>();

            int indexToRemove = -1;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Account Number: " + accountNum)) {
                    indexToRemove = i - 1; // شروع حذف از خط قبل
                    break;
                }
            }

            if (indexToRemove != -1) {
                // خط مربوط به موجودی معمولاً 9 خط بعد از شروع هست
                String inventoryLine = lines.get(indexToRemove + 8);
                String inventoryText = inventoryLine.replace("inventory Price:", "").replace("ريال", "").trim();

                // حذف جداکننده‌های عددی مثل کاما و فاصله
                inventoryText = inventoryText.replace(",", "").replace(" ", "");

                long inventoryAmount = Long.parseLong(inventoryText);

                if (inventoryAmount > 0) {
                    // موجودی بیشتر از صفره، هشدار بده با نمایش مقدار
                    String formattedAmount = String.format("%,d", inventoryAmount); // جداکننده هزارگان اضافه کن
                    showAlert(
                            "خطا",
                            "حساب مورد نظر دارای موجودی می‌باشد و قابل حذف نیست.\n" +
                                    "مقدار موجودی: " + formattedAmount + " ریال",
                            Alert.AlertType.ERROR
                    );
                    return;
                }

                // در غیر اینصورت حذف کن
                for (int i = 0; i < lines.size(); i++) {
                    if (i < indexToRemove || i > indexToRemove + 10) {
                        updatedLines.add(lines.get(i));
                    }
                }

                Files.write(file.toPath(), updatedLines); // فایل رو بازنویسی کن
                showAlert("موفق", "حساب با موفقیت حذف شد.", Alert.AlertType.INFORMATION);
                if (this.EmployeeController != null) {
                    this.EmployeeController.removeItemFromGrid(this);  // حذف آیتم از گرید
                }

            } else {
                showAlert("خطا", "شماره حساب پیدا نشد.", Alert.AlertType.ERROR);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            showAlert("خطا", "مشکلی در پردازش اطلاعات رخ داد.", Alert.AlertType.ERROR);
        }

    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
