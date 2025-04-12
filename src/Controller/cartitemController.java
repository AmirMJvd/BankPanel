package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Card;

import java.io.IOException;

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

    private UserPageController userPageController;

    // تابع برای تنظیم کنترلر UserPageController
    public void setUserPageController(UserPageController controller) {
        this.userPageController = controller;
    }

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
                Block.setVisible(false);
                BlockLbl.setVisible(false);
                BlockImg.setVisible(false);
                changePasswordImg.setVisible(false);
                changePasswordLbl.setVisible(false);
            }
        });
    }




    @FXML
    void openCardBlocking(MouseEvent event) throws IOException {
        if(!(CardNum.getText().equals("کارت مسدود شده است !"))){
            // بارگذاری فایل FXML صفحه جدید
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/CardBlocking.fxml"));
            AnchorPane pane = loader.load();

            // ساخت یک صحنه جدید با ابعاد دلخواه
            Scene scene = new Scene(pane, 550, 250);  // ابعاد دلخواه


            CardBlockingController.setCardNumber(CardNum.getText());

            // ساخت یک Stage جدید
            Stage stage = new Stage();
            stage.setTitle("صفحه ثبت‌نام");
            stage.setScene(scene);

            // حذف دکمه‌های کنترل (بستن، کوچک کردن، حداکثر کردن)
            stage.initStyle(StageStyle.UNDECORATED);

            // نمایش پنجره
            stage.show();
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


}
