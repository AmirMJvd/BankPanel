package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static final String CURRENCY = "  ريال";

    @Override
    public void start(Stage primaryStage) throws Exception {
        // لود فایل FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/login.fxml"));
        Parent root = loader.load();

        // تنظیمات صحنه
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

//        // حذف دکمه‌های کنترل پنجره (ضربدر و غیره)
//        primaryStage.initStyle(StageStyle.UNDECORATED);

        // نمایش
        primaryStage.setTitle("ورود به سامانه");
        primaryStage.show();

//        // تنظیم ابعاد پنجره
//        primaryStage.setWidth(850);
//        primaryStage.setHeight(650);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
