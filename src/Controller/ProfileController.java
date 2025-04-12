package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class ProfileController implements Initializable {

    @FXML
    private Label profileName;

    String username ;

    String password ;

    public void setUsername(String username) {
        this.username = username;
        profileName.setText(username);
        name = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profileName.setText(username);
    }

    public void changeUsername(MouseEvent actionEvent) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/changeUserName.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            ChangeUserNameControlle controller = fxmlLoader.getController();
            controller.setUsername(username);
            stage.setScene(scene);
            stage.setTitle("تغیر نام کاربری");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePassword(MouseEvent actionEvent) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/ChangePasswordProfile.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            ChangePasswordProfileController controller = fxmlLoader.getController();
            controller.setPassword(password);
            controller.setUsername(username);
            stage.setScene(scene);
            stage.setTitle("تغیر رمز عبور");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void outLogin(MouseEvent actionEvent) {
        Stage stage = (Stage) profileName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/login.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Bank");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void userPage(MouseEvent actionEvent) {
        Stage stage = (Stage) profileName.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/userpage.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            UserPageController  controller = fxmlLoader.getController();
            controller.setId(name);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
