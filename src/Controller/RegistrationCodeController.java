package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationCodeController {

    @FXML
    private PasswordField CardNumber;

    @FXML
    private TextField Code;

    @FXML
    private AnchorPane rootPane;

    @FXML
    void BackLogin(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void Login(ActionEvent event) {
        String nationalCode = Code.getText();  // گرفتن کد ملی از فیلد

        // دریافت User ID بر اساس کد ملی
        String userID = getUserID(nationalCode);

        if (userID != null) {
            // حالا باید شماره کارت را با Account Number مقایسه کنیم
            boolean cardMatch = checkCardNumber(userID);

            if (cardMatch) {
                // باز کردن صفحه Registration در صورت تطابق
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Registration.fxml"));
                    AnchorPane pane = loader.load();

                    // دسترسی به کنترلر Registration و ارسال userID
                    RegistrationController registrationController = loader.getController();
                    registrationController.setUserID(userID);  // ارسال userID به کنترلر Registration

                    ManagerController managerController = loader.getController();
                    managerController.setUserID(userID);

                    rootPane.getChildren().setAll(pane);  // نمایش صفحه جدید
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Card Number Error", "Card Number does not match.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "National Code Error", "User ID not found or National Code is incorrect.");
        }
    }

    private String getUserID(String nationalCode) {
        try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            List<String> lines = new ArrayList<>();  // برای ذخیره‌ی همه خطوط
            String userID = null;
            boolean nationalCodeFound = false;

            while ((line = br.readLine()) != null) {
                lines.add(line);  // ذخیره کردن هر خط در لیست
            }

            // حالا می‌خواهیم از آخرین خطوط به عقب برگردیم
            for (int i = 0; i < lines.size(); i++) {
                String currentLine = lines.get(i);

                if (currentLine.startsWith("National Code: " + nationalCode)) {
                    nationalCodeFound = true;

                    // اگر کد ملی پیدا شد، به خط قبلی (User ID) نگاه می‌کنیم
                    if (i > 0) {  // اطمینان از اینکه حداقل یک خط قبلی داریم
                        String previousLine = lines.get(i - 3);// خط قبلی
                        if (previousLine.startsWith("User ID: ")) {
                            String[] parts = previousLine.split(": ");
                            if (parts.length > 1) {
                                userID = parts[1].trim();  // گرفتن User ID
                            } else {
                                showAlert(Alert.AlertType.ERROR, "National Code Error", "User ID format is incorrect.");
                            }
                        }
                    }
                    break;
                }
            }

            if (!nationalCodeFound) {
                System.out.println("National Code not found.");
                showAlert(Alert.AlertType.ERROR, "National Code Error", "National Code not found.");
            }

            return userID;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean checkCardNumber(String userID) {
        try (BufferedReader br = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            boolean matchFound = false;  // برای بررسی اینکه آیا شماره کارت تطابق دارد یا خیر
            while ((line = br.readLine()) != null) {
                if (line.startsWith("User ID: " + userID)) {
                    // پیدا کردن خط مربوط به این User ID
                    String cardNumberLine = br.readLine(); // این باید حاوی Account Number باشد
                    if (cardNumberLine != null && cardNumberLine.contains("Account Number: ")) {
                        String[] parts = cardNumberLine.split(": ");
                        if (parts.length > 1) {
                            String accountNumber = parts[1].trim(); // شماره حساب را از خط جدا می‌کنیم
                            // حالا می‌توانیم شماره حساب را با شماره کارت مقایسه کنیم
                            if (accountNumber.equals(CardNumber.getText())) {
                                matchFound = true;
                                break;
                            } else {
                                showAlert(Alert.AlertType.ERROR, "Card Number Error", "Card Number does not match.");
                            }
                        }
                    }
                }
            }
            return matchFound;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // متد برای نمایش پیغام Alert
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
