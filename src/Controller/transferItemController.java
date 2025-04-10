package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Transfer;

import java.io.IOException;

public class transferItemController {
    @FXML
    private Label Type;

    @FXML
    private Label transferAmount;

    @FXML
    private Label transferDate;

    @FXML
    private Label transferTime;

    private Transfer transfer;

    public static String Date123;
    public static String Time123;
    public static String Type123;


    public void setData(Transfer transfer){
        this.transfer=transfer;
        Type.setText(transfer.getType());
        transferAmount.setText(transfer.getAmount());
        transferDate.setText(transfer.getDate());
        transferTime.setText(transfer.getTime());
    }

    @FXML
    void openMoreInformation(MouseEvent event) throws IOException {
        Date123 = transferDate.getText();
        Time123 = transferTime.getText();
        Type123 = Type.getText();

        System.out.println(Type123);

        if(Type123.startsWith(" پرداخت قبض ")||Type123.startsWith(" شارژ تلفن همراه ")||Type123.startsWith("برداشت وجه")||
                Type123.startsWith("واریز وجه")){
            // بارگذاری فایل FXML صفحه جدید
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/moreInformation.fxml"));
            AnchorPane pane = loader.load();

            // ساخت یک صحنه جدید با ابعاد دلخواه
            Scene scene = new Scene(pane, 546, 230);  // ابعاد دلخواه


            // ساخت یک Stage جدید
            Stage stage = new Stage();
            stage.setTitle("جزئیات");
            stage.setScene(scene);


            // نمایش پنجره
            stage.show();
        }else {
            // بارگذاری فایل FXML صفحه جدید
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/TranslationMoreInformation.fxml"));
            AnchorPane pane = loader.load();

            // ساخت یک صحنه جدید با ابعاد دلخواه
            Scene scene = new Scene(pane, 535, 300);  // ابعاد دلخواه


            // ساخت یک Stage جدید
            Stage stage = new Stage();
            stage.setTitle("جزئیات");
            stage.setScene(scene);


            // نمایش پنجره
            stage.show();
        }


    }


}
