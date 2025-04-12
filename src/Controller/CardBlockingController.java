package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.SharedData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardBlockingController {


    private UserPageController userPageController;

    private static String cardNumber;

    public static void setCardNumber(String cardNum) {
        cardNumber = cardNum;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setUserPageController(UserPageController controller) {
        this.userPageController = controller;
    }


    @FXML
    void Block(ActionEvent event) {
        String fileName = "userID.txt";
        List<String> lines = new ArrayList<>();

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Card Number: " + cardNumber)) {
                    lines.set(i, "Card Number: " + "#" + cardNumber);
                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                }
            }

            // بازنویسی فایل با مقادیر جدید
            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            // به‌روزرسانی داده‌ها از طریق کنترلر موجود (استفاده از Platform.runLater)
            if (userPageController != null) {
                Platform.runLater(() -> userPageController.LoadUser1());
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/userpage.fxml"));
            BorderPane pane = loader.load();


            // ساخت یک صحنه جدید با ابعاد دلخواه
            Scene scene = new Scene(pane, 1315, 810);  // ابعاد دلخواه


            // گرفتن کنترلر صفحه جدید
            UserPageController userPageController = loader.getController();

            // گرفتن نام کاربری از SharedData
            String username = SharedData.getInstance().getUsername();
            userPageController.setId(username);


            // ساخت یک Stage جدید
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


    @FXML
    void Close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }


}
