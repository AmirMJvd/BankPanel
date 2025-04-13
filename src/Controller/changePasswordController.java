package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class changePasswordController {

    @FXML
    private TextField CVV2;

    @FXML
    private Label Date;

    @FXML
    private TextField Passwoed1;

    @FXML
    private TextField Password2;

    @FXML
    private Label cardNumber;

    private static String CardNumber1;

    private static String ExpireDate;

    public String getExpireDate() {
        return ExpireDate;
    }

    public static void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public static void setCardNumber1(String cardNum) {
        CardNumber1 = cardNum;
    }

    public String getCardNumber1() {
        return CardNumber1;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            cardNumber.setText(CardNumber1);
            Date.setText(ExpireDate);
        });

    }


    @FXML
    void Change(ActionEvent event) throws FileNotFoundException {

        String password1 = Passwoed1.getText();
        String password2 = Password2.getText();

        // بررسی اینکه رمز ۴ رقمی و فقط شامل اعداد باشد
        if (!password1.matches("\\d{4}")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطا");
            alert.setHeaderText(null);
            alert.setContentText("رمز عبور باید دقیقاً ۴ رقم و فقط شامل اعداد باشد!");
            alert.showAndWait();
            return;
        }

        if (Passwoed1.getText().equals(Password2.getText())) {

            String fileName = "userID.txt";
            List<String> lines = new ArrayList<>();

            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                String line = (scanner.nextLine());
                if(line.startsWith("Card Number: " + CardNumber1)){
                    scanner.nextLine();
                    scanner.nextLine();
                    if(scanner.nextLine().equals("CVV2 Number: " + CVV2.getText())){
                        try {
                            // خواندن تمام خطوط فایل
                            lines = Files.readAllLines(Paths.get(fileName));
                            boolean flag = false;

                            for (int i = 0; i < lines.size(); i++) {
                                if (lines.get(i).trim().equals("Card Number: " + CardNumber1)) {
                                    flag = true;
                                    i++;
                                    lines.set(i, "Card Password: " + Passwoed1.getText());
                                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                                }
                            }
                            if (!flag) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("شماره کارت یافت نشد!");
                                alert.showAndWait();
                            }

                            // بازنویسی فایل با مقادیر جدید
                            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

                            // نمایش پیغام موفقیت
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("موفقیت");
                            alert.setHeaderText(null);
                            alert.setContentText("رمز اول کارت با موفقیت تغییر یافت!");
                            alert.showAndWait();

                            // بستن پنجره
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("شماره CVV2 با CVV2 کارت یکسان نیست!");
                        alert.showAndWait();
                    }
                }
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("خطا");
            alert.setHeaderText(null);
            alert.setContentText("تکرار رمز جدید با رمز قبلی یکسان نیست!");
            alert.showAndWait();
        }
    }

    @FXML
    void Close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
}
