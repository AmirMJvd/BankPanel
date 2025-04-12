package Controller;

import com.sun.javafx.scene.control.inputmap.InputMap;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.FileHandlingForUser;
import model.User;
import model.UsersOnline;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangePasswordController implements Initializable {
    @FXML
    private PasswordField oldPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField old;

    @FXML
    private TextField news;

    @FXML
    private TextField confirm;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        flag1 = true;
//        flag2 = true;
//        flag3 = true;
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private boolean flag1 = true;
    private boolean flag2 = true;
    private boolean flag3 = true;

    String name1;
    String name2;
    String name3;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    public void clickImage1(MouseEvent mouseEvent) {
        if (flag1){
            name1 = oldPassword.getText();
            oldPassword.setVisible(false);
            old.setVisible(true);
            old.setText(name1);
        }
        else {
            oldPassword.setVisible(true);
            old.setVisible(false);
            name1 = old.getText();
            oldPassword.setText(name1);
        }
        flag1 = !flag1;
        animation(1);
    }

    public void clickImage2(MouseEvent mouseEvent) {
        if (flag2){
            name2 = newPassword.getText();
            newPassword.setVisible(false);
            news.setVisible(true);
            news.setText(name2);
        }
        else {
            name2 = news.getText();
            news.setVisible(false);
            newPassword.setVisible(true);
            newPassword.setText(name2);
        }
        flag2 = !flag2;
        animation(2);
    }

    public void clickImage3(MouseEvent mouseEvent) {
        if (flag3){
            name3 = confirmPassword.getText();
            confirmPassword.setVisible(false);
            confirm.setVisible(true);
            confirm.setText(name3);
        }
        else {
            name3 = confirm.getText();
            confirmPassword.setVisible(true);
            confirm.setVisible(false);
            confirmPassword.setText(name1);
        }
        flag3 = !flag3;
        animation(3);
    }

    @FXML
    private javafx.scene.image.ImageView image1;

    @FXML
    private javafx.scene.image.ImageView image2;

    @FXML
    private javafx.scene.image.ImageView image3;

    @FXML
    private javafx.scene.image.ImageView image4;

    @FXML
    private javafx.scene.image.ImageView image5;

    @FXML
    private javafx.scene.image.ImageView image6;

    Timeline timelineanimation1 = new Timeline(new KeyFrame(Duration.seconds(1.23),a -> {
        image1.setVisible(true);
        image4.setVisible(false);
        stopTimeLine(1);
    }));

    Timeline timelineanimation2 = new Timeline(new KeyFrame(Duration.seconds(1.23),a -> {
        image2.setVisible(true);
        image5.setVisible(false);
        stopTimeLine(2);
    }));

    Timeline timelineanimation3 = new Timeline(new KeyFrame(Duration.seconds(1.23),a -> {
        image3.setVisible(true);
        image6.setVisible(false);
        stopTimeLine(3);
    }));

    public void animation(int number){
        if (number == 1){
            image1.setVisible(false);
            image4.setVisible(true);
            timelineanimation1.setCycleCount(Timeline.INDEFINITE);
            timelineanimation1.play();
        }
        else if (number == 2){
            image2.setVisible(false);
            image5.setVisible(true);
            timelineanimation2.setCycleCount(Timeline.INDEFINITE);
            timelineanimation2.play();
        }
        else {
            image3.setVisible(false);
            image6.setVisible(true);
            timelineanimation3.setCycleCount(Timeline.INDEFINITE);
            timelineanimation3.play();
        }
    }

    public void stopTimeLine(int number){
        if (number == 1){
            timelineanimation1.stop();
        }
        else if (number == 2){
            timelineanimation2.stop();
        }
        else{
            timelineanimation3.stop();
        }
    }

    boolean flagOldPassword = false;
    boolean flagNewPassword = false;
    boolean flagConfirmPassword = false;

    String password ;

    public void setPassword(String password) {
        this.password = password;
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5) , mani ->
    {
        if (flag1){
            name1 = oldPassword.getText();;
            if (!name1.isEmpty()){
                label4.setVisible(false);
                label1.setVisible(true);
                if (name1.equals(password)){
                    flagOldPassword = true;
                    label1.setStyle("-fx-text-fill: #028525");
                    label1.setText("رمز وارد شده با رمز فعلی شما مطابقت دارد.");
                }
                else {
                    label1.setStyle("-fx-text-fill: #a90000;");
                    flagOldPassword = false;
                    label1.setText("رمز وارد شده با رمز فعلی شما مطابقت ندارد.");
                }
            }
            else {
                flagOldPassword = false;
                label4.setVisible(true);
                label1.setVisible(false);
            }
        }
        else {
            name1 = old.getText();
            if (!name1.isEmpty()){
                label1.setVisible(true);
                label4.setVisible(false);
                if (name1.equals(password)){
                    flagOldPassword = true;
                    label1.setStyle("-fx-text-fill: #028525");
                    label1.setText("رمز وارد شده با رمز فعلی شما مطابقت دارد.");
                }
                else {
                    label1.setStyle("-fx-text-fill: #a90000;");
                    flagOldPassword = false;
                    label1.setText("رمز وارد شده با رمز فعلی شما مطابقت ندارد.");
                }
            }
            else {
                flagOldPassword = false;
                label4.setVisible(true);
                label1.setVisible(false);
            }
        }


        label2.setStyle("-fx-text-fill: #a90000");
        if (flag2){
            name2 = newPassword.getText();
            if (!name2.isEmpty()){
                label2.setVisible(true);
                label5.setVisible(false);
                if (name2.length() != 4){
                    label2.setStyle("-fx-text-fill: #a90000");
                    label2.setText("طول رمز باید 4 باشد.");
                }
                else {
                    for (int i = 0  ; i < name2.length(); i++){
                        if ((name2.charAt(i) >= 'a' &&  name2.charAt(i) <= 'z' ) || (name2.charAt(i) >= 'A' &&  name2.charAt(i) <= 'Z' ) || (name2.charAt(i) >= '0' &&  name2.charAt(i) <= '9') || (name2.charAt(i) == '_') || (name2.charAt(i) == '.') || (name2.charAt(i) == '@') || (name2.charAt(i) == '!') ){
                            if (name2.equals(name1)){
                                label2.setStyle("-fx-text-fill: #a90000");
                                flagNewPassword = false;
                                label2.setText("رمز جدید شما و رمز فعلی شما یکسان است.");
                            }
                            else {
                                label2.setStyle("-fx-text-fill: #028525");
                                flagNewPassword = true;
                                label2.setText("رمز فعلی شما صحیح می باشد.");
                            }

                        }
                        else {
                            label2.setStyle("-fx-text-fill: #a90000");
                            flagNewPassword = false;
                            label2.setText("از کاراکتر های غیرمجاز استفاده کرده اید.");
                        }
                    }
                }
            }
            else {
                flagNewPassword = false;
                label5.setVisible(true);
                label2.setVisible(false);
            }
        }
        else {
            name2 = news.getText();
            if (!name2.isEmpty()){
                label2.setVisible(true);
                label5.setVisible(false);
                if (name2.length() != 4){
                    label2.setStyle("-fx-text-fill: #a90000");
                    label2.setText("طول رمز باید 4 باشد.");
                }
                else {
                    for (int i = 0  ; i < name2.length(); i++){
                        if ((name2.charAt(i) >= 'a' &&  name2.charAt(i) <= 'z' ) || (name2.charAt(i) >= 'A' &&  name2.charAt(i) <= 'Z' ) || (name2.charAt(i) >= '0' &&  name2.charAt(i) <= '9') || (name2.charAt(i) == '_') || (name2.charAt(i) == '.') || (name2.charAt(i) == '@') || (name2.charAt(i) == '!') ){
                            label2.setStyle("-fx-text-fill: #028525");
                            flagNewPassword = true;
                            label2.setText("رمز جدید شما صحیح می باشد.");
                        }
                        else {
                            label2.setStyle("-fx-text-fill: #a90000");
                            flagNewPassword = false;
                            label2.setText("از کاراکتر های غیرمجاز استفاده کرده اید.");
                        }
                    }
                }
            }
            else {
                label2.setVisible(false);
                flagNewPassword = false;
                label5.setVisible(true);
            }
        }

        label3.setStyle("-fx-text-fill: #a90000");
        if (flag3){
            name3 = confirmPassword.getText();
            if (!name3.isEmpty()){
                label3.setVisible(true);
                label6.setVisible(false);
                if (name2.equals(name3)){
                    flagConfirmPassword = true;
                    label3.setStyle("-fx-text-fill: #028525");
                    label3.setText("رمز تکرار شده با رمز جدید مطابقت دارد.");
                }
                else {
                    label3.setStyle("-fx-text-fill: #a90000");
                    flagConfirmPassword = false;
                    label3.setText("رمز عبور نوشته شده با رمز عبور جدید مطابقت ندارد.");
                }
            }
            else {
                flagConfirmPassword = false;
                label6.setVisible(true);
                label3.setVisible(false);
            }
        }
        else {
            name3 = confirm.getText();
            if (!name3.isEmpty()){
                label3.setVisible(true);
                label6.setVisible(false);
                if (name2.equals(name3)){
                    flagConfirmPassword = true;
                    label3.setStyle("-fx-text-fill: #028525");
                    label3.setText("رمز تکرار شده با رمز جدید مطابقت دارد.");
                }
                else {
                    label3.setStyle("-fx-text-fill: #a90000");
                    flagConfirmPassword = false;
                    label3.setText("رمز عبور نوشته شده با رمز عبور جدید مطابقت ندارد.");
                }
            }
            else {
                label3.setVisible(false);
                flagConfirmPassword = false;
                label6.setVisible(true);
            }
        }

    }));

    public void close(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    String username ;

    public void setUsername(String username) {
        this.username = username;
    }

    public void saveButton(MouseEvent mouseEvent) {
        if (flagOldPassword && flagNewPassword && flagConfirmPassword){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("مشتری گرامی در صورت مشترک بودن رمز فعلی با رمز عبور سایر کانالها پس از تغیر، رمز جدید جایگزین رمز فعلی در آن کانالها نیز خواهد شد.");
            alert.setTitle("هشدار");
            try {
                if (alert.showAndWait().get() == ButtonType.OK){
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("اطلاعیه");
                    alert1.setContentText("رمز شما با موفقیت تغیر کرد.");
                    alert1.showAndWait();
                    FileHandlingForUser fileHandlingForUser = new FileHandlingForUser();
                    fileHandlingForUser.readFile();
                    UsersOnline.changePassword(username,name1,name2);
                    Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                    fileHandlingForUser.writeFile();
                    stage.close();
                }
            }
            catch (Exception e) {

            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطا");
            alert.setHeaderText("یکی از 3 مقدار خواسته شده را به طور صحیح وارد نکرده اید.");
//            alert.setContentText("در صورتی که مقادیر خواسته شده را درست وارد کرده اید و همچنان خطا می دهد با پشتیبانی تماس بگیرید.");
            alert.showAndWait();
        }
    }
}