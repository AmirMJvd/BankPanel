package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.SharedData;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {
    @FXML
    private PasswordField password;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField userName;

    @FXML
    public void initialize() {
        userName.setOnAction(event -> password.requestFocus());
        password.setOnAction(event -> Login(new ActionEvent()));
    }

    @FXML
    void LodRegister(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/RegistrationCode.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void Login (ActionEvent event) {
        String username = userName.getText().trim();
        String pass = password.getText().trim();

        if (username.isEmpty() || pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "خطا", "نام کاربری و رمز عبور نمی‌توانند خالی باشند!");
            return;
        }

        String role = validateLogin(username, pass);

        if (role != null) {
            SharedData.getInstance().setUsername(username); // ذخیره نام کاربری در SharedData
            createUserFile(username); // ایجاد فایل متنی برای نام کاربری
            showAlert(Alert.AlertType.INFORMATION, "موفقیت", "ورود با موفقیت انجام شد!");
            closeLoginWindow(); // بستن پنجره ورود


            if (role.equals("کاربر")) {
                openPage("../views/userpage.fxml", "Bank", username);
            } else if (role.equals("مدیر")) {
                openPage("../views/Manager.fxml", "Manager Panel", username);
            } else if (role.equals("کارمند")){
                openPage("../views/Employee.fxml", "Employee Panel", username);
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "خطا", "نام کاربری یا رمز عبور اشتباه است!");
        }
    }

    private String validateLogin(String username, String password) {
        File file = new File("users.txt");
        if (!file.exists()) return null;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String existingUsername = scanner.nextLine().trim();
                String existingPassword = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
                scanner.nextLine(); // خط سوم (ایدی)
                scanner.nextLine(); // خط چهارم (تلفن)
                scanner.nextLine(); // خط پنجم (ایمیل)
                String role = scanner.hasNextLine() ? scanner.nextLine().trim() : ""; // خط پنجم (نقش)

                if (existingUsername.equals(username) && existingPassword.equals(password)) {
                    return role; // نقش کاربر را برمی‌گرداند (کاربر / مدیر)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createUserFile(String username) {
        File userFile = new File(username + ".txt");
        try {
            if (userFile.createNewFile()) {
                System.out.println("فایل " + username + ".txt" + " ایجاد شد.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeLoginWindow() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        if (stage != null) {
            stage.close();
        }
    }

    private void openPage(String fxmlPath, String title, String username) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            BorderPane pane = loader.load();
//
            // تنظیم نام کاربری در کنترلر
            if (title.equals("Bank")) {
                UserPageController  controller = loader.getController();
                controller.setId(username);
            }
//              UserPageController  controller = loader.getController();
//                controller.setId(username);
//            }
//            } else if (title.equals("Admin Panel")) {
//                admin1Controller controller = loader.getController();
//                controller.setId(username);
//            }

            Scene scene = new Scene(pane, 1315, 810);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setTitle(title);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void Reset(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/forgetfulness.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
