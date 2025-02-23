package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import model.SharedData;
import model.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserItemController {
    @FXML
    private Label UserFName;

    @FXML
    private Label UserID;

    @FXML
    private Label UserLName;

    @FXML
    private ImageView img;

    private User user;

    private EmployeeController employeeController;

    public void setData(User user) {
        this.user = user;
        UserFName.setText(user.getfirstName());
        UserLName.setText(user.getLastName());
        UserID.setText(user.getID());
    }





    @FXML
    void delet(MouseEvent event) {

    }

    @FXML
    void moreinfo(MouseEvent event) {

    }

}
