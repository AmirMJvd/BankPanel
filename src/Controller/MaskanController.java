package Controller;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MaskanController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            scrollPane.applyCss();
            scrollPane.layout();
            scrollPane.setVvalue(0);
            scrollPane.setHvalue(0);
        });
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("../views/userpage.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}