package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import model.SharedData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GarzController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label errorLabel;

    @FXML
    private Label uploadLabel1, uploadLabel2, uploadLabel3, uploadLabel4, uploadLabel5, uploadLabel6, uploadLabel7;

    private final String[] filePaths = new String[7];

    private final String[] fileTitles = {"Employment", "Location", "Bank statement", "Military discharge card", "Guaranteed employment",  "Guarantor bank statement", "Guarantor's ID card"
    };

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

    private File selecteFile(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.pdf","*.jpg", "*.png"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        return fileChooser.showOpenDialog(stage);
    }

    private String findUserId(String username){
        try{
            if (username != null){
                FileReader fr = new FileReader("user.txt");
                Scanner reader = new Scanner(fr);
                while (reader.hasNextLine()){
                    if (reader.nextLine().equals(username)){
                        reader.nextLine();
                        return reader.nextLine();
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null ;
    }

    private boolean saveFile(File selectedFile){
        File destinationDir = new File("vam");
        if (!destinationDir.exists()){
            destinationDir.mkdirs();
        }

        File destinationFile = new File(destinationDir, selectedFile.getName());

        try{
            Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true ;
        } catch (IOException e) {
            System.out.println(" خطا در ذخیره فایل: " + e.getMessage());
            return false;
        }
    }

    private void saveFileInfo(String userID){
        File infoFile = new File("vaminfo.txt");

        try(FileWriter writer = new FileWriter(infoFile, true)) {
            writer.write("ID:" +userID+"\n");

            for (int i = 0 ; i < fileTitles.length; i++){
                String filePath = (filePaths[i] != null ) ? filePaths[i] :  "آپلود نشده";
                writer.write(fileTitles[i] + ": " + filePath + "\n");
            }

            writer.write("-----------------------------\n");

            errorLabel.setText("مدارک با موفقیت ثبت شد.");
            errorLabel.setStyle("-fx-text-fill: green;");

        } catch (IOException e) {
            errorLabel.setText("خطا در ذخیره اطلاعات!");
            errorLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void request(ActionEvent event){
        if (countUploadedFiles() < 7) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("مدارک ناقص");
            alert.setHeaderText(null);
            alert.setContentText("لطفاً همه مدارک موردنیاز را آپلود کنید.");
            alert.showAndWait();
            return;
        }

        String username = SharedData.getInstance().getUsername();
        String userID = findUserId(username);

        if (userID == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطا");
            alert.setHeaderText(null);
            alert.setContentText("خطا در دریافت اطلاعات کاربر!");
            alert.showAndWait();
            return;
        }

        saveFileInfo(userID);
    }

    private void uploadFile(MouseEvent event, int index, Label label) {
        File selectedFile = selecteFile(event);
        if (selectedFile != null) {
            boolean success = saveFile(selectedFile);
            if (success) {
                filePaths[index] = selectedFile.getAbsolutePath();
                label.setStyle("-fx-text-fill: green;");
            } else {
                label.setStyle("-fx-text-fill: red;");
            }
        }
    }

    @FXML
    void uploadfile1(MouseEvent event) { uploadFile(event, 0, uploadLabel1); }
    @FXML
    void uploadfile2(MouseEvent event) { uploadFile(event, 1, uploadLabel2); }
    @FXML
    void uploadfile3(MouseEvent event) { uploadFile(event, 2, uploadLabel3); }
    @FXML
    void uploadfile4(MouseEvent event) { uploadFile(event, 3, uploadLabel4); }
    @FXML
    void uploadfile5(MouseEvent event) { uploadFile(event, 4, uploadLabel5); }
    @FXML
    void uploadfile6(MouseEvent event) { uploadFile(event, 5, uploadLabel6); }
    @FXML
    void uploadfile7(MouseEvent event) { uploadFile(event, 6, uploadLabel7); }

    private int countUploadedFiles() {
        int count = 0;
        for (String filePath : filePaths) {
            if (filePath != null) {
                count++;
            }
        }
        return count;
    }
}
