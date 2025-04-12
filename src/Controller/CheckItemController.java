package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CheckItemController {

    @FXML
    private Label AccNumLab;

    @FXML
    private Label CodeLab;

    @FXML
    private Label NameLab;

    @FXML
    private Label PageLab;

    @FXML
    private Label acctype;

    @FXML
    private ImageView approveImage;

    @FXML
    private Label nationall;

    @FXML
    private Label phonenumb;

    @FXML
    private Label postnumb;

    @FXML
    private ImageView rejectImage;

    @FXML
    private HBox checkItemBox;

    private String trackingNumber; // این متغیر باید برای هر آیتم ذخیره شود.

    public void setItemData(String name, String trackingNumber, String accountNumber, String checkPages,
                            String nationall, String phonenumb, String postnumb, String acctype) {
        NameLab.setText(name);
        CodeLab.setText(trackingNumber);
        AccNumLab.setText(accountNumber);
        PageLab.setText(checkPages);
        this.nationall.setText(nationall);
        this.phonenumb.setText(phonenumb);
        this.postnumb.setText(postnumb);
        this.acctype.setText(acctype);

        // ذخیره tracking number برای استفاده در متدها
        this.trackingNumber = trackingNumber;
    }

    // متد برای کلیک روی تایید
    public void handleApproveClick(MouseEvent event) {
        updateCheckRequestStatus("تایید شده");
        removeSelfFromParent();
    }

    // متد برای کلیک روی رد
    public void handleRejectClick(MouseEvent event) {
        updateCheckRequestStatus("رد شده");
        removeSelfFromParent();
    }

    // حذف این آیتم از والدش
    private void removeSelfFromParent() {
        if (checkItemBox.getParent() instanceof Pane parent) {
            parent.getChildren().remove(checkItemBox);
        }
    }

    private void updateCheckRequestStatus(String newStatus) {
        File file = new File("checkrequest.txt");
        List<String> updatedLines = new ArrayList<>();
        boolean foundStatusLine = false;  // برای مشخص کردن اینکه خط status پیدا شده است یا نه

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // اگر خط مربوط به status باشد، آن را آپدیت می‌کنیم
                if (line.startsWith("status:")) {
                    updatedLines.add("status: " + (newStatus.isEmpty() ? "در حال بررسی" : newStatus));  // مقدار جدید را قرار می‌دهیم
                    foundStatusLine = true;
                } else {
                    updatedLines.add(line);  // سایر خطوط بدون تغییر باقی می‌مانند
                }
            }

            // در صورتی که خط status پیدا نشد، هیچ خط جدیدی اضافه نخواهیم کرد
        } catch (IOException e) {
            e.printStackTrace();
        }

        // نوشتن بروزرسانی‌ها در فایل
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : updatedLines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Status updated: " + newStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
