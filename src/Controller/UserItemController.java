package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import model.SharedData;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
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
    UserPageController userPageController = new UserPageController();

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
    void moreinfo(MouseEvent event) throws IOException {
        FileReader fileReader = new FileReader("users.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String userName = scanner.nextLine();
            scanner.nextLine();
            String userID = scanner.nextLine();
            if (UserID.getText().equals(userID)) {


                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/userpage.fxml"));
                BorderPane pane = loader.load();

                UserPageController userPageController = loader.getController();
                userPageController.setId(userName);

                // ساخت یک صحنه جدید با ابعاد دلخواه
                Scene scene = new Scene(pane, 1315, 810);  // ابعاد دلخواه


                // ساخت یک Stage جدید
                Stage stage = new Stage();
                stage.setTitle("Bank");
                stage.setScene(scene);


                // نمایش پنجره
                stage.show();

            }

        }
        scanner.close();

    }

}
