package Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.FileHandlingForUser;
import model.User;
import model.UsersOnline;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeUserNameControlle implements Initializable {

    public void close(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public TextField oldusername;

    @FXML
    public TextField newusername;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    String oldname;
    String newname;

    String username ;

    public void setUsername(String name) {
        username = name;
    }

    boolean flagOld = false;

    boolean flagNew = false;

    Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(0.5), mani -> {
        if (!oldusername.getText().isEmpty()) {
            label1.setStyle("-fx-text-fill: #a90000;");
            label3.setVisible(false);
            oldname = oldusername.getText();
            if (!oldname.equals(username)) {
                label2.setStyle("-fx-text-fill: #a90000;");
                flagOld = false;
                label1.setText("نام کاربری فعلی شما صحیح نمی باشد.");
            }
            else {
                flagOld = true;
                label1.setStyle("-fx-text-fill: #028525;");
                label1.setText("نام کاربری فعلی صحیح می باشد.");
            }
        }
        else {
            flagOld = false;
            label3.setVisible(true);
            label1.setText("");
        }

        if (!newusername.getText().isEmpty()) {
            label2.setStyle("-fx-text-fill: #a90000;");
            label4.setVisible(false);
            newname = newusername.getText();
            if (newname.length() < 5 ) {
                flagNew = false;
                label2.setText("طول نام کاربری نمی تواند کمتر از 5 باشد.");
            }
            else if ( newname.length() > 30){
                flagNew = false;
                label2.setText("طول نام کاربری نمی تواند بیشتر از 30 باشد.");
            }
            else {
                if (newname.charAt(0) >= 'a' && newname.charAt(0) <= 'z') {
                    for (int i = 0; i < newname.length(); i++) {
                        if ((newname.charAt(i) >= 'a' && newname.charAt(i) <= 'z') || (newname.charAt(i) >= 'A' && newname.charAt(i) <= 'Z') || (newname.charAt(i) == '_') || (newname.charAt(i) == '-') || (newname.charAt(i) == '.') || (newname.charAt(i) >= '0' && newname.charAt(i) <= '9')) {
                            if (newname == username){
                                label2.setStyle("-fx-text-fill: #a90000;");
                                flagNew = false;
                                label2.setText("نام کاربری جدید با نام کاربری فعلی شما یکسان است.");
                            }
                            else {
                                label2.setStyle("-fx-text-fill: #028525;");
                                flagNew = true;
                                label2.setText("نام کاربری جدید شما صحیح می باشد.");
                            }
                        }
                        else {
                            label2.setStyle("-fx-text-fill: #a90000;");
                            flagNew = false;
                            label2.setText("از کاراکتر های غیر مجاز استفاده کرده اید");
                        }
                    }
                }
                else {
                    label2.setStyle("-fx-text-fill: #a90000;");
                    flagNew = false;
                    label2.setText("نام کابربری باید با حروف کوچک انگلیسی شروع شود.");
                }
            }
        }
        else {
            flagNew = false;
            label4.setVisible(true);
            label2.setText("");
        }
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
    }

    public void saveButton(MouseEvent event) {
        if (flagNew && flagOld) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("نام کاربری شما با موفقیت تغیر کرد.");
            alert.setTitle("اطلاعیه");
            alert.showAndWait();
            System.out.println("start");
            FileHandlingForUser file = new FileHandlingForUser();
            file.readFile();
            UsersOnline.changeUserName(oldname,newname);
            file.writeFile();
            ProfileController.name = newname;
            System.out.println("finish");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
        else {
            if (oldusername.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("هشدار");
                alert.setHeaderText("نام کاربری فعلی را وارد نکرده اید.");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("هشدار");
                alert.setHeaderText("نام کاربری جدید را وارد نکرده اید.");
                alert.showAndWait();
            }
        }
    }
}