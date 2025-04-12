package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Card;
import model.SharedData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCardItemController {
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

    @FXML
    private Label Block;

    @FXML
    private ImageView BlockImg;

    @FXML
    private Label BlockLbl;

    @FXML
    private ImageView changePasswordImg;

    @FXML
    private Label changePasswordLbl;

    private Card card;

    private EmployeeController EmployeeController;




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

    @FXML
    public void initialize() {
        Platform.runLater(() -> {

                if (CardNum.getText().equals("کارت مسدود شده است !")) {
                    BlockLbl.setText("رفع مسدودیت");
                }


        });
    }




    @FXML
    void openCardBlocking(MouseEvent event) throws IOException {
        if(BlockLbl.getText().equals("رفع مسدودیت")){
            String fileName = "userID.txt";
            List<String> lines = new ArrayList<>();

            try {
                // خواندن تمام خطوط فایل
                lines = Files.readAllLines(Paths.get(fileName));

                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).trim().equals("Account Number: " + DepositNum.getText())) {
                        if (i + 2 < lines.size()) {
                            String nextLine = lines.get(i + 2);
                            // حذف اولین # در ابتدای خط
                            if (nextLine.trim().startsWith("Card Number: #")) {
                                nextLine = nextLine.replaceFirst("#", "").trim();
                                lines.set(i + 2, nextLine); // جایگزینی خط بعدی با نسخه بدون #
                            }
                        }
                        break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                    }
                }

                // بازنویسی فایل با مقادیر جدید
                Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

                // به‌روزرسانی داده‌ها از طریق کنترلر موجود (استفاده از Platform.runLater)
                if (EmployeeController != null) {
                    Platform.runLater(() -> EmployeeController.LoadUser1());
                }

                // نمایش پیغام موفقیت
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("موفقیت");
                alert.setHeaderText(null);
                alert.setContentText("کارت با موفقیت رفع مسدودیت شد!");
                alert.showAndWait();

                // بستن پنجره
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();

                // بستن همه استیج‌های باز
                for (Stage s : Stage.getWindows().filtered(window -> window instanceof Stage).toArray(Stage[]::new)) {
                    s.close();
                }

                // بارگذاری فایل FXML صفحه جدید
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Employee.fxml"));
                AnchorPane pane = loader.load();


                // ساخت یک صحنه جدید با ابعاد دلخواه
                Scene scene = new Scene(pane, 1315, 810);  // ابعاد دلخواه

                Stage stage1 = new Stage();
                stage1.setTitle("Bank");
                stage1.setScene(scene);

                // نمایش پنجره
                stage1.show();

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطا");
                alert.setHeaderText(null);
                alert.setContentText("خطایی دررفع مسدود کردن کارت رخ داد:\n" + e.getMessage());
                alert.showAndWait();
            }
        }else{
            String fileName = "userID.txt";
            List<String> lines = new ArrayList<>();

            try {
                // خواندن تمام خطوط فایل
                lines = Files.readAllLines(Paths.get(fileName));

                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).trim().equals("Card Number: " + CardNum.getText())) {
                        lines.set(i, "Card Number: " + "#" +CardNum.getText() );
                        break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                    }
                }

                // بازنویسی فایل با مقادیر جدید
                Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

                // به‌روزرسانی داده‌ها از طریق کنترلر موجود (استفاده از Platform.runLater)
                if (EmployeeController != null) {
                    Platform.runLater(() -> EmployeeController.LoadUser1());
                }

                // نمایش پیغام موفقیت
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("موفقیت");
                alert.setHeaderText(null);
                alert.setContentText("کارت با موفقیت مسدود شد!");
                alert.showAndWait();

                // بستن پنجره
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();

                // بستن همه استیج‌های باز
                for (Stage s : Stage.getWindows().filtered(window -> window instanceof Stage).toArray(Stage[]::new)) {
                    s.close();
                }

                // بارگذاری فایل FXML صفحه جدید
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Employee.fxml"));
                AnchorPane pane = loader.load();


                // ساخت یک صحنه جدید با ابعاد دلخواه
                Scene scene = new Scene(pane, 1315, 810);  // ابعاد دلخواه

                Stage stage1 = new Stage();
                stage1.setTitle("Bank");
                stage1.setScene(scene);

                // نمایش پنجره
                stage1.show();

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطا");
                alert.setHeaderText(null);
                alert.setContentText("خطایی در مسدود کردن کارت رخ داد:\n" + e.getMessage());
                alert.showAndWait();
            }
        }


    }


    @FXML
    void changePassword(MouseEvent event) throws IOException {
        // بارگذاری فایل FXML صفحه جدید
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/changePassword.fxml"));
        AnchorPane pane = loader.load();

        // ساخت یک صحنه جدید با ابعاد دلخواه
        Scene scene = new Scene(pane, 310, 450);  // ابعاد دلخواه


        changePasswordController.setCardNumber1(CardNum.getText());
        changePasswordController.setExpireDate(year.getText()+ '/' +month.getText());

        // ساخت یک Stage جدید
        Stage stage = new Stage();
        stage.setTitle("صفحه تغییر رمز اول");
        stage.setScene(scene);

        // حذف دکمه‌های کنترل (بستن، کوچک کردن، حداکثر کردن)
        stage.initStyle(StageStyle.UNDECORATED);

        // نمایش پنجره
        stage.show();
    }

    private final SecureRandom random = new SecureRandom();

    private String generateRandomNumber(int length) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(10)); // عدد تصادفی بین 0 تا 9
        }
        return number.toString();
    }


    @FXML
    void openNewCard(MouseEvent event) {
        String fileName = "userID.txt";
        List<String> lines = new ArrayList<>();

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Account Number: " + DepositNum.getText())) {
                    lines.set(i+1, "Shaba Number: " + "IR" + generateRandomNumber(24));
                    lines.set(i+2, "Card Number: "  + "63934610" + generateRandomNumber(8));
                    lines.set(i+3, "Card Password: " + generateRandomNumber(4));
                    lines.set(i+5, "CVV2 Number: " + generateRandomNumber(3));
                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                }
            }

            // بازنویسی فایل با مقادیر جدید
            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // به‌روزرسانی داده‌ها از طریق کنترلر موجود (استفاده از Platform.runLater)
            if (EmployeeController != null) {
                Platform.runLater(() -> EmployeeController.LoadUser1());
            }

            // نمایش پیغام موفقیت
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("موفقیت");
            alert.setHeaderText(null);
            alert.setContentText("کارت با موفقیت صادر شد!");
            alert.showAndWait();

            // بستن پنجره
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            // بستن همه استیج‌های باز
            for (Stage s : Stage.getWindows().filtered(window -> window instanceof Stage).toArray(Stage[]::new)) {
                s.close();
            }

            // بارگذاری فایل FXML صفحه جدید
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Employee.fxml"));
            AnchorPane pane = loader.load();


            // ساخت یک صحنه جدید با ابعاد دلخواه
            Scene scene = new Scene(pane, 1315, 810);  // ابعاد دلخواه

            Stage stage1 = new Stage();
            stage1.setTitle("Bank");
            stage1.setScene(scene);

            // نمایش پنجره
            stage1.show();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطا");
            alert.setHeaderText(null);
            alert.setContentText("خطایی در صادر کردن کارت جدید رخ داد:\n" + e.getMessage());
            alert.showAndWait();
        }
    }
}
