package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistrationController {

    @FXML
    private PasswordField PasswordRepet;

    @FXML
    private Button Registration;

    @FXML
    private TextField bDay;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phineNumber;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField userName;

    private String userID;

    @FXML
    private ImageView closeIcon;

    @FXML
    void closeApp(MouseEvent event) {
        Stage stage = (Stage) closeIcon.getScene().getWindow();
        stage.close();
    }

    // این متد برای دریافت userID از LoginController است
    public void setUserID(String userID) {
        this.userID = userID;
        // حالا می‌توانید از userID در هر متدی که نیاز دارید استفاده کنید.
    }

    @FXML
    void BackLogin(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void Registration(ActionEvent event) {
        String username = userName.getText().trim();
        String phone = phineNumber.getText().trim();
        String birthDate = bDay.getText().trim();
        String pass = password.getText().trim();
        String passRepeat = PasswordRepet.getText().trim();

        // بررسی اینکه هیچ فیلدی خالی نباشد
        if (username.isEmpty() || phone.isEmpty() || birthDate.isEmpty() || pass.isEmpty() || passRepeat.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "خطا", "تمامی فیلدها باید پر شوند!");
            return;
        }

        // بررسی مطابقت رمز عبور
        if (!pass.equals(passRepeat)) {
            showAlert(Alert.AlertType.ERROR, "خطا", "رمز عبور و تکرار آن مطابقت ندارند!");
            return;
        }

        // بررسی اینکه نام کاربری از قبل وجود نداشته باشد
        if (isUsernameExists(username)) {
            showAlert(Alert.AlertType.ERROR, "خطا", "این نام کاربری قبلاً ثبت شده است!");
            return;
        }

        // ذخیره اطلاعات در فایل
        saveUserData(username, pass, phone, birthDate);
        showAlert(Alert.AlertType.INFORMATION, "موفقیت", "ثبت‌نام با موفقیت انجام شد!");
        clearFields();
    }

    private boolean isUsernameExists(String username) {
        File file = new File("users.txt");
        if (!file.exists()) return false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String existingUsername = scanner.nextLine().trim();
                if (existingUsername.equals(username)) {
                    return true;  // نام کاربری یافت شد
                }
                // رد شدن از سطرهای دیگر (رمز عبور، شماره موبایل، تاریخ تولد، نوع کاربر)
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveUserData(String username, String password, String phone, String birthDate) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {

            writer.write(username + "\n");
            writer.write(password + "\n");
            writer.write(userID + "\n");
            writer.write(phone + "\n");
            writer.write(birthDate + "\n");
            writer.write("کاربر\n"); // سطر پنجم مشخص‌کننده نوع کاربر
            writer.flush();
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

    private void clearFields() {
        userName.clear();
        phineNumber.clear();
        bDay.clear();
        password.clear();
        PasswordRepet.clear();
    }

    @FXML
    void Reset(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/forgetfulness.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
