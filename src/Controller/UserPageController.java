package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;
import service.AccountManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;



import static service.findInformation.*;
import static service.findInformation.searchUserinventoryByCardNumber;


public class UserPageController {

    @FXML
    private TextField CVV2;

    @FXML
    private DatePicker ADate;

    @FXML
    private DatePicker TDate;

    @FXML
    private ComboBox<String> transferType;

    @FXML
    private TextField BillCVV2;

    @FXML
    private TextField CodeRahgery;

    @FXML
    private TextField CardNumber;

    @FXML
    private TextField CardNumber1;

    @FXML
    private TextField chargPhoneNumber;

    @FXML
    private Label DateLabel;

    @FXML
    private Label DateLabel1;

    @FXML
    private Label username12;

    @FXML
    private TextField DepositNumber;

    @FXML
    private Button Download1;

    @FXML
    private Button Download2;

    @FXML
    private VBox Five;

    @FXML
    private VBox Five1;

    @FXML
    private VBox Five2;

    @FXML
    private VBox charg3;

    @FXML
    private VBox Bill3;

    @FXML
    private VBox Four;

    @FXML
    private Label HourLabel;

    @FXML
    private Label HourLabel1;

    @FXML
    private VBox containerVBox;

    @FXML
    private GridPane grid;

    @FXML
    private GridPane grid3;

    @FXML
    private GridPane grid1;

    @FXML
    private Label chargeCardNumberLabel;

    @FXML
    private TextField Month1;

    @FXML
    private Label NameLabel;

    @FXML
    private Label BillID1;

    @FXML
    private Label BillID2;

    @FXML
    private Label destination21;

    @FXML
    private Label destinationName21;

    @FXML
    private Label DateLabel21;

    @FXML
    private Label HourLabel21;

    @FXML
    private TextField OriginCardNumber;

    @FXML
    private TextField BillYear;

    @FXML
    private TextField BillMonth;

    @FXML
    private Label CardNumberLabel;

    @FXML
    private Label OriginCardNumberLabel;

    @FXML
    private TextField Password;

    @FXML
    private TextField Password1;

    @FXML
    private TextField Password2;

    @FXML
    private TextField chargeCVV2;

    @FXML
    private TextField chargeMonth;

    @FXML
    private TextField chargeYear;

    @FXML
    private Label PriceLabel;

    @FXML
    private Label PriceLabel1;

    @FXML
    private Label PriceLabel2;

    @FXML
    private TextField ShabaNumber;

    @FXML
    private VBox Three;

    @FXML
    private VBox Three1;

    @FXML
    private TextField TransferAmount;

    @FXML
    private TextField BillID;

    @FXML
    private TextField PaymentID;

    @FXML
    private TextField chargCardNumber;

    @FXML
    private VBox Two;

    @FXML
    private VBox Bill2;

    @FXML
    private VBox Two11;

    @FXML
    private VBox charg2;

    @FXML
    private VBox Two21;

    @FXML
    private TextField Year1;

    @FXML
    private Label amount;

    @FXML
    private Label BillAmount;

    @FXML
    private Label amount2;

    @FXML
    private Label BillType;

    @FXML
    private Label BillNameLabel;

    @FXML
    private Label BillPriceLabel;

    @FXML
    private Label destination;

    @FXML
    private Label chargPriceLabel;

    @FXML
    private Label destination2;

    @FXML
    private Label destinationLabel;

    @FXML
    private Label chargPhoneNumber1;

    @FXML
    private Label chargOperator;

    @FXML
    private Label destinationName;

    @FXML
    private Label chargNameLabel;

    @FXML
    private Label destinationName2;

    @FXML
    private Button downloadButton;

    @FXML
    private VBox one;

    @FXML
    private VBox Bill1;

    @FXML
    private VBox charg1;

    @FXML
    private Label origin;

    @FXML
    private Label originName;

    @FXML
    private Label trackingNumber;

    @FXML
    private Label trackingNumber1;

    @FXML
    private Label trackingNumber2;

    @FXML
    private Label username;

    @FXML
    private TextField IDCheck;

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField checkId;

    @FXML
    private TextField checkaccnum;

    @FXML
    private TextField checkamount;

    @FXML
    private TextField codenational;

    @FXML
    private TextField nameField;

    @FXML
    private TextField nationalID;

    @FXML
    private TextField nationalcode;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private TextField serialnum;

    @FXML
    private TextField seriesnum;

    @FXML
    private ComboBox<String> accountTypeComboBox;

    @FXML
    private ComboBox<?> chargPrice231;

    @FXML
    private ComboBox<Integer> checkPagesComboBox;

    @FXML
    private VBox VboxLabel;

    @FXML
    private VBox first;

    @FXML
    private VBox second;

    @FXML
    private VBox third;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vfirst;

    @FXML
    private VBox vsecound;

    @FXML
    private VBox vthird;

    @FXML
    private HBox CheckConfirmation;

    @FXML
    private HBox CheckregistrationVbox;

    @FXML
    private HBox mainvbox;

    @FXML
    private HBox hboxmain;

    @FXML
    private HBox hbox;

    @FXML
    private ScrollPane scrollPaneId;

    @FXML
    private BorderPane rootPane;

    @FXML
    private TabPane tabpane;

    @FXML
    private AnchorPane anch1;

    @FXML
    private AnchorPane anch3;

    @FXML
    private ScrollPane scrollPane3;

    @FXML
    private StackPane anch3StackPane;

    @FXML
    private AnchorPane anch4;

    @FXML
    private Pane pane4;

    @FXML
    private AnchorPane anch7;

    @FXML
    private ScrollPane scroll3;

    @FXML
    private StackPane stack3;

    @FXML
    private Pane panee;

    @FXML
    private Pane panee1;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView imgback;

    @FXML
    private Button checkBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button rejectionBtn;

    @FXML
    private Label CheckregistrationLabel;

    @FXML
    private Label confirmationLabel;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblCheckId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblNationalCode;

    @FXML
    private Label lblSerial;

    @FXML
    private Label lblSeries;

    @FXML
    private Label request;

    @FXML
    private Label requestCheckLabel;

    @FXML
    private Label sabt;

    @FXML
    private Label taiid;

    @FXML
    private VBox requestCheckVBox;

    @FXML
    private DatePicker date;

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;

    @FXML
    private VBox checkgrid;

    @FXML
    private AnchorPane anch8;

    @FXML
    private GridPane grid4;

    @FXML
    private ScrollPane scroll4;

    @FXML
    private StackPane stack4;


    @FXML
    private TextField searchTextField;

    @FXML
            private VBox vboxscrol;


    String password;

    String username_mani;

    public void setMani(String username_mani , String password) {
        this.username_mani = username_mani;
        this.password = password;
    }
    /// ///////////
    public void clickProfileImage(MouseEvent event) {
        Stage stage = (Stage) Five.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/profile.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            ProfileController controller = loader.getController();
            controller.setUsername(username12.getText());
            controller.setPassword(password);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void setId(String username1) {
        username12.setText(username1);

        // اجرای getData بعد از مقداردهی
        Platform.runLater(() -> {
            getData();
        });
    }


    @FXML
    private ComboBox<String> chargPrice;


    private final SecureRandom random = new SecureRandom(); // برای تولید اعداد تصادفی امن‌تر

    @FXML
    public void initialize() {
        TransferAmount.textProperty().addListener((observable, oldValue, newValue) -> {
            // فقط اعداد ویرایش شوند، حروف حذف شوند
            String cleanValue = newValue.replaceAll("[^0-9]", "");

            if (cleanValue.isEmpty()) {
                TransferAmount.setText("");
                return;
            }

            // تبدیل مقدار به عدد و افزودن کاما
            String formattedValue = formatWithCommas(cleanValue);

            // غیرفعال کردن Listener برای جلوگیری از بازگشتی شدن تغییرات
            TransferAmount.setText(formattedValue);
        });

//        TransferAmount1.textProperty().addListener((observable, oldValue, newValue) -> {
//            // فقط اعداد ویرایش شوند، حروف حذف شوند
//            String cleanValue = newValue.replaceAll("[^0-9]", "");
//
//            if (cleanValue.isEmpty()) {
//                TransferAmount1.setText("");
//                return;
//            }
//
//            // تبدیل مقدار به عدد و افزودن کاما
//            String formattedValue = formatWithCommas(cleanValue);
//
//            // غیرفعال کردن Listener برای جلوگیری از بازگشتی شدن تغییرات
//            TransferAmount1.setText(formattedValue);
//        });
//
//        TransferAmount2.textProperty().addListener((observable, oldValue, newValue) -> {
//            // فقط اعداد ویرایش شوند، حروف حذف شوند
//            String cleanValue = newValue.replaceAll("[^0-9]", "");
//
//            if (cleanValue.isEmpty()) {
//                TransferAmount2.setText("");
//                return;
//            }
//
//            // تبدیل مقدار به عدد و افزودن کاما
//            String formattedValue = formatWithCommas(cleanValue);
//
//            // غیرفعال کردن Listener برای جلوگیری از بازگشتی شدن تغییرات
//            TransferAmount2.setText(formattedValue);
//        });

        downloadButton.setOnAction(event -> takeScreenshot2());
        Download1.setOnAction(event -> takeScreenshot1());
//        Download2.setOnAction(event -> takeScreenshot2());

        chargPrice.getItems().addAll("50,000 ریال", "100,000 ریال", "200,000 ریال", "500,000 ریال");
        transferType.getItems().addAll("پرداخت قبض" , "شارژ تلفن همراه" , "برداشت از کارت" , "واریز به کارت","واریز به سپرده" , "واریز به شبا");

        // مخفی کردن VBoxها در ابتدا
        requestCheckVBox.setVisible(false);
        requestCheckVBox.setManaged(false);
        CheckregistrationVbox.setVisible(false);
        CheckregistrationVbox.setManaged(false);
        CheckConfirmation.setVisible(false);
        CheckConfirmation.setManaged(false);
        mainvbox.setVisible(false);
        mainvbox.setManaged(false);
        img1.setVisible(false);
        img1.setManaged(false);
        img2.setVisible(false);
        img2.setManaged(false);
        img3.setVisible(false);
        img3.setManaged(false);

        // کلیک برای نمایش تایید\رد چک
        confirmationLabel.setOnMouseClicked(event -> {
            mainvbox.setVisible(true);
            mainvbox.setManaged(true);
            CheckConfirmation.setVisible(true);
            CheckConfirmation.setManaged(true);
            img2.setVisible(true);
            img2.setManaged(true);
            requestCheckVBox.setVisible(false);
            requestCheckVBox.setManaged(false);
            CheckregistrationVbox.setVisible(false);
            CheckregistrationVbox.setManaged(false);
            VboxLabel.setVisible(false);
            VboxLabel.setManaged(false);
            img3.setVisible(false);
            img3.setManaged(false);
            img1.setVisible(false);
            img1.setManaged(false);
            taiid.setStyle(" -fx-border-color: black; -fx-border-width: 1px; -fx-background-radius: 25px; -fx-background-color:  #FFFFFF; -fx-border-radius: 25px");
            sabt.setStyle(" -fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
            request.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
        });
        taiid.setOnMouseClicked(event -> {
            mainvbox.setVisible(true);
            mainvbox.setManaged(true);
            CheckConfirmation.setVisible(true);
            CheckConfirmation.setManaged(true);
            img2.setVisible(true);
            img2.setManaged(true);
            requestCheckVBox.setVisible(false);
            requestCheckVBox.setManaged(false);
            CheckregistrationVbox.setVisible(false);
            CheckregistrationVbox.setManaged(false);
            VboxLabel.setVisible(false);
            VboxLabel.setManaged(false);
            img3.setVisible(false);
            img3.setManaged(false);
            img1.setVisible(false);
            img1.setManaged(false);
            taiid.setStyle(" -fx-border-color: black; -fx-border-width: 1px;-fx-background-radius: 25px; -fx-background-color:  #FFFFFF; -fx-border-radius: 25px");
            sabt.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
            request.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
        });


        // کلیک برای نمایش درخواست دسته چک
        requestCheckLabel.setOnMouseClicked(event -> {
            mainvbox.setVisible(true);
            mainvbox.setManaged(true);
            requestCheckVBox.setVisible(true);
            requestCheckVBox.setManaged(true);
            img3.setVisible(true);
            img3.setManaged(true);
            CheckregistrationVbox.setVisible(false);
            CheckregistrationVbox.setManaged(false);
            CheckConfirmation.setVisible(false);
            CheckConfirmation.setManaged(false);
            VboxLabel.setVisible(false);
            VboxLabel.setManaged(false);
            img1.setVisible(false);
            img1.setManaged(false);
            img2.setVisible(false);
            img2.setManaged(false);
            request.setStyle(" -fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 25px; -fx-background-color:  #FFFFFF; -fx-background-radius: 25px");
            taiid.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
            sabt.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
        });
        request.setOnMouseClicked(event -> {
            mainvbox.setVisible(true);
            mainvbox.setManaged(true);
            requestCheckVBox.setVisible(true);
            requestCheckVBox.setManaged(true);
            img3.setVisible(true);
            img3.setManaged(true);
            CheckregistrationVbox.setVisible(false);
            CheckregistrationVbox.setManaged(false);
            CheckConfirmation.setVisible(false);
            CheckConfirmation.setManaged(false);
            VboxLabel.setVisible(false);
            VboxLabel.setManaged(false);
            img1.setVisible(false);
            img1.setManaged(false);
            img2.setVisible(false);
            img2.setManaged(false);
            request.setStyle(" -fx-border-color: black; -fx-border-width: 1px;-fx-background-radius: 25px; -fx-background-color:  #FFFFFF; -fx-border-radius: 25px");
            sabt.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
            taiid.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
        });

        // کلیک برای نمایش ثبت دسته چک
        CheckregistrationLabel.setOnMouseClicked(event -> {
            mainvbox.setVisible(true);
            mainvbox.setManaged(true);
            CheckregistrationVbox.setVisible(true);
            CheckregistrationVbox.setManaged(true);
            img1.setVisible(true);
            img1.setManaged(true);
            CheckConfirmation.setVisible(false);
            CheckConfirmation.setManaged(false);
            requestCheckVBox.setVisible(false);
            requestCheckVBox.setManaged(false);
            VboxLabel.setVisible(false);
            VboxLabel.setManaged(false);
            img3.setVisible(false);
            img3.setManaged(false);
            img2.setVisible(false);
            img2.setManaged(false);
            sabt.setStyle(" -fx-border-color: black; -fx-border-width: 1px; -fx-background-radius: 25px; -fx-background-color:  #FFFFFF; -fx-border-radius: 25px");
            taiid.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
            request.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
        });
        sabt.setOnMouseClicked(event -> {
            mainvbox.setVisible(true);
            mainvbox.setManaged(true);
            CheckregistrationVbox.setVisible(true);
            CheckregistrationVbox.setManaged(true);
            img1.setVisible(true);
            img1.setManaged(true);
            CheckConfirmation.setVisible(false);
            CheckConfirmation.setManaged(false);
            requestCheckVBox.setVisible(false);
            requestCheckVBox.setManaged(false);
            VboxLabel.setVisible(false);
            VboxLabel.setManaged(false);
            img3.setVisible(false);
            img3.setManaged(false);
            img2.setVisible(false);
            img2.setManaged(false);
            sabt.setStyle(" -fx-border-color: black; -fx-border-width: 1px;-fx-background-radius: 25px; -fx-background-color:  #FFFFFF; -fx-border-radius: 25px");
            taiid.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
            request.setStyle("-fx-background-radius: 25px; -fx-background-color:  #FFFFFF");
        });

        accountTypeComboBox.getItems().addAll("سپرده قرض الحسنه جاری");
        checkPagesComboBox.getItems().addAll(25, 50, 100);


        // تنظیم حرکت با Enter در مرحله اول
        checkId.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                handleNextAction(); // چون فقط یک فیلد داریم
            }
        });

        // مرحله دوم: حرکت بین فیلدها با Enter
        checkaccnum.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) serialnum.requestFocus();
        });

        serialnum.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) seriesnum.requestFocus();
        });

        seriesnum.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) checkamount.requestFocus();
        });

        checkamount.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) date.requestFocus();
        });

        date.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) handleSecondNext(); // رفتن به بخش سوم
        });

        // مرحله سوم: کد ملی و ذخیره
        nationalcode.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) saveCheckInfo();
        });


        first.setVisible(true);
        second.setVisible(false);
        third.setVisible(false);
        second.managedProperty().bind(second.visibleProperty());
        third.managedProperty().bind(third.visibleProperty());

        // اضافه کردن Listener برای تغییر رنگ دایره‌ها بر اساس وضعیت VBox
        first.visibleProperty().addListener((obs, oldVal, newVal) -> updateCircleColors());
        second.visibleProperty().addListener((obs, oldVal, newVal) -> updateCircleColors());
        third.visibleProperty().addListener((obs, oldVal, newVal) -> updateCircleColors());

        // ریسپانسیو کردن TabPane
        tabpane.prefWidthProperty().bind(rootPane.widthProperty());
        tabpane.prefHeightProperty().bind(rootPane.heightProperty());

        // ریسپانسیو کردن AnchorPane
        anch1.prefWidthProperty().bind(tabpane.widthProperty());
        anch1.prefHeightProperty().bind(tabpane.heightProperty());
        anch4.prefWidthProperty().bind(tabpane.widthProperty());
        anch4.prefHeightProperty().bind(tabpane.heightProperty());
        hbox.prefWidthProperty().bind(tabpane.widthProperty());
        hbox.prefHeightProperty().bind(tabpane.heightProperty());
        anch7.prefWidthProperty().bind(tabpane.widthProperty());
        anch7.prefHeightProperty().bind(tabpane.heightProperty());
        anch8.prefWidthProperty().bind(tabpane.widthProperty());
        anch8.prefHeightProperty().bind(tabpane.heightProperty());

        // ریسپانسیو کردن HBox
        hboxmain.prefWidthProperty().bind(anch1.widthProperty());
        hboxmain.prefHeightProperty().bind(anch1.heightProperty());

        // ریسپانسیو کردن VBoxها با تقسیم مساوی عرض HBox
        vfirst.prefWidthProperty().bind(hboxmain.widthProperty().divide(3));
        vsecound.prefWidthProperty().bind(hboxmain.widthProperty().divide(3));
        vthird.prefWidthProperty().bind(hboxmain.widthProperty().divide(3));
        vfirst.prefHeightProperty().bind(hboxmain.heightProperty());
        vsecound.prefHeightProperty().bind(hboxmain.heightProperty());
        vthird.prefHeightProperty().bind(hboxmain.heightProperty());

        scrollPaneId.prefWidthProperty().bind(tabpane.widthProperty());
        scrollPaneId.prefHeightProperty().bind(tabpane.heightProperty());
        scrollPane3.prefWidthProperty().bind(tabpane.widthProperty());
        scrollPane3.prefHeightProperty().bind(tabpane.heightProperty());


        // pane4 هماهنگ با anch4
        pane4.prefWidthProperty().bind(anch4.widthProperty());
        pane4.prefHeightProperty().bind(anch4.heightProperty());

        // VboxLabel هماهنگ با pane4
        VboxLabel.prefWidthProperty().bind(pane4.widthProperty());
        VboxLabel.prefHeightProperty().bind(pane4.heightProperty());
        mainvbox.prefWidthProperty().bind(pane4.widthProperty());
        mainvbox.prefHeightProperty().bind(pane4.heightProperty());
        CheckregistrationVbox.prefHeightProperty().bind(anch4.heightProperty());
        // ست کردن عرض HBox برابر با 2/3 عرض AnchorPane
        CheckregistrationVbox.prefWidthProperty().bind(anch4.widthProperty().multiply(4.0 / 5.0));
        requestCheckVBox.prefWidthProperty().bind(anch4.widthProperty().multiply(4.0 / 5.0));
        CheckConfirmation.prefWidthProperty().bind(anch4.widthProperty().multiply(4.0 / 5.0));

        // ScrollPane اندازه‌اش با AnchorPane برابر باشه
        scroll4.prefWidthProperty().bind(anch8.widthProperty());
        scroll4.prefHeightProperty().bind(anch8.heightProperty());


        // StackPane اندازه‌اش با ScrollPane برابر باشه
        stack4.prefWidthProperty().bind(scroll4.widthProperty());
        stack4.prefHeightProperty().bind(scroll4.heightProperty());

        // ScrollPane اندازه‌اش با AnchorPane برابر باشه
        scroll3.prefWidthProperty().bind(anch7.widthProperty());
        scroll3.prefHeightProperty().bind(anch7.heightProperty());


        // StackPane اندازه‌اش با ScrollPane برابر باشه
        stack3.prefWidthProperty().bind(scroll3.widthProperty());
        stack3.prefHeightProperty().bind(scroll3.heightProperty());

        vboxscrol.prefWidthProperty().bind(anch7.widthProperty());
        // مقداردهی اولیه
        updateCircleColors();

        Platform.runLater(() -> {
            LoadUser1();
            LoadUser();
            LoadUserBillTransfer();
            AccountManager accountManager = new AccountManager();
            try {
                accountManager.ReadFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            LoadCheckHistory();

        });
    }

    private void updateCircleColors() {
        if (first.isVisible()) {
            circle1.setFill(Color.GRAY);
            circle2.setFill(Color.web("#d3d3d3"));
            circle3.setFill(Color.web("#d3d3d3"));
        } else if (second.isVisible()) {
            circle1.setFill(Color.web("#d3d3d3"));
            circle2.setFill(Color.GRAY);
            circle3.setFill(Color.web("#d3d3d3"));
        } else if (third.isVisible()) {
            circle1.setFill(Color.web("#d3d3d3"));
            circle2.setFill(Color.web("#d3d3d3"));
            circle3.setFill(Color.GRAY);
        } else {
            circle1.setFill(Color.web("#d3d3d3"));
            circle2.setFill(Color.web("#d3d3d3"));
            circle3.setFill(Color.web("#d3d3d3"));
        }

    }


    private void takeScreenshot1() {
        try {
            // تعیین محدوده‌ای که باید عکس بگیریم
            int x = 1102, y = 362, width = 348, height = 339;
            Robot robot = new Robot();
            Rectangle captureArea = new Rectangle(x, y, width, height);

            // گرفتن اسکرین‌شات
            BufferedImage bufferedImage = robot.createScreenCapture(captureArea);

            // باز کردن پنجره ذخیره‌سازی فایل
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Screenshot");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Image", "*.png"));

            // انتخاب مسیر ذخیره‌سازی
            File file = fileChooser.showSaveDialog(new Stage());

            if (file != null) {
                ImageIO.write(bufferedImage, "png", file);
                System.out.println("Screenshot saved at: " + file.getAbsolutePath());
            } else {
                System.out.println("Saving cancelled.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // متد برای افزودن کاما بعد از هر سه رقم
    private String formatWithCommas(String number) {
        StringBuilder formatted = new StringBuilder();
        int length = number.length();
        int counter = 0;

        for (int i = length - 1; i >= 0; i--) {
            formatted.insert(0, number.charAt(i));
            counter++;
            if (counter == 3 && i > 0) {
                formatted.insert(0, ",");
                counter = 0;
            }
        }

        return formatted.toString();
    }

    // متد تولید عدد تصادفی با طول مشخص
    private String generateRandomNumber(int length) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(10)); // عدد تصادفی بین 0 تا 9
        }
        return number.toString();
    }


    @FXML
    void Back(ActionEvent event) {
        one.setVisible(true);  // عنصر را نامرئی می‌کند
        one.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void Back1(ActionEvent event) {
        Two.setVisible(true);  // عنصر را نامرئی می‌کند
        Two.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void BackBill1(ActionEvent event) {
        Bill1.setVisible(true);
        Bill1.setManaged(true);
    }

    @FXML
    void BackBill2(ActionEvent event) {
        Bill2.setVisible(true);
        Bill2.setManaged(true);
    }

    @FXML
    void Back2(ActionEvent event) {
        Three.setVisible(true);  // عنصر را نامرئی می‌کند
        Three.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void Back21(ActionEvent event) {

    }

    @FXML
    void End(ActionEvent event) {
        Five.setVisible(false);  // عنصر را نامرئی می‌کند
        Five.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
        one.setVisible(true);
        Two.setVisible(true);
        Three.setVisible(true);
        Four.setVisible(true);
        Five.setVisible(true);
        TransferAmount.clear();
        CardNumber.clear();
        DepositNumber.clear();
        ShabaNumber.clear();
        OriginCardNumber.clear();
        Password.clear();
        Month1.clear();
        Year1.clear();
        CVV2.clear();
    }

    @FXML
    void EndBill(ActionEvent event) {
        Bill1.setVisible(true);
        Bill1.setManaged(true);
        Bill2.setVisible(true);
        Bill2.setManaged(true);


    }

    @FXML
    void End2(ActionEvent event) {

    }


    @FXML
    void Show1(MouseEvent event) {

    }

    @FXML
    void Show2(MouseEvent event) {

    }

    // آرایه برای ذخیره اطلاعات
    private Object[] transferArray = new Object[9]; // استفاده از Object به جای long تا امکان مقدار null وجود داشته باشد.

    @FXML
    void next(ActionEvent event) {
        // دریافت مقدار از TextField و حذف کاماها
        String amountText = TransferAmount.getText().replace(",", "");

        // بررسی اینکه مقدار خالی نباشد
        if (amountText.isEmpty()) {
            showAlert("خطا", "لطفاً مبلغی وارد کنید.");
            return;
        }

        try {
            // تبدیل مقدار به عدد
            long amount = Long.parseLong(amountText);

            // بررسی سقف مبلغ (100 میلیون)
            if (amount > 1_000_000_000) {
                showAlert("مبلغ بیش از حد مجاز", "مبلغ وارد شده بیش از 100 میلیون تومان است!");
                return;
            }

            // ذخیره مقدار در خانه اول آرایه
            transferArray[0] = amount;

            // مخفی کردن عنصر
            one.setVisible(false);
            one.setManaged(false);
        } catch (NumberFormatException e) {
            showAlert("خطا", "مبلغ وارد شده نامعتبر است.");
        }
    }

    @FXML
    void next1(ActionEvent event) {
        // بررسی مقدار ذخیره‌شده در خانه اول (مبلغ انتقالی)
        if (transferArray[0] == null) {
            showAlert("خطا", "ابتدا مبلغ را وارد کنید.");
            return;
        }

        long amount;
        try {
            amount = (long) transferArray[0]; // تبدیل مقدار ذخیره شده به عدد
        } catch (Exception e) {
            showAlert("خطا", "مبلغ نامعتبر است!");
            return;
        }

        String cardNum = CardNumber.getText().trim();
        String depositNum = DepositNumber.getText().trim();
        String shabaNum = ShabaNumber.getText().trim();

        if (!cardNum.isEmpty()) {
            if (amount > 100_000_000) {
                showAlert("خطا", "مبلغ وارد شده بیش از 100 میلیون ریال است!");
                return;
            }
            if (!cardNum.matches("\\d{16}")) {
                showAlert("خطا", "شماره کارت نامعتبر است! باید 16 رقم باشد.");
                return;
            }

            // ذخیره شماره کارت در آرایه
            transferArray[1] = "کارت";
            transferArray[2] = cardNum;

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = searchUserIDByCardNumber(cardNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    transferArray[3] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه
                } else {
                    showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                }
            } else {
                showAlert("خطا", "شماره کارت معتبر نیست.");
            }

        } else if (!depositNum.isEmpty()) {
            if (amount > 1_000_000_000) {
                showAlert("خطا", "مبلغ وارد شده بیش از 1 میلیارد ریال است!");
                return;
            }
            if (!depositNum.matches("\\d{14}")) {
                showAlert("خطا", "شماره سپرده نامعتبر است! باید 14 رقم باشد.");
                return;
            }

            transferArray[1] = "سپرده";
            transferArray[2] = depositNum;

            String userID = searchUserIDByAccountNumber(depositNum);
            if (userID != null) {

                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    transferArray[3] = userInfo[0] + " " + userInfo[1];
                } else {
                    showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                }
            } else {
                showAlert("خطا", "شماره سپرده معتبر نیست.");
            }

        } else if (!shabaNum.isEmpty()) {
            if (amount > 1_000_000_000) {
                showAlert("خطا", "مبلغ وارد شده بیش از 1 میلیارد ریال است!");
                return;
            }
            if (!shabaNum.matches("IR\\d{24}")) {
                showAlert("خطا", "شماره شبا نامعتبر است! باید با IR شروع شده و 26 رقم باشد.");
                return;
            }

            transferArray[1] = "شبا";
            transferArray[2] = shabaNum;


            String userID = searchUserIDByShabaNumber(shabaNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    transferArray[3] = userInfo[0] + " " + userInfo[1];
                } else {
                    showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                }
            } else {
                showAlert("خطا", "شماره شبا معتبر نیست.");
            }

        } else {
            showAlert("خطا", "لطفاً یکی از فیلدهای کارت، سپرده یا شبا را پر کنید.");
            return;
        }


        PriceLabel.setText(TransferAmount.getText());
        destinationLabel.setText(transferArray[2].toString());
        NameLabel.setText(transferArray[3].toString());

        // مخفی کردن بخش مربوطه
        Two.setVisible(false);
        Two.setManaged(false);
    }


    @FXML
    void next2(ActionEvent event) {
        // دریافت مقدار از TextField و حذف کاماها
        String OriginCardNumber = this.OriginCardNumber.getText();

        // بررسی اینکه مقدار خالی نباشد
        if (OriginCardNumber.isEmpty()) {
            showAlert("خطا", "لطفاً شماره کارت را وارد کنید.");
            return;
        }

        // جستجو برای پیدا کردن User ID از شماره کارت
        String userID = searchUserIDByCardNumber(OriginCardNumber);
        if (userID != null) {
            // جستجو برای یافتن نام و نام خانوادگی کاربر
            String[] userInfo = searchUserInfoByUserID(userID);
            if (userInfo != null) {
                transferArray[4] = OriginCardNumber;
                transferArray[5] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه
            } else {
                showAlert("خطا", "اطلاعات کاربر یافت نشد.");
            }
        } else {
            showAlert("خطا", "شماره کارت معتبر نیست.");
        }

        OriginCardNumberLabel.setText(transferArray[4].toString());

        for (int i = 0; i < 6; i++) {
            System.out.println("transferArray[" + i + "]: " + transferArray[i]);
        }
        Three.setVisible(false);
        Three.setManaged(false);
    }


    private String sentCode;


    @FXML
    void ReceivePassword(ActionEvent event) {
        String CartNumber = OriginCardNumberLabel.getText();
        String[] data = searchYearMounthCvv2(CartNumber);
        String txtYear = Year1.getText();
        String txtMonth = Month1.getText();
        String cvv2 = CVV2.getText();

        if (txtYear.isEmpty() || txtMonth.isEmpty() || cvv2.isEmpty()) {
            showAlert("خطا", "لطفاً سال، ماه و CVV2 را وارد کنید.");
            return;
        }

        if (data != null) {
            String Year = data[0];
            String Month = data[1];
            String storedCvv2 = data[2];

            if (Year.equals(txtYear) && Month.equals(txtMonth) && storedCvv2.equals(cvv2)) {

                String userID = searchUserIDByCardNumber(CartNumber);
                if (userID != null) {

                    String userInfo = searchUserEmail(userID);
                    if (userInfo != null) {
                        String recipient = userInfo;
                        sentCode = generateRandomCode();
                        boolean isSent = sendEmail(recipient, sentCode);
                        if (isSent) {
                            showAlert("موفقیت", "رمز پویا به ایمیل شما ارسال گردید !");
                        } else {
                            showAlert("خطا", "ارسال رمز نا موفق!");
                        }
                    } else {
                        showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                    }
                } else {
                    showAlert("خطا", "شماره کارت معتبر نیست.");
                }
            } else {
                showAlert("خطا!", "تاریخ انقضا یا CVV2 اشتباه هست !");
            }
        } else {
            showAlert("خطا!", "تاریخ انقضا یا CVV2 پیدا نشد");
        }
    }


//    private String[] searchYear(String cardNumber) {
//        try{
//            FileReader fileReader = new FileReader("userID.txt");
//            Scanner scanner = new Scanner(fileReader);
//            String line;
//
//            // متغیرهای سال، ماه و CVV2 برای ذخیره
//            String year = null;
//            String month = null;
//            String cvv2 = null;
//
//            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
//            while (scanner.hasNextLine()) {
//                // عبور از خطوط غیر ضروری
//                scanner.nextLine();  // عبور از خط بعدی
//                scanner.nextLine();
//                scanner.nextLine();
//                String code = scanner.nextLine();  // خواندن کد کارت
//
//                // بررسی می‌کنیم که آیا خط چهارم شامل شماره کارت مورد نظر است
//                if (code.startsWith("Card Number: " + cardNumber)) {
//                    String storedCardNumber = code.split(":")[1].trim();  // گرفتن شماره کارت از فایل
//                    String userInputCardNumber = cardNumber.trim();  // حذف فضای اضافی از ورودی کاربر
//                    scanner.nextLine();
//                    // اگر شماره کارت‌ها برابر بودند
//                    if (storedCardNumber.equals(userInputCardNumber)) {
//
//                        String date = scanner.nextLine().split(":")[1].trim();  // گرفتن تاریخ
//                        String cvv2Line = scanner.nextLine().split(":")[1].trim();  // گرفتن CVV2
//
//                        // بررسی اینکه تاریخ فرمت درست داشته باشد
//                        if (date.contains("-")) {
//                            String[] parts = date.split("-");
//
//                            // بررسی اینکه آرایه دارای دو قسمت باشد
//                            if (parts.length == 2) {
//                                year = parts[0];  // سال
//                                month = parts[1];  // ماه
//                            } else {
//                                System.out.println("فرمت تاریخ اشتباه است: " + date);
//                            }
//                        } else {
//                            System.out.println("تاریخ فرمت اشتباهی دارد: " + date);
//                        }
//
//                        cvv2 = cvv2Line;  // ذخیره CVV2
//                        break;  // پس از پیدا کردن شماره کارت، تاریخ و CVV2، از حلقه خارج می‌شویم
//                    }
//                }else {
//                    scanner.nextLine();
//                    scanner.nextLine();
//                    scanner.nextLine();
//                    scanner.nextLine();
//                    scanner.nextLine();
//                    scanner.nextLine();
//                }
//            }
//
//            // بازگشت سال، ماه و CVV2
//            return new String[]{year, month, cvv2};
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // در صورتی که خطای ورودی یا خروجی رخ دهد، null برمی‌گردانیم
//        return null;
//    }


//    private String searchUserEmail(String userID) {
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
//            String line;
//            String Email= "";
//
//            while ((line = reader.readLine()) != null) {
//                if (line.equals(userID)) {
//                    reader.readLine();
//                    Email = reader.readLine();
//                    return Email;
//
//                }else {
//
//                }
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    private static String generateRandomCode() {
        SecureRandom random = new SecureRandom();
        int code = 100000 + random.nextInt(900000); // تولید عدد ۶ رقمی تصادفی
        return String.valueOf(code);
    }

//    private static boolean sendEmail(String recipient, String code) {
//        final String senderEmail = "bookstore.java.1403@gmail.com";
//        final String senderPassword = "grgf ycdk suio bxbl"; // امنیتی نیست، باید از OAuth استفاده کنید
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, senderPassword);
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(senderEmail));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
//            message.setSubject("*بانک جاواد*");
//            message.setText("رمز اینترنتی شما : " + code);
//
//            Transport.send(message);
//            return true;
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }


    @FXML
    void next3(ActionEvent event) throws IOException {
        String enteredCode = Password.getText();

        if (sentCode != null && sentCode.equals(enteredCode)) {
            String cardNum = transferArray[4].toString();
            Double inventoryStr = searchUserinventoryByCardNumber(cardNum);
            if (transferArray[1].toString().equals("کارت")) {
                Double inventoryStr1 = searchUserinventoryByCardNumber(transferArray[2].toString());


                String transferStr1 = transferArray[0].toString().trim();
                String transferCleaned1 = transferStr1.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned1);

                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByCardNumber(transferArray[2].toString(), bigDecimal);

            } else if (transferArray[1].toString().equals("سپرده")) {

                Double inventoryStr1 = searchUserinventoryByAccountNumber(transferArray[2].toString());

                String transferStr = transferArray[0].toString().trim();
                String transferCleaned = transferStr.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned);


                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByAccountNumber(transferArray[2].toString(), bigDecimal);
            } else if (transferArray[1].toString().equals("شبا")) {
                Double inventoryStr1 = searchUserinventoryByShabaNumber(transferArray[2].toString());


                String transferStr = transferArray[0].toString().trim();
                String transferCleaned = transferStr.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned);


                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByShabaNumber(transferArray[2].toString(), bigDecimal);
            }


            String transferStr = transferArray[0].toString().trim();
            String transferCleaned = transferStr.replaceAll("[^\\d]", "");
            int transferAmount = Integer.parseInt(transferCleaned);

            // بررسی مقدار و چاپ نتیجه
            if (inventoryStr > transferAmount) {
                Double remainingAmount = inventoryStr - transferAmount;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount);
                updateInventoryByCardNumber(transferArray[4].toString(), bigDecimal);


                Four.setVisible(false);
                Four.setManaged(false);

                String track = generateRandomNumber(9);
                transferArray[6] = track;

                LocalDate today = LocalDate.now();

                String[] dateArray = {
                        String.valueOf(today.getYear()),  // سال
                        String.valueOf(today.getMonthValue()),  // ماه
                        String.valueOf(today.getDayOfMonth())  // روز
                };


                LocalTime now = LocalTime.now();
                String[] timeArray = {
                        String.valueOf(now.getHour()),    // ساعت
                        String.valueOf(now.getMinute()),  // دقیقه
                        String.valueOf(now.getSecond())   // ثانیه
                };

                // نمایش تاریخ
                transferArray[7] = String.join("/", dateArray);
                transferArray[8] = String.join(":", timeArray);

                amount.setText(TransferAmount.getText());
                origin.setText(transferArray[2].toString().trim());
                originName.setText(transferArray[3].toString().trim());
                destination.setText(transferArray[4].toString().trim());
                destinationName.setText(transferArray[5].toString().trim());
                trackingNumber.setText(transferArray[6].toString().trim());
                DateLabel.setText(transferArray[7].toString().trim());
                HourLabel.setText(transferArray[8].toString().trim());

                File file = new File("Transfers.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                fw.write("Amount transferred :" + transferArray[0].toString().trim());
                fw.write("\n");
                fw.write("Transfer type :" + transferArray[1].toString().trim());
                fw.write("\n");
                fw.write("destination number :" + transferArray[2].toString().trim());
                fw.write("\n");
                fw.write("destination name :" + transferArray[3].toString().trim());
                fw.write("\n");
                fw.write("Origin number :" + transferArray[4].toString().trim());
                fw.write("\n");
                fw.write("Origin name :" + transferArray[5].toString().trim());
                fw.write("\n");
                fw.write("tracking code :" + transferArray[6].toString().trim());
                fw.write("\n");
                fw.write("Date :" + transferArray[7].toString().trim());
                fw.write("\n");
                fw.write("Time :" + transferArray[8].toString().trim());
                fw.write("\n");
                fw.write("-------------");
                fw.write("\n");
                fw.close();


            } else {
                showAlert("خطا!", "موجودی کافی نیست!");
            }


        } else {
            showAlert("خطا", "کد وارد شده اشتباه است.");
        }

    }
//    public void updateInventory(String userID, int remainingAmount) {
//        String fileName = "userID.txt";
//        List<String> lines = new ArrayList<>();
//
//        try {
//            // خواندن تمام خطوط فایل
//            lines = Files.readAllLines(Paths.get(fileName));
//
//            for (int i = 0; i < lines.size(); i++) {
//                if (lines.get(i).trim().equals("User ID: " + userID)) {
//                    int targetLineIndex = i + 8; // رفتن به خط هشتم
//
//                    if (targetLineIndex < lines.size()) {
//                        // تغییر مقدار inventory
//                        lines.set(targetLineIndex, "inventory Price: " + remainingAmount + "  ريال");
//                    }
//                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
//                }
//            }
//
//            // بازنویسی فایل با مقادیر جدید
//            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
//
//        } catch (IOException e) {
//            System.out.println("خطایی رخ داد: " + e.getMessage());
//        }
//    }

//    public void updateInventory1(String userID, int remainingAmount) {
//        String fileName = "userID.txt";
//        List<String> lines = new ArrayList<>();
//
//        try {
//            // خواندن تمام خطوط فایل
//            lines = Files.readAllLines(Paths.get(fileName));
//
//            for (int i = 0; i < lines.size(); i++) {
//                if (lines.get(i).trim().equals("User ID: " + userID)) {
//                    int targetLineIndex = i + 8; // رفتن به خط هشتم
//
//                    if (targetLineIndex < lines.size()) {
//                        // تغییر مقدار inventory
//                        lines.set(targetLineIndex, "inventory Price: " + remainingAmount + "  ريال");
//                    }
//                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
//                }
//            }
//
//            // بازنویسی فایل با مقادیر جدید
//            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
//
//        } catch (IOException e) {
//            System.out.println("خطایی رخ داد: " + e.getMessage());
//        }
//    }
//
//    private String searchUserinventoryByUserID(String userID) {
//        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
//            String line;
//            String inventory = null;
//
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("User ID: " + userID)) {
//                    // به دنبال نام و نام خانوادگی می‌گردیم
//                    while ((line = reader.readLine()) != null) {
//                        if (line.startsWith("inventory Price:")) {
//                            inventory = line.split(":")[1].trim();
//                        }
//                        if (inventory != null ) {
//                            break;
//                        }
//                    }
//                    return inventory;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    private void takeScreenshot2() {
        try {
            // تعیین محدوده‌ای که باید عکس بگیریم
            int x = 694, y = 360, width = 348, height = 340;
            Robot robot = new Robot();
            Rectangle captureArea = new Rectangle(x, y, width, height);

            // گرفتن اسکرین‌شات
            BufferedImage bufferedImage = robot.createScreenCapture(captureArea);

            // باز کردن پنجره ذخیره‌سازی فایل
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Screenshot");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Image", "*.png"));

            // انتخاب مسیر ذخیره‌سازی
            File file = fileChooser.showSaveDialog(new Stage());

            if (file != null) {
                ImageIO.write(bufferedImage, "png", file);
                System.out.println("Screenshot saved at: " + file.getAbsolutePath());
            } else {
                System.out.println("Saving cancelled.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // متد برای نمایش هشدار
    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //پرداخت قبض
    @FXML
    void payment(ActionEvent event) throws FileNotFoundException {
        String BildID = BillID.getText().trim();
        String PaymentId = PaymentID.getText().trim();
        String status = Findstatus(BildID);
        if (status.split(":")[1].trim().equals("پرداخت نشده")) {
            if (BildID != null && PaymentId != null) {
                String[] Info = SearchBill(BildID, PaymentId);
                if (Info != null) {
                    BillType.setText(Info[0].split(":")[1].trim());
                    BillNameLabel.setText(Info[3].split(":")[1].trim());
                    BillPriceLabel.setText(Info[4].split(":")[1].trim());
                    Bill1.setVisible(false);
                    Bill1.setManaged(false);
                }
            }
        } else {
            showAlert("خطا!", "قبض قبلا پرداخت شده است!");
        }
    }

    private static String[] SearchBill(String BildID, String PaymentID) {
        try {
            FileReader fileReader = new FileReader("Bill.txt");
            Scanner scanner = new Scanner(fileReader);
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.clear(); // هر بار ۱۲ خط جدید بخواند، نه اینکه به قبلی‌ها اضافه کند
                for (int i = 0; i < 13; i++) {
                    lines.add(scanner.nextLine());
                }
                if (lines.get(1).startsWith("Bill ID : " + BildID) && lines.get(2).trim().equals("Payment ID : " + PaymentID)) {
                    return lines.toArray(new String[12]);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        showAlert("خطا", "شناسه قبض یا شناسه پرداخت اشتباه هست !");
        return null;
    }

    @FXML
    void payment1(ActionEvent event) {
        String CardNumber = CardNumber1.getText();
        if (CardNumber == null || CardNumber.isEmpty()) {
            showAlert("خطا", "شماره کارت را وارد کنید !");
        } else {
            CardNumberLabel.setText(CardNumber);
            Bill2.setVisible(false);
            Bill2.setManaged(false);
        }

    }

    @FXML
    void ReceivePassword1(ActionEvent event) {
        String CartNumber = CardNumberLabel.getText();
        String[] data = searchYearMounthCvv2(CartNumber);
        String txtYear = BillYear.getText();
        String txtMonth = BillMonth.getText();
        String cvv2 = BillCVV2.getText();

        if (txtYear.isEmpty() || txtMonth.isEmpty() || cvv2.isEmpty()) {
            showAlert("خطا", "لطفاً سال، ماه و CVV2 را وارد کنید.");
            return; // از ادامه اجرا جلوگیری می‌کنیم
        }

        if (data != null) {
            String Year = data[0];
            String Month = data[1];
            String storedCvv2 = data[2];  // دریافت CVV2 از فایل

            if (Year.equals(txtYear) && Month.equals(txtMonth) && storedCvv2.equals(cvv2)) {
                // جستجو برای پیدا کردن User ID از شماره کارت
                String userID = searchUserIDByCardNumber(CartNumber);
                if (userID != null) {
                    // جستجو برای یافتن نام و نام خانوادگی کاربر
                    String userInfo = searchUserEmail(userID);
                    if (userInfo != null) {
                        String recipient = userInfo; // ایمیل گیرنده
                        sentCode = generateRandomCode();  // تولید کد تصادفی
                        boolean isSent = sendEmail(recipient, sentCode);
                        if (isSent) {
                            showAlert("موفقیت", "رمز پویا به ایمیل شما ارسال گردید !");
                        } else {
                            showAlert("خطا", "ارسال رمز نا موفق!");
                        }
                    } else {
                        showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                    }
                } else {
                    showAlert("خطا", "شماره کارت معتبر نیست.");
                }
            } else {
                showAlert("خطا!", "تاریخ انقضا یا CVV2 اشتباه هست !");
            }
        } else {
            showAlert("خطا!", "تاریخ انقضا یا CVV2 پیدا نشد");
        }
    }

    @FXML
    void payment2(ActionEvent event) throws FileNotFoundException {
        String enteredCode = Password1.getText();  // کد واردشده توسط کاربر از تکست فیلد Password
        String BildID = BillID.getText().trim();
        String PaymentId = PaymentID.getText().trim();

        // بررسی اینکه کد واردشده با کد ارسال‌شده برابر باشد
        if (sentCode != null && sentCode.equals(enteredCode)) {
            String cardNum = CardNumberLabel.getText();
            Double inventoryStr = searchUserinventoryByCardNumber(cardNum);

            if (BildID != null && PaymentId != null) {
                String[] Info = SearchBill(BildID, PaymentId);
                if (Info != null) {
                    String inventoryStr1 = Info[4].split(":")[1].trim();

                    // حذف تمام حروف غیراعداد (مثل "ريال" و فاصله‌های اضافی)
                    String inventoryCleaned1 = inventoryStr1.replaceAll("[^\\d]", "");
                    int inventory1 = Integer.parseInt(inventoryCleaned1);
                    if (inventoryStr >= inventory1) {
                        Double remainingAmount1 = inventoryStr - inventory1;
                        BigDecimal bigDecimal1 = new BigDecimal(remainingAmount1);
                        updateInventoryByCardNumber(cardNum, bigDecimal1);
                        String trakingCode = updateInventory2(Info[1]);

                        LocalDateTime now = LocalDateTime.now();

                        // فرمت تاریخ (مثلاً: 2025-02-27)
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String Date = now.format(dateFormatter);

                        // فرمت زمان (مثلاً: 14:30:45)
                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String Time = now.format(timeFormatter);

                        BillAmount.setText(Info[4].split(":")[1].trim());
                        BillID1.setText(Info[1].split(":")[1].trim());
                        BillID2.setText(Info[2].split(":")[1].trim());
                        DateLabel1.setText(Date);
                        HourLabel1.setText(Time);
                        trackingNumber1.setText(trakingCode);
                        Bill3.setVisible(false);
                        Bill3.setManaged(false);


                    } else {
                        showAlert("خطا!", "موجودی ناکافی است!");
                    }
                }
            }

        } else {
            showAlert("خطا!", "لطفا تمامی فیلد ها را پر کنید!");
        }

    }

    private String Findstatus(String billID) {
        String fileName = "Bill.txt";
        List<String> lines = new ArrayList<>();
        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Bill ID : " + billID)) {
                    int targetLineIndex = i + 6; // رفتن به خط ششم
                    return lines.get(targetLineIndex);
                }
            }

            // بازنویسی فایل با مقادیر جدید
            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            System.out.println("خطایی رخ داد: " + e.getMessage());
        }
        return null;
    }

    public String updateInventory2(String userID) {
        String fileName = "Bill.txt";
        List<String> lines = new ArrayList<>();
        String trakingCode = generateRandomNumber(9);
        String cardNum = CardNumber1.getText();
        // دریافت تاریخ و زمان جاری
        LocalDateTime now = LocalDateTime.now();

        // فرمت تاریخ (مثلاً: 2025-02-27)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String Date = now.format(dateFormatter);

        // فرمت زمان (مثلاً: 14:30:45)
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String Time = now.format(timeFormatter);

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals(userID)) {
                    int targetLineIndex = i + 6; // رفتن به خط ششم
                    System.out.println(lines.get(targetLineIndex));
                    if (targetLineIndex + 4 < lines.size()) {
                        // تغییر مقدار inventory
                        lines.set(targetLineIndex, "Bill payment status : پرداخت شده");
                        lines.set(targetLineIndex + 1, "Bill payment card Number : " + cardNum);
                        lines.set(targetLineIndex + 2, "Bill payment tracking code : " + trakingCode);
                        lines.set(targetLineIndex + 3, "Bill payment date : " + Date);
                        lines.set(targetLineIndex + 4, "Bill payment time : " + Time);

                    }
                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                }
            }

            // بازنویسی فایل با مقادیر جدید
            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            return trakingCode;

        } catch (IOException e) {
            System.out.println("خطایی رخ داد: " + e.getMessage());
        }
        return null;
    }

    // شارژ تلفن همراه

    // آرایه برای ذخیره اطلاعات
    private Object[] charg = new Object[9]; // استفاده از Object به جای long تا امکان مقدار null وجود داشته باشد.

    @FXML
    void charg(ActionEvent event) {
        charg[0] = chargPhoneNumber.getText();
        charg[1] = chargPrice.getSelectionModel().getSelectedItem();
        if (!(chargPhoneNumber.getText().isEmpty()) && charg[1] != null) {
            String[] Info = searchOperatorByPhoneNumber(charg[0].toString());
            if (Info != null) {
                charg[2] = Info[0].split(":")[1].trim();
                charg[3] = Info[1].split(":")[1].trim();

                chargPriceLabel.setText(charg[1].toString().replace("ریال", ""));
                chargPhoneNumber1.setText(charg[0].toString());
                chargOperator.setText(charg[2].toString());
                chargNameLabel.setText(charg[3].toString());

                charg1.setVisible(false);
                charg1.setManaged(false);
            }
        } else {
            showAlert("خطا!", "لطفا تمام فیلد ها را پر کنید!");
        }

    }

    private String[] searchOperatorByPhoneNumber(String phoneNumber) {
        try {
            File file = new File("PhoneInformation.txt");
            FileReader fileReader = new FileReader(file);
            Scanner sc = new Scanner(fileReader);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.startsWith("PhoneNumber : " + phoneNumber)) {
                    return new String[]{sc.nextLine(), sc.nextLine(), sc.nextLine()};
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        showAlert("خطا!", "شماره تلفن یافت نشد یا اشتباه هست!");
        return null;
    }

    @FXML
    void ChargePayment(ActionEvent event) {
        charg[4] = chargCardNumber.getText();
        if (!(chargCardNumber.getText().isEmpty()) && charg[4] != null) {
            String userID = searchUserIDByCardNumber(charg[4].toString());
            if (userID != null) {
                String[] Info = searchUserInfoByUserID(userID);
                charg[5] = Info[0] + " " + Info[1];
                chargeCardNumberLabel.setText(charg[4].toString());

                charg2.setVisible(false);
                charg2.setManaged(false);

                for (int i = 0; i < 6; i++) {
                    System.out.println(charg[i].toString());
                }
            } else {
                showAlert("خطا!", "شماره کارت اشتباه هست!");
            }
        } else {
            showAlert("خطا!", "لطفا شماره کارت را وارد کنید!");
        }

    }

    @FXML
    void BackCharge(ActionEvent event) {
        charg1.setVisible(true);
        charg1.setManaged(true);

    }

    @FXML
    void BackCharge1(ActionEvent event) {
        charg2.setVisible(true);
        charg2.setManaged(true);

    }

    @FXML
    void ReceiveChargePassword(ActionEvent event) {
        String CartNumber = chargeCardNumberLabel.getText();
        String[] data = searchYearMounthCvv2(CartNumber);  // تغییر نام متغیر Date به data
        String txtYear = chargeYear.getText();
        String txtMonth = chargeMonth.getText();
        String cvv2 = chargeCVV2.getText();

        if (txtYear.isEmpty() || txtMonth.isEmpty() || cvv2.isEmpty()) {
            showAlert("خطا", "لطفاً سال، ماه و CVV2 را وارد کنید.");
            return; // از ادامه اجرا جلوگیری می‌کنیم
        }

        if (data != null) {
            String Year = data[0];
            String Month = data[1];
            String storedCvv2 = data[2];  // دریافت CVV2 از فایل

            if (Year.equals(txtYear) && Month.equals(txtMonth) && storedCvv2.equals(cvv2)) {
                // جستجو برای پیدا کردن User ID از شماره کارت
                String userID = searchUserIDByCardNumber(CartNumber);
                if (userID != null) {
                    // جستجو برای یافتن نام و نام خانوادگی کاربر
                    String userInfo = searchUserEmail(userID);
                    if (userInfo != null) {
                        String recipient = userInfo; // ایمیل گیرنده
                        sentCode = generateRandomCode();  // تولید کد تصادفی
                        boolean isSent = sendEmail(recipient, sentCode);
                        if (isSent) {
                            showAlert("موفقیت", "رمز پویا به ایمیل شما ارسال گردید !");
                        } else {
                            showAlert("خطا", "ارسال رمز نا موفق!");
                        }
                    } else {
                        showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                    }
                } else {
                    showAlert("خطا", "شماره کارت معتبر نیست.");
                }
            } else {
                showAlert("خطا!", "تاریخ انقضا یا CVV2 اشتباه هست !");
            }
        } else {
            showAlert("خطا!", "تاریخ انقضا یا CVV2 پیدا نشد");
        }
    }

    @FXML
    void ChargePayment1(ActionEvent event) throws IOException {
        String enteredCode = Password2.getText();  // کد واردشده توسط کاربر از تکست فیلد Password

        // بررسی اینکه کد واردشده با کد ارسال‌شده برابر باشد
        if (sentCode != null && sentCode.equals(enteredCode)) {
            String cardNum = charg[4].toString();
            Double inventoryStr = searchUserinventoryByCardNumber(cardNum);
            String[] Info = searchOperatorByPhoneNumber(charg[0].toString());
            String price = charg[1].toString();
            String price1 = price.replaceAll("[^\\d]", "");
            int price2 = Integer.parseInt(price1);
            if (Info != null) {
                String inventoryStr1 = Info[2].split(":")[1].trim();

                // حذف تمام حروف غیراعداد (مثل "ريال" و فاصله‌های اضافی)
                String inventoryCleaned1 = inventoryStr1.replaceAll("[^\\d]", "");
                int inventory1 = Integer.parseInt(inventoryCleaned1);
                if (inventoryStr >= price2) {
                    Double remainingAmount1 = inventoryStr - price2;
                    BigDecimal bigDecimal1 = new BigDecimal(remainingAmount1);
                    updateInventoryByCardNumber(cardNum, bigDecimal1);
                    updateCharge(charg[0].toString(), price2, inventory1);
                    String trakingCode = generateRandomNumber(9);
                    charg[6] = trakingCode;

                    LocalDateTime now = LocalDateTime.now();

                    // فرمت تاریخ (مثلاً: 2025-02-27)
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String Date = now.format(dateFormatter);

                    // فرمت زمان (مثلاً: 14:30:45)
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String Time = now.format(timeFormatter);

                    charg[7] = Date;
                    charg[8] = Time;

                    amount2.setText(charg[1].toString().replace("ریال", ""));
                    destination2.setText(charg[4].toString());
                    destinationName2.setText(charg[5].toString());
                    destination21.setText(charg[0].toString());
                    destinationName21.setText(charg[2].toString());
                    DateLabel21.setText(charg[7].toString());
                    HourLabel21.setText(charg[8].toString());
                    trackingNumber2.setText(charg[6].toString());
                    FileWriter fw = new FileWriter("PhoneCharge.txt", true);
                    fw.write("Phone Number : " + charg[0].toString() + "\n");
                    fw.write("Charge amount : " + charg[1].toString().replace("ریال", "") + "\n");
                    fw.write("operator Name : " + charg[2].toString() + "\n");
                    fw.write("Phone Number Name: " + charg[3].toString() + "\n");
                    fw.write("Card Number : " + charg[4].toString() + "\n");
                    fw.write("Card Number Name : " + charg[5].toString() + "\n");
                    fw.write("tracking code : " + charg[6].toString() + "\n");
                    fw.write("Date : " + charg[7].toString() + "\n");
                    fw.write("Time : " + charg[8].toString() + "\n");
                    fw.write("-------------" + "\n");
                    fw.close();

                    charg3.setVisible(false);
                    charg3.setManaged(false);


                } else {
                    showAlert("خطا!", "موجودی ناکافی است!");
                }
            }


        } else {
            showAlert("خطا!", "لطفا تمامی فیلد ها را پر کنید!");
        }
    }

    private static void updateCharge(String phoneNumber, Integer price, Integer inventoryCleaned) {
        String fileName = "PhoneInformation.txt";
        List<String> lines = new ArrayList<>();

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("PhoneNumber : " + phoneNumber)) {
                    int targetLineIndex = i + 3; // رفتن به خط هشتم

                    if (targetLineIndex < lines.size()) {
                        // تغییر مقدار inventory
                        lines.set(targetLineIndex, "inventory Price: " + (price + inventoryCleaned) + "  ريال");
                    }
                    break; // بعد از تغییر، نیازی به ادامه جستجو نیست
                }
            }

            // بازنویسی فایل با مقادیر جدید
            Files.write(Paths.get(fileName), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            System.out.println("خطایی رخ داد: " + e.getMessage());

        }
    }

    @FXML
    void chargeEnd(ActionEvent event) {
        charg1.setVisible(true);
        charg2.setVisible(true);
        charg3.setVisible(true);
        charg1.setManaged(true);
        charg2.setManaged(true);
        charg3.setManaged(true);

    }

    private List<Deposit> deposits = new ArrayList<>();

    private List<Deposit> getData() {
        List<Deposit> deposits = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File depositFile = new File("userID.txt");
            Scanner reader1 = new Scanner(depositFile);
            while (reader1.hasNextLine()) {
                if (reader1.nextLine().startsWith("User ID: " + userID)) {
                    Deposit deposit = new Deposit();
                    deposit.setdepostNumber(extractValue(reader1.nextLine()));
                    deposit.setShebaNumer(extractValue(reader1.nextLine()));
                    reader1.nextLine();
                    reader1.nextLine();
                    reader1.nextLine();
                    reader1.nextLine();
                    String Type = extractValue(reader1.nextLine());
                    deposit.setDepositName(Type);
                    deposit.setDepositType(FindType(Type));
                    deposit.setInventory(extractValue(reader1.nextLine()));
                    deposit.setDepositDate(extractValue(reader1.nextLine()));
                    reader1.nextLine();
                    deposits.add(deposit);
                }
            }
            reader1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return deposits;
    }

    private String FindType(String depositName) {
        if (depositName.equals("سپرده سرمایه گذاری بلند مدت")) {
            return "یک ساله";
        } else if (depositName.equals("سپرده سرمایه گذاری کوتاه مدت")) {
            return "یک ساله";
        } else if (depositName.equals("سپرده قرض الحسنه جاری")) {
            ;
            return "یک ساله";
        } else if (depositName.equals("سچرده قرض الحسنه بلند مدت")) {
            return "یک ساله";
        }
        System.out.println("2");
        return null;
    }

    private String findUserID(String username) {
        try {
            if (username != null) {
                FileReader fr = new FileReader("users.txt");
                Scanner reader = new Scanner(fr);
                while (reader.hasNextLine()) {
                    if (reader.nextLine().equals(username)) {
                        reader.nextLine();
                        String Id = reader.nextLine();
                        return Id;
                    }

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

//    // تابع برای استخراج مقادیر از خط‌ها
//    private String extractValue(String line) {
//        // فرض بر این است که حرف اضافه با دو نقطه (: ) تمام می‌شود.
//        if (line.contains(":")) {
//            return line.split(":")[1].trim();  // مقدار بعد از ":" را گرفته و فضای اضافی را حذف می‌کنیم.
//        }
//        return line.trim();  // در صورتی که ":" وجود نداشت، کل خط را trim می‌کنیم.
//    }

    // تابع برای استخراج مقادیر از خط‌ها
    private String extractValue(String line) {
        // فرض بر این است که حرف اضافه با دو نقطه (: ) تمام می‌شود.
        int colonIndex = line.indexOf(":");
        if (colonIndex != -1) {
            return line.substring(colonIndex + 1).trim();  // کل مقدار بعد از اولین ":" را می‌گیرد.
        }
        return line.trim();  // در صورتی که ":" وجود نداشت، کل خط را trim می‌کنیم.
    }


    private void LoadUser() {
        grid.getChildren().clear();
        deposits.clear();
        deposits.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (Deposit deposit : deposits) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/depositItem.fxml"));
                VBox anchorPane = fxmlLoader.load();
                depositItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(deposit);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Card> cards = new ArrayList<>();

    public List<Card> getData1() {
        List<Card> cards = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File cartFile = new File("userID.txt");
            Scanner reader = new Scanner(cartFile);
            while (reader.hasNextLine()) {
                if (reader.nextLine().startsWith("User ID: " + userID)) {
                    Card card = new Card();
                    card.setDepositNum(extractValue(reader.nextLine()));
                    card.setShebaNum(extractValue(reader.nextLine()));
                    card.setCardNum(extractValue(reader.nextLine()));
                    if (card.getCardNum().isEmpty()) {
                        break;
                    } else if (card.getCardNum().startsWith("#")) {
                        card.setCardNum("کارت مسدود شده است !");
                    }
                    reader.nextLine();
                    // خواندن تاریخ انقضا
                    String expirationDate = extractValue(reader.nextLine()); // "08-06"
                    String[] parts = expirationDate.split("/");
                    if (parts.length == 2) {
                        card.setMonth(parts[1]);  // مقدار ماه (08)
                        card.setyear(parts[0]);   // مقدار سال (06)
                    }
                    reader.nextLine();
                    reader.nextLine();
                    card.setInventory(extractValue(reader.nextLine()));
                    reader.nextLine();
                    reader.nextLine();
                    cards.add(card);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cards;
    }


    public void LoadUser1() {
        Platform.runLater(() -> {
            grid1.getChildren().clear();
            cards.clear();
            cards.addAll(getData1());

            int column = 0;
            int row = 1;
            try {
                for (Card card : cards) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/cartItem.fxml"));
                    VBox anchorPane = fxmlLoader.load();
                    cartitemController cartItemController = fxmlLoader.getController();
                    cartItemController.setData(card);

                    if (column == 1) {
                        column = 0;
                        row++;
                    }

                    grid1.add(anchorPane, column++, row);
                    grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid1.setMaxWidth(Region.USE_PREF_SIZE);

                    grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid1.setMaxHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(10));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    @FXML
    private void ezdevajinfo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ezdevaj.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            EzdevajController ezdevajController = loader.getController();
            ezdevajController.setUsername(username12.getText());
            stage.setTitle("تسهیلات");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void maskaninfo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/maskan.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            MaskanController maskanController = loader.getController();
            maskanController.setUsername(username12.getText());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void garzinfo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/garz.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            GarzController garzController = loader.getController();
            garzController.setUsername(username12.getText());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Transfer> Bills = new ArrayList<>();

    private List<Transfer> getDataBillTransfer() {
        List<Transfer> transfers = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File userIDFile = new File("userID.txt");
            File BillFile = new File("Bill.txt");
            Scanner reader = new Scanner(BillFile);
            while (reader.hasNextLine()) {
                String Type = " پرداخت قبض " + extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String amount = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                String Date = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                String userid = searchUserIDByCardNumber(cardNumber);
                String userid1 = searchUserIDByCardNumber( '#' + cardNumber);

                if(userid != null ) {
                    if (userid.equals(userID)) {
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);


                    }
                }else if(userid1 != null) {

                    if (userid1.equals(userID)) {
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);

                    }
                }


            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File userIDFile = new File("userID.txt");
            File PhoneChargeFile = new File("PhoneCharge.txt");
            Scanner reader = new Scanner(PhoneChargeFile);
            while (reader.hasNextLine()) {
                reader.nextLine();
                String amount = extractValue(reader.nextLine());
                String Type = " شارژ تلفن همراه " + extractValue(reader.nextLine());
                reader.nextLine();
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                String Date = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());

                reader.nextLine();
                String userid = searchUserIDByCardNumber(cardNumber);
                String userid1 = searchUserIDByCardNumber('#'+cardNumber);
                if(userid != null) {
                    if (userid.equals(userID)) {
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);
                    }
                }else if(userid1 != null) {
                    if(userid1.equals(userID)){
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);
                    }
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File userIDFile = new File("userID.txt");
            File DepositsFile = new File("Deposits.txt");
            Scanner reader = new Scanner(DepositsFile);
            while (reader.hasNextLine()) {
                String amount = extractValue(reader.nextLine());
                String Type = extractValue(reader.nextLine());
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                String Date = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                String userid = searchUserIDByAccountNumber(cardNumber);

                if(userid != null ) {
                if (userid.equals(userID)) {
                    Transfer transfer = new Transfer();
                    transfer.setAmount(amount);
                    transfer.setType(Type);
                    transfer.setDate(Date);
                    transfer.setTime(Time);
                    transfers.add(transfer);

                }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File userIDFile = new File("userID.txt");
            File TransfersFile = new File("Transfers.txt");
            Scanner reader = new Scanner(TransfersFile);
            while (reader.hasNextLine()) {
                String amount = extractValue(reader.nextLine());
                String Type = "برداشت از کارت ";
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                String Date = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                String userid = searchUserIDByCardNumber(cardNumber);
                String userid1 = searchUserIDByCardNumber('#'+ cardNumber);
                if(userid != null  ) {
                    if (userid.equals(userID)) {
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);
                    }
                }else if(userid1 != null) {
                 if(userid1.equals(userID)){
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File userIDFile = new File("userID.txt");
            File TransfersFile = new File("Transfers.txt");
            Scanner reader = new Scanner(TransfersFile);
            while (reader.hasNextLine()) {
                String amount = extractValue(reader.nextLine());
                String Type1 = extractValue(reader.nextLine());
                String Type ="واریز به " + Type1;
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String Date = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                String userid = null;
                String userid1 = searchUserIDByCardNumber('#'+ cardNumber);
                if (Type1.equals("کارت")){
                    userid = searchUserIDByCardNumber(cardNumber);
                }else if(Type1.equals("سپرده")){
                    userid = searchUserIDByAccountNumber(cardNumber);
                }else if(Type1.equals("شبا")){
                    userid = searchUserIDByShabaNumber(cardNumber);
                }
                if(userid != null) {
                    if (userid.equals(userID)) {
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);
                    }
                }else if(userid1 != null) {
                 if(userid1.equals(userID)){
                        Transfer transfer = new Transfer();
                        transfer.setAmount(amount);
                        transfer.setType(Type);
                        transfer.setDate(Date);
                        transfer.setTime(Time);
                        transfers.add(transfer);
                    }
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return transfers;
    }


    public void LoadUserBillTransfer() {

        grid3.getChildren().clear();
        Bills.clear();
        Bills.addAll(getDataBillTransfer());

        int column = 0;
        int row = 1;
        try {
            for (Transfer transfer : Bills) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/transferItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                transferItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(transfer);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid3.add(anchorPane, column++, row);
                grid3.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid3.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid3.setMaxWidth(Region.USE_PREF_SIZE);

                grid3.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid3.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid3.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchTransfer(ActionEvent event) throws FileNotFoundException {
        String Type  = transferType.getSelectionModel().getSelectedItem();
        LocalDate aDate = ADate.getValue();
        LocalDate tDate = TDate.getValue();
        String code = CodeRahgery.getText();
        if (Type == null || Type.isEmpty() ||
                aDate == null ||
                tDate == null ||
                code == null || code.trim().isEmpty()) {

            // ساختن پیام هشدار
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("خطا");
            alert.setHeaderText(null);
            alert.setContentText("لطفاً همه‌ی فیلدها را کامل کنید.");
            alert.showAndWait();
            return; // ادامه نده
        }else{
            switch (Type.trim()) {
                case "پرداخت قبض":
                    LoadBillTransfer();
                    break;
                case "شارژ تلفن همراه":
                    loadPhoneTransfers();
                    break;
                case "برداشت از کارت":
                    loadBardashtTransfers();
                    break;
                case "واریز به کارت":
                    loadVarizTransfers();
                    break;
                case "واریز به سپرده":
                    loadVarizTransfers();
                    break;
                case "واریز به شبا":
                    loadVarizTransfers();
                    break;
                default:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("نوع انتقال نامعتبر");
                    alert.setContentText("نوع انتقال شناخته نشد.");
                    alert.showAndWait();
                    break;
            }
        }
    }

    List<Transfer> Filter = new ArrayList<>();

    private List<Transfer> GetBillTransfer() {
        String code = CodeRahgery.getText();
        LocalDate aDate = ADate.getValue();
        LocalDate tDate = TDate.getValue();
        List<Transfer> transfers = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File BillFile = new File("Bill.txt");
            Scanner reader = new Scanner(BillFile);
            while (reader.hasNextLine()) {
                String Type = " پرداخت قبض " + extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String amount = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String cardNumber = extractValue(reader.nextLine());
                String codeRahgery = extractValue(reader.nextLine());
                String dateStr  = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                LocalDate transferDate;
                try {
                    transferDate = LocalDate.parse(dateStr); // فرض بر اینکه تاریخ در فرمت yyyy-MM-dd باشه
                } catch (Exception e) {
                    continue; // اگر تاریخ قابل تبدیل نبود، بی‌خیال اون ردیف می‌شیم
                }
                String userid = searchUserIDByCardNumber(cardNumber);
                String userid1 = searchUserIDByCardNumber( '#' + cardNumber);


                boolean isUserMatch = (userid != null && userid.equals(userID)) ||
                        (userid1 != null && userid1.equals(userID));
                boolean isCodeMatch = codeRahgery.equals(code);
                boolean isDateInRange = (transferDate != null && !transferDate.isBefore(aDate) && !transferDate.isAfter(tDate));

                if (isUserMatch && isCodeMatch && isDateInRange) {
                    Transfer transfer = new Transfer();
                    transfer.setAmount(amount);
                    transfer.setType(Type);
                    transfer.setDate(dateStr);
                    transfer.setTime(Time);
                    transfers.add(transfer);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return transfers;
    }

    private List<Transfer> GetPhoneTransfers() {
        String code = CodeRahgery.getText();
        LocalDate aDate = ADate.getValue();
        LocalDate tDate = TDate.getValue();
        List<Transfer> transfers = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File PhoneChargeFile = new File("PhoneCharge.txt");
            Scanner reader = new Scanner(PhoneChargeFile);
            while (reader.hasNextLine()) {
                reader.nextLine();
                String amount = extractValue(reader.nextLine());
                String Type = " شارژ تلفن همراه " + extractValue(reader.nextLine());
                reader.nextLine();
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                String codeRahgery = extractValue(reader.nextLine());
                String dateStr = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());

                reader.nextLine();
                LocalDate transferDate;
                try {
                    transferDate = LocalDate.parse(dateStr); // فرض بر اینکه تاریخ در فرمت yyyy-MM-dd باشه
                } catch (Exception e) {
                    continue; // اگر تاریخ قابل تبدیل نبود، بی‌خیال اون ردیف می‌شیم
                }
                String userid = searchUserIDByCardNumber(cardNumber);
                String userid1 = searchUserIDByCardNumber('#'+cardNumber);
                boolean isUserMatch = (userid != null && userid.equals(userID)) ||
                        (userid1 != null && userid1.equals(userID));
                boolean isCodeMatch = codeRahgery.equals(code);
                boolean isDateInRange = (transferDate != null && !transferDate.isBefore(aDate) && !transferDate.isAfter(tDate));

                if (isUserMatch && isCodeMatch && isDateInRange) {
                    Transfer transfer = new Transfer();
                    transfer.setAmount(amount);
                    transfer.setType(Type);
                    transfer.setDate(dateStr);
                    transfer.setTime(Time);
                    transfers.add(transfer);
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return transfers;
    }

    private List<Transfer> GetBardashtTransfers() {
        String code = CodeRahgery.getText();
        LocalDate aDate = ADate.getValue();
        LocalDate tDate = TDate.getValue();
        List<Transfer> transfers = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File userIDFile = new File("userID.txt");
            File TransfersFile = new File("Transfers.txt");
            Scanner reader = new Scanner(TransfersFile);
            while (reader.hasNextLine()) {
                String amount = extractValue(reader.nextLine());
                String Type = "برداشت از کارت ";
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                String codeRahgery = extractValue(reader.nextLine());
                String dateStr = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                LocalDate transferDate;
                try {
                    transferDate = LocalDate.parse(dateStr); // فرض بر اینکه تاریخ در فرمت yyyy-MM-dd باشه
                } catch (Exception e) {
                    continue; // اگر تاریخ قابل تبدیل نبود، بی‌خیال اون ردیف می‌شیم
                }
                String userid = searchUserIDByCardNumber(cardNumber);
                String userid1 = searchUserIDByCardNumber('#'+ cardNumber);
                boolean isUserMatch = (userid != null && userid.equals(userID)) ||
                        (userid1 != null && userid1.equals(userID));
                boolean isCodeMatch = codeRahgery.equals(code);
                boolean isDateInRange = (transferDate != null && !transferDate.isBefore(aDate) && !transferDate.isAfter(tDate));

                if (isUserMatch && isCodeMatch && isDateInRange) {
                    Transfer transfer = new Transfer();
                    transfer.setAmount(amount);
                    transfer.setType(Type);
                    transfer.setDate(dateStr);
                    transfer.setTime(Time);
                    transfers.add(transfer);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return transfers;
    }

    private List<Transfer> GetVarizTransfers() {
        String code = CodeRahgery.getText();
        LocalDate aDate = ADate.getValue();
        LocalDate tDate = TDate.getValue();
        List<Transfer> transfers = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);
            File TransfersFile = new File("Transfers.txt");
            Scanner reader = new Scanner(TransfersFile);
            while (reader.hasNextLine()) {
                String amount = extractValue(reader.nextLine());
                String Type1 = extractValue(reader.nextLine());
                String Type ="واریز به " + Type1;
                String cardNumber = extractValue(reader.nextLine());
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();
                String codeRahgery = extractValue(reader.nextLine());
                String dateStr = extractValue(reader.nextLine());
                String Time = extractValue(reader.nextLine());
                reader.nextLine();
                LocalDate transferDate;
                try {
                    transferDate = LocalDate.parse(dateStr); // فرض بر اینکه تاریخ در فرمت yyyy-MM-dd باشه
                } catch (Exception e) {
                    continue; // اگر تاریخ قابل تبدیل نبود، بی‌خیال اون ردیف می‌شیم
                }
                String userid = null;
                String userid1 = searchUserIDByCardNumber('#'+ cardNumber);
                if (Type1.equals("کارت")){
                    userid = searchUserIDByCardNumber(cardNumber);
                }else if(Type1.equals("سپرده")){
                    userid = searchUserIDByAccountNumber(cardNumber);
                }else if(Type1.equals("شبا")){
                    userid = searchUserIDByShabaNumber(cardNumber);
                }
                boolean isUserMatch = (userid != null && userid.equals(userID)) ||
                        (userid1 != null && userid1.equals(userID));
                boolean isCodeMatch = codeRahgery.equals(code);
                boolean isDateInRange = (transferDate != null && !transferDate.isBefore(aDate) && !transferDate.isAfter(tDate));

                if (isUserMatch && isCodeMatch && isDateInRange) {
                    Transfer transfer = new Transfer();
                    transfer.setAmount(amount);
                    transfer.setType(Type);
                    transfer.setDate(dateStr);
                    transfer.setTime(Time);
                    transfers.add(transfer);
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return transfers;
    }


    public void LoadBillTransfer() {

        grid3.getChildren().clear();
        Filter.clear();
        Filter.addAll(GetBillTransfer());

        int column = 0;
        int row = 1;
        try {
            for (Transfer transfer : Filter) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/transferItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                transferItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(transfer);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid3.add(anchorPane, column++, row);
                grid3.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid3.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid3.setMaxWidth(Region.USE_PREF_SIZE);

                grid3.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid3.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid3.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPhoneTransfers() {

        grid3.getChildren().clear();
        Filter.clear();
        Filter.addAll(GetPhoneTransfers());

        int column = 0;
        int row = 1;
        try {
            for (Transfer transfer : Filter) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/transferItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                transferItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(transfer);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid3.add(anchorPane, column++, row);
                grid3.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid3.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid3.setMaxWidth(Region.USE_PREF_SIZE);

                grid3.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid3.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid3.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBardashtTransfers() {

        grid3.getChildren().clear();
        Filter.clear();
        Filter.addAll(GetBardashtTransfers());

        int column = 0;
        int row = 1;
        try {
            for (Transfer transfer : Filter) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/transferItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                transferItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(transfer);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid3.add(anchorPane, column++, row);
                grid3.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid3.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid3.setMaxWidth(Region.USE_PREF_SIZE);

                grid3.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid3.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid3.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadVarizTransfers() {

        grid3.getChildren().clear();
        Filter.clear();
        Filter.addAll(GetVarizTransfers());

        int column = 0;
        int row = 1;
        try {
            for (Transfer transfer : Filter) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/transferItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                transferItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(transfer);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid3.add(anchorPane, column++, row);
                grid3.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid3.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid3.setMaxWidth(Region.USE_PREF_SIZE);

                grid3.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid3.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid3.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleImageClick(MouseEvent event) {
        VboxLabel.setVisible(true);
        mainvbox.setVisible(false);
        requestCheckVBox.setVisible(false);
        CheckregistrationVbox.setVisible(false);
        CheckConfirmation.setVisible(false);
    }


    @FXML
    private void handleNextAction() {
        String checkIdText = checkId.getText();
        if (checkIdText == null) {
            showAlert("خطا", "لطفاً شناسه چک را وارد کنید.");
        } else if (checkIdText.length() != 16 || !checkIdText.matches("\\d+")) {
            showAlert("خطا", "شناسه چک باید 16 رقمی و فقط عدد باشد.");
        } else {
            first.setVisible(false);
            second.setVisible(true);
        }
    }

    @FXML
    private void handleSecondNext() {
        String accNum = checkaccnum.getText();
        String serial = serialnum.getText();
        String series = seriesnum.getText();
        String amount = checkamount.getText();
        LocalDate checkDate = date.getValue();

        if (accNum == null || serial == null || series == null
                || amount == null || checkDate == null) {
            showAlert("خطا", "لطفاً تمامی اطلاعات را وارد کنید.");
            return;
        }

        if (accNum.length() != 14 || !accNum.matches("\\d+")) {
            showAlert("خطا", "شماره حساب باید 14 رقمی باشد.");
            return;
        }
        if (serial.length() != 6 || !serial.matches("\\d+")) {
            showAlert("خطا", "سریال باید 6 رقمی باشد.");
            return;
        }
        if (series.length() != 4 || !series.matches("\\d+")) {
            showAlert("خطا", "سری باید 4 رقمی باشد.");
            return;
        }

        second.setVisible(false);
        third.setVisible(true);
    }

    @FXML
    private void handleBackToFirst() {
        second.setVisible(false);
        first.setVisible(true);
    }

    @FXML
    private void handleBackToSecond() {
        third.setVisible(false);
        second.setVisible(true);
    }

    @FXML
    private void saveCheckInfo() {
        String checkIdText = checkId.getText();
        String accNum = checkaccnum.getText();
        String serial = serialnum.getText();
        String series = seriesnum.getText();
        String amount = checkamount.getText();
        LocalDate checkDate = date.getValue();
        String nCode = nationalcode.getText();


        if (checkIdText == null || checkIdText.isEmpty() ||
                accNum == null || accNum.isEmpty() ||
                serial == null || serial.isEmpty() ||
                series == null || series.isEmpty() ||
                amount == null || amount.isEmpty() ||
                checkDate == null ||
                nCode == null || nCode.isEmpty()) {

            showAlert("خطا", "لطفاً تمامی اطلاعات را وارد کنید.");
            return;
        }

        saveCheckInfoToFile(checkIdText, accNum, serial, series, amount, checkDate.toString(), nCode);

        checkId.clear();
        checkaccnum.clear();
        serialnum.clear();
        seriesnum.clear();
        checkamount.clear();
        nationalcode.clear();
        date.setValue(null);

        third.setVisible(false);
        first.setVisible(true);

        showAlert("موفقیت", "اطلاعات چک با موفقیت ذخیره شد.");
    }


    private void saveCheckInfoToFile(String checkId, String accountNumber, String serial, String series, String amount, String date, String nationalCode) {
        String filePath = "checkinfo.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Type: ثبت چک"); // مقداردهی به Type
            writer.newLine();
            writer.write("checkId: " + checkId);
            writer.newLine();
            writer.write("accountNumber: " + accountNumber);
            writer.newLine();
            writer.write("serial: " + serial);
            writer.newLine();
            writer.write("seri: " + series);
            writer.newLine();
            writer.write("amount: " + amount);
            writer.newLine();
            writer.write("due date: " + date);
            writer.newLine();
            writer.write("nationalCode: " + nationalCode);
            writer.newLine();

            // تاریخ و ساعت فعلی سیستم
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            writer.write("Date: " + now.format(dateFormatter)); // ذخیره تاریخ
            writer.newLine();
            writer.write("Time: " + now.format(timeFormatter)); // ذخیره ساعت و دقیقه
            writer.newLine();
            writer.write("----------------------------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("خطا", "خطا در ذخیره اطلاعات در فایل!");
        }
    }


    @FXML
    private void checkCheckInfo() {
        String checkId = IDCheck.getText().trim();
        String nationalCode = codenational.getText().trim();

        if (checkId.isEmpty() || nationalCode.isEmpty()) {
            showAlert("خطا", "لطفاً تمامی فیلدها را پر کنید.");
            return;
        }

        // بررسی اینکه کاربر لاگین‌شده همان کسی است که کد ملی واردشده متعلق به اوست
        String currentUserId = getCurrentUserID(); // از userID.txt
        String userIdFromNationalCode = getUserIdByNationalCode(nationalCode); // از users.txt

        if (userIdFromNationalCode == null || !userIdFromNationalCode.equals(currentUserId)) {
            showAlert("خطا", "اطلاعات نامعتبر است.");
            return;
        }

        // بررسی اینکه چک قبلاً تایید یا رد نشده باشد
        if (isCheckProcessed(checkId)) {
            showAlert("خطا", "اطلاعات مورد نظر یافت نشد.");
            return;
        }

        IDCheck.clear();
        codenational.clear();

        if (loadCheckInfoFromFile(checkId, nationalCode)) {
            lblCheckId.setText(checkId);
            lblNationalCode.setText(nationalCode);

            vbox1.setVisible(false);
            checkgrid.setVisible(true);
        } else {
            showAlert("خطا", "اطلاعات موردنظر یافت نشد.");
        }
    }

    private String getCurrentUserID() {
        File file = new File("userID.txt");
        if (!file.exists()) return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine(); // فرض بر اینکه فقط یک خط داره و همون آیدی کاربر فعلیه
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getUserIdByNationalCode(String nationalCode) {
        File file = new File("users.txt");
        if (!file.exists()) return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String userNationalCode = parts[0].trim(); // فرض: کد ملی در ستون اول
                    String userId = parts[2].trim(); // فرض: آیدی کاربر در ستون سوم
                    if (userNationalCode.equals(nationalCode)) {
                        return userId;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //متذ یررسی اینکه قبلا تایید یا رد شده یا نه
    private boolean isCheckProcessed(String checkId) {
        return isCheckInFile("checkconfirm.txt", checkId) || isCheckInFile("checkrejection.txt", checkId);
    }

    private boolean isCheckInFile(String fileName, String checkId) {
        File file = new File(fileName);

        if (!file.exists()) {
            return false; // اگر فایل وجود ندارد، نیازی به بررسی نیست
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("checkId: " + checkId)) { // بررسی وجود checkId در فایل
                    return true;
                }
            }
        } catch (IOException e) {
            showAlert("خطا", "خطا در خواندن فایل: " + fileName);
        }

        return false;
    }

    private boolean loadCheckInfoFromFile(String checkId, String nationalCode) {
        String filePath = "checkinfo.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String checkIdFromFile = null;
            String serial = null;
            String series = null;
            String amount = null;
            String date = null;
            String nationalCodeFromFile = null;

            while ((line = reader.readLine()) != null) {
                // بررسی هر خط از فایل
                if (line.startsWith("checkId:") && line.substring(8).trim().equals(checkId)) {
                    checkIdFromFile = line.substring(8).trim();
                } else if (line.startsWith("serial:")) {
                    serial = line.substring(7).trim();
                } else if (line.startsWith("seri:")) {
                    series = line.substring(5).trim();
                } else if (line.startsWith("amount:")) {
                    amount = line.substring(7).trim();
                } else if (line.startsWith("date:")) {
                    date = line.substring(5).trim();
                } else if (line.startsWith("nationalCode:") && line.substring(13).trim().equals(nationalCode)) {
                    nationalCodeFromFile = line.substring(13).trim();
                }

                if (checkIdFromFile != null && nationalCodeFromFile != null) {
                    lblCheckId.setText(checkIdFromFile);
                    lblSerial.setText(serial);
                    lblSeries.setText(series);
                    lblAmount.setText(amount);
                    lblDate.setText(date);
                    lblNationalCode.setText(nationalCodeFromFile);

                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @FXML
    private void handleConfirmButtonClick() {
        String checkId = lblCheckId.getText();
        String serial = lblSerial.getText();
        String series = lblSeries.getText();
        String amount = lblAmount.getText();
        String date = lblDate.getText();
        String nationalCode = lblNationalCode.getText();

        File file = new File("checkconfirm.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Type: تایید چک"); // مقداردهی به Type
            writer.newLine();
            writer.write("checkId: " + checkId + "\n");
            writer.write("serial: " + serial + "\n");
            writer.write("series: " + series + "\n");
            writer.write("amount: " + amount + "\n");
            writer.write("due date: " + date + "\n");
            writer.write("nationalCode: " + nationalCode + "\n");

            // تاریخ و ساعت فعلی سیستم
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            writer.write("Date: " + now.format(dateFormatter)); // ذخیره تاریخ
            writer.newLine();
            writer.write("Time: " + now.format(timeFormatter)); // ذخیره ساعت و دقیقه
            writer.newLine();
            writer.write("----------------------------------\n");

            showAlert("Success", "چک با موفقیت ثبت شد!");
        } catch (IOException e) {
            showAlert("Error", "خطا در ذخیره اطلاعات در فایل!");
        }
        IDCheck.clear();
        codenational.clear();
        vbox1.setVisible(true);

        lblCheckId.setText("");
        lblSerial.setText("");
        lblSeries.setText("");
        lblAmount.setText("");
        lblDate.setText("");
        lblNationalCode.setText("");
        checkgrid.setVisible(false);

    }

    @FXML
    private void handleRejectionButtonClick() {
        String checkId = lblCheckId.getText();
        String serial = lblSerial.getText();
        String series = lblSeries.getText();
        String amount = lblAmount.getText();
        String date = lblDate.getText();
        String nationalCode = lblNationalCode.getText();

        File file = new File("checkrejection.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Type: رد چک"); // مقداردهی به Type
            writer.newLine();
            writer.write("checkId: " + checkId + "\n");
            writer.write("serial: " + serial + "\n");
            writer.write("series: " + series + "\n");
            writer.write("amount: " + amount + "\n");
            writer.write("due date: " + date + "\n");
            writer.write("nationalCode: " + nationalCode + "\n");

            // تاریخ و ساعت فعلی سیستم
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            writer.write("Date: " + now.format(dateFormatter)); // ذخیره تاریخ
            writer.newLine();
            writer.write("Time: " + now.format(timeFormatter)); // ذخیره ساعت و دقیقه
            writer.newLine();
            writer.write("----------------------------------\n");

            showAlert("Success", "چک با موفقیت رد شد!");
        } catch (IOException e) {
            showAlert("Error", "خطا در ذخیره اطلاعات در فایل!");
        }
        IDCheck.clear();
        codenational.clear();
        vbox1.setVisible(true);

        lblCheckId.setText("");
        lblSerial.setText("");
        lblSeries.setText("");
        lblAmount.setText("");
        lblDate.setText("");
        lblNationalCode.setText("");
        checkgrid.setVisible(false);


    }

    @FXML
    private void saveCheckRequest() {
        String name = nameField.getText();
        String accountNumber = accountNumberField.getText();
        String accountType = accountTypeComboBox.getValue();
        Integer checkPages = checkPagesComboBox.getValue();
        String postalCode = postalCodeField.getText();
        String phone = phoneField.getText();
        String ID = nationalID.getText();


        if (name.isEmpty() || accountNumber.isEmpty() || accountType == null || checkPages == null ||
                postalCode.isEmpty() || phone == null || ID.isEmpty()) {
            showAlert("لطفاً تمامی اطلاعات را پر کنید!");
            return;
        }

        if (!isAccountDataValid(accountNumber, accountType)) {
            showAlert("اطلاعات نامعتبر!");
            return;
        }


        if (!accountNumber.matches("\\d{14}")) {
            showAlert("شماره حساب باید ۱۴ رقم باشد!");
            return;
        }


        if (!postalCode.matches("\\d{10}")) {
            showAlert("کد پستی باید ۱۰ رقم باشد!");
            return;
        }


        if (!phone.matches("09\\d{9}")) {
            showAlert("شماره موبایل باید ۱۱ رقم باشد و با 09 شروع شود!");
            return;
        }

        // تولید شماره پیگیری ۴ رقمی
        String trackingNumber = generateTrackingNumber();

        saveToFile(name, accountNumber, accountType, checkPages, postalCode, phone, ID, trackingNumber);


        showAlert("درخواست شما با موفقیت ثبت شد!\nشماره پیگیری: " + trackingNumber);
        clearFields();

        requestCheckVBox.setVisible(false);
        mainvbox.setVisible(false);
        VboxLabel.setVisible(true);
    }

    private boolean isAccountDataValid(String accNumber, String accType) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            List<String> blockLines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("---------------")) {
                    // بررسی یک بلاک کامل
                    if (blockLines.size() >= 8) {
                        String line2 = blockLines.get(1).trim(); // Account Number
                        String line8 = blockLines.get(7).trim(); // Account Type

                        String accNumFromFile = line2.split(":")[1].trim();
                        String accTypeFromFile = line8.split(":")[1].trim();

                        if (accNumber.equals(accNumFromFile) && accType.equals(accTypeFromFile)) {
                            return true; // پیدا شد
                        }
                    }
                    blockLines.clear(); // شروع بلاک جدید
                } else {
                    blockLines.add(line);
                }
            }

            // بررسی آخرین بلاک (در صورت نبودن --------------- در انتها)
            if (blockLines.size() >= 8) {
                String line2 = blockLines.get(1).trim();
                String line8 = blockLines.get(7).trim();

                String accNumFromFile = line2.split(":")[1].trim();
                String accTypeFromFile = line8.split(":")[1].trim();

                if (accNumber.equals(accNumFromFile) && accType.equals(accTypeFromFile)) {
                    return true;
                }
            }

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return false;
    }



    private void clearFields() {
        nameField.clear();
        accountNumberField.clear();
        accountTypeComboBox.setValue(null);
        checkPagesComboBox.setValue(null);
        postalCodeField.clear();
        phoneField.clear();
        nationalID.clear();
    }


    private void saveToFile(String name, String accountNumber, String accountType, Integer checkPages, String postalCode, String phone, String nationalID, String trackingNumber) {
        String filePath = "checkrequest.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Type: " + "درخواست دسته چک");
            writer.newLine();
            writer.write("name: " + name);
            writer.newLine();
            writer.write("accountnumber: " + accountNumber);
            writer.newLine();
            writer.write("accounttype: " + accountType);
            writer.newLine();
            writer.write("checkpages: " + checkPages);
            writer.newLine();
            writer.write("postcode: " + postalCode);
            writer.newLine();
            writer.write("phonenumber: " + phone);
            writer.newLine();
            writer.write("nationalcpde: " + nationalID);
            writer.newLine();

            // ثبت تاریخ و زمان
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            writer.write("Date: " + now.format(dateFormatter));
            writer.newLine();
            writer.write("Time: " + now.format(timeFormatter));
            writer.newLine();
            writer.write("trackingnumber: " + trackingNumber);
            writer.newLine();
            writer.write("status: " + "");
            writer.newLine();
            writer.write("----------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("خطا در ذخیره اطلاعات در فایل!");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("پیام");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private String generateTrackingNumber() {
        Random random = new Random();
        int trackingNumber = 1000 + random.nextInt(9000); // عدد تصادفی ۴ رقمی بین 1000 تا 9999
        return String.valueOf(trackingNumber);
    }

    private String getField(List<String> block, String fieldName) {
        for (String line : block) {
            if (line.startsWith(fieldName + ":")) {
                return line.substring(line.indexOf(":") + 1).trim();
            }
        }
        return "";
    }

    private String getCurrentUserId() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            reader.readLine(); // username
            reader.readLine(); // password
            return reader.readLine().trim(); // user ID
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getAccountNumberByUserId(String userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            List<String> block = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.equals("---------------")) {
                    String id = getField(block, "User ID");
                    if (userId.equals(id)) {
                        return getField(block, "Account Number");
                    }
                    block.clear();
                } else {
                    block.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    List<CheckHistoryItem> Checks = new ArrayList<>();
    private List<CheckHistoryItem> GetDataCheckHistory() {

        List<CheckHistoryItem> Checks = new ArrayList<>();
        try {
            String userName = username12.getText();
            String userID = findUserID(userName);

            File BillFile = new File("checkrequest.txt");
            Scanner reader = new Scanner(BillFile);
            while (reader.hasNextLine()) {
                CheckHistoryItem Check = new CheckHistoryItem();
                Check.setType(extractValue(reader.nextLine()));
                reader.nextLine();
                String AccountNumber = extractValue(reader.nextLine());
                String userIDUser = searchUserIDByAccountNumber(AccountNumber);
                if(userID.equals(userIDUser)) {
                    for(int i = 0 ; i<5;i++){
                        reader.nextLine();
                    }
                    Check.setDate(extractValue(reader.nextLine()));
                    Check.setTime(extractValue(reader.nextLine()));
                    Check.setCode(extractValue(reader.nextLine()));
                    Check.setStatus(extractValue(reader.nextLine()));
                    reader.nextLine();
                    Checks.add(Check);

                }else {
                    for(int i = 0 ; i<10;i++){
                        reader.nextLine();
                    }
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Checks;
    }

    public void LoadCheckHistory() {

        grid4.getChildren().clear();
        Checks.clear();
        Checks.addAll(GetDataCheckHistory());

        int column = 0;
        int row = 1;
        try {
            for (CheckHistoryItem transfer : Checks) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/CheckhistoryItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CheckhistoryItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(transfer);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid4.add(anchorPane, column++, row);
                grid4.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid4.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid4.setMaxWidth(Region.USE_PREF_SIZE);

                grid4.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid4.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid4.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSearch() {
        String searchCode = searchTextField.getText().trim(); // دریافت کد رهگیری از تکست فیلد

        if (searchCode.isEmpty()) {
            showAlert("لطفاً کد رهگیری را وارد کنید!"); // هشدار اگر فیلد خالی باشد
            return;
        }

        // دریافت داده‌های چک‌ها از فایل
        List<CheckHistoryItem> filteredChecks = new ArrayList<>();
        boolean found = false; // یک متغیر برای بررسی پیدا شدن یا نشدن کد

        for (CheckHistoryItem check : Checks) {
            if (check.getCode().equals(searchCode)) {
                filteredChecks.add(check); // فقط آیتم‌هایی که کد رهگیری مشابه دارند
                found = true; // اگر کد پیدا شد، آن را ثبت می‌کنیم
            }
        }

        // اگر کد پیدا نشد، نمایش پیام خطا
        if (!found) {
            showAlert("کد رهگیری وارد شده پیدا نشد!"); // نمایش خطا به کاربر
        }

        // نمایش آیتم‌های جستجو شده در GridPane
        displayChecksInGrid(filteredChecks);
    }



    // متد برای نمایش چک‌ها در گریدپین
    private void displayChecksInGrid(List<CheckHistoryItem> checks) {
        grid4.getChildren().clear(); // پاک کردن گریدپین از آیتم‌های قبلی

        int column = 0;
        int row = 1;

        for (CheckHistoryItem check : checks) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/CheckhistoryItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load(); // بارگذاری FXML

                CheckhistoryItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(check); // ارسال داده به کنترلر آیتم

                if (column == 6) {
                    column = 0;
                    row++; // اگر به 6 ستون رسیدیم، به ردیف بعدی می‌ریم
                }

                grid4.add(anchorPane, column++, row); // اضافه کردن آیتم به گریدپین
                GridPane.setMargin(anchorPane, new Insets(10)); // تنظیم حاشیه

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // متد برای بازنشانی فیلد جستجو و بازگشت به حالت اولیه
    @FXML
    private void resetSearch(MouseEvent event) {
        searchTextField.clear(); // پاک کردن تکست فیلد
        grid4.getChildren().clear(); // پاک کردن گریدپین

        // بارگذاری همه آیتم‌ها (اگر نیاز دارید دوباره همه آیتم‌ها را نمایش دهید)
        displayChecksInGrid(Checks);
    }



}