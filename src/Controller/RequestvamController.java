package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Deposit;
import model.vam;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;

import static service.findInformation.*;

public class RequestvamController {

    @FXML
    private Label AccountNumber;

    @FXML
    private Label NameLab;

    @FXML
    private Label nationall;

    @FXML
    private Label type;

    @FXML
    private Label AccNumLab;

    @FXML
    private Label CodeLab;

    @FXML
    private Label PageLab;

    @FXML
    private Label acctype;

    @FXML
    private ImageView approveImage;

    @FXML
    private ImageView rejectImage;

    @FXML
    private Pane checkItemBox;

    private vam vam;

    private String ID;

    LocalDate today = LocalDate.now();
    LocalTime time = LocalTime.now();

    // متد تنظیم اطلاعات آیتم
    public void setData(vam vam) {
        this.vam = vam;
        NameLab.setText(vam.getName());
        AccountNumber.setText(vam.getAccountNumber());
        nationall.setText(vam.getNationalcode());
        type.setText(vam.getVamtype());
        // سایر مقادیر رو هم می‌تونی اینجا ست کنی
    }

    // متد باز کردن پوشه مدارک بر اساس نام شخص
    @FXML
    private void openDocumentsFolder() {
        String nationalCode = nationall.getText().trim();

        if (nationalCode.isEmpty()) {
            showAlert("خطا", "کد ملی کاربر وارد نشده است!");
            return;
        }

        File folder = new File("vam/" + nationalCode);

        if (!folder.exists()) {
            showAlert("خطا", "پوشه‌ای برای این کاربر پیدا نشد:\n" + folder.getPath());
            return;
        }

        try {
            Desktop.getDesktop().open(folder);
        } catch (IOException e) {
            showAlert("خطا", "خطا در باز کردن پوشه:\n" + e.getMessage());
        }
    }

    @FXML
    void handleApproveClick(MouseEvent event) throws IOException {
        String AccountNum = AccountNumber.getText();
        double inventory = searchUserinventoryByAccountNumber(AccountNum);
        double newinventory = inventory+200000000;
        BigDecimal bigDecimal = new BigDecimal(newinventory);
        updateInventoryByAccountNumber(AccountNum , bigDecimal);
        FileWriter writer = new FileWriter("Deposits.txt" , true);
        writer.write("Amount transferred :" + bigDecimal);
        writer.write("\n");
        writer.write("Transfer type :واریز وجه");
        writer.write("\n");
        writer.write("destination number :" + AccountNum);
        writer.write("\n");
        writer.write("destination name :" + NameLab.getText());
        writer.write("\n");
        writer.write("tracking code :" + generateRandomNumber(9));
        writer.write("\n");
        writer.write("Date :" + today);
        writer.write("\n");
        writer.write("Time :" + time);
        writer.write("\n");
        writer.write("-------------");
        writer.write("\n");
        writer.close();



        updatevam(AccountNum , "تایید شد");
        removeSelfFromParent();
    }

    private final SecureRandom random = new SecureRandom(); // برای تولید اعداد تصادفی امن‌تر

    // متد تولید عدد تصادفی با طول مشخص
    private String generateRandomNumber(int length) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(10)); // عدد تصادفی بین 0 تا 9
        }
        return number.toString();

    }


    // متد رد
    @FXML
    void handleRejectClick(MouseEvent event) throws FileNotFoundException {
        updatevam(AccountNumber.getText().toString() , "رد شد");
        removeSelfFromParent();
    }

    // حذف این آیتم از والدش
    private void removeSelfFromParent() {
        if (checkItemBox.getParent() instanceof Pane parent) {
            parent.getChildren().remove(checkItemBox);
        }
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
