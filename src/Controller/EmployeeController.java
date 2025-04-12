package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
//import javafx.scene.robot.Robot;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Card;
import model.Deposit;
import model.User;
import service.findInformation;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;


import static main.Main.CURRENCY;
import static service.findInformation.*;

public class EmployeeController {
    @FXML
    private TextField AccNum;

    @FXML
    private ComboBox<String> AccType;

    @FXML
    private ComboBox<String> type;

    @FXML
    private DatePicker BirthDate;

    @FXML
    private TextField CVV2Num;

    @FXML
    private TextField CardNum1;

    @FXML
    private TextField CardNum2;

    @FXML
    private TextField CardNum3;

    @FXML
    private TextField CardNum4;

    @FXML
    private TextField CardPass;

    @FXML
    private DatePicker ExpDate;

    @FXML
    private TextField NationalCode;

    @FXML
    private Label Role;

    @FXML
    private TextField ShabaNum;

    @FXML
    private TextField USFName;

    @FXML
    private TextField USLname;

    @FXML
    private TextField CardNumber;

    @FXML
    private TextField CardNumber1;

    @FXML
    private TextField CardNumber2;

    @FXML
    private TextField DepositNumber;

    @FXML
    private TextField ShabaNumber;

    @FXML
    private TextField inventory;

    @FXML
    private TextField SearchTxt;

    @FXML
    private TextField SearchTxt1;

    @FXML
    private TextField TransferAmount;

    @FXML
    private TextField TransferAmount1;

    @FXML
    private TextField TransferAmount2;


    @FXML
    private TextField OriginCardNumber;

    @FXML
    private TextField CVV2;

    @FXML
    private TextField Year;

    @FXML
    private TextField Month;

    @FXML
    private TextField Year1;

    @FXML
    private TextField Month1;

    @FXML
    private TextField Password;

    @FXML
    private GridPane grid;

    @FXML
    private VBox one;

    @FXML
    private VBox Two;

    @FXML
    private VBox Three;

    @FXML
    private VBox Two1;

    @FXML
    private VBox Two2;

    @FXML
    private VBox Two21;

    @FXML
    private VBox Two11;

    @FXML
    private VBox Four;

    @FXML
    private VBox Five;

    @FXML
    private VBox Five1;

    @FXML
    private VBox Five2;

    @FXML
    private VBox creat2;

    @FXML
    private VBox creat1;

    @FXML
    private HBox search;

    @FXML
    private HBox shaba;

    @FXML
    private HBox cardNumber;

    @FXML
    private HBox ExpiryDate;

    @FXML
    private HBox CVV21;

    @FXML
    private HBox cardPassword;

    @FXML
    private VBox one1;

    @FXML
    private VBox one2;

    @FXML
    private ImageView Cancel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label NameLabel1;

    @FXML
    private Label NameLabel2;

    @FXML
    private Label PriceLabel;

    @FXML
    private Label PriceLabel1;

    @FXML
    private Label PriceLabel2;

    @FXML
    private Label destinationLabel;

    @FXML
    private Label destinationLabel1;

    @FXML
    private Label destinationLabel2;

    @FXML
    private Label OriginCardNumberLabel;

    @FXML
    private Label amount;

    @FXML
    private Label amount1;

    @FXML
    private Label amount2;

    @FXML
    private Label origin;

    @FXML
    private Label originName;

    @FXML
    private Label destination;

    @FXML
    private Label destination1;

    @FXML
    private Label destination2;

    @FXML
    private Label destinationName;

    @FXML
    private Label destinationName1;

    @FXML
    private Label destinationName2;

    @FXML
    private Label DateLabel;

    @FXML
    private Label DateLabel1;

    @FXML
    private Label DateLabel2;

    @FXML
    private Label HourLabel;

    @FXML
    private Label HourLabel1;

    @FXML
    private Label HourLabel2;

    @FXML
    private Label trackingNumber;

    @FXML
    private Label trackingNumber1;

    @FXML
    private Label trackingNumber2;

    @FXML
    private Button downloadButton;

    @FXML
    private Button Download1;

    @FXML
    private Button Download2;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private TextField nationalCodeTextfield1;

    @FXML
    private TextField NameAndFamilyTextfield;

    @FXML
    private TextField NameAndFamilyTextfield1;

    @FXML
    private GridPane grid1;

    @FXML
    private GridPane grid2;

    @FXML
    private TextField nationalCodeTextfield;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private HBox hbox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vbox;



    private final SecureRandom random = new SecureRandom(); // برای تولید اعداد تصادفی امن‌تر

    private List<User> users = new ArrayList<>();

    private List<User> getData() {
        List<User> users = new ArrayList<>();
        try {
            File cartFile = new File("user.txt");
            Scanner reader = new Scanner(cartFile);
            while (reader.hasNextLine()) {
                User user = new User();
                user.setID(extractValue(reader.nextLine()));
                user.setfirstName(extractValue(reader.nextLine()));
                user.setLastName(extractValue(reader.nextLine()));
                user.setCode(extractValue(reader.nextLine()));
                reader.nextLine();
                reader.nextLine();
                reader.nextLine();

                users.add(user);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    // تابع برای استخراج مقادیر از خط‌ها
    private String extractValue(String line) {
        // فرض بر این است که حرف اضافه با دو نقطه (: ) تمام می‌شود.
        if (line.contains(":")) {
            return line.split(":")[1].trim();  // مقدار بعد از ":" را گرفته و فضای اضافی را حذف می‌کنیم.
        }
        return line.trim();  // در صورتی که ":" وجود نداشت، کل خط را trim می‌کنیم.
    }

    private boolean isUpdating = false; // جلوگیری از حلقه بی‌نهایت


    @FXML
    public void initialize() {
        gender.getItems().addAll("مرد", "زن");
        AccType.getItems().addAll("سپرده سرمایه گذاری بلند مدت", "سپرده سرمایه گذاری کوتاه مدت", "سپرده قرض الحسنه جاری", "سچرده قرض الحسنه بلند مدت");
        search.setVisible(false);  // عنصر را نامرئی می‌کند
        Cancel.setVisible(false);  // عنصر را نامرئی می‌کند


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

        TransferAmount1.textProperty().addListener((observable, oldValue, newValue) -> {
            // فقط اعداد ویرایش شوند، حروف حذف شوند
            String cleanValue = newValue.replaceAll("[^0-9]", "");

            if (cleanValue.isEmpty()) {
                TransferAmount1.setText("");
                return;
            }

            // تبدیل مقدار به عدد و افزودن کاما
            String formattedValue = formatWithCommas(cleanValue);

            // غیرفعال کردن Listener برای جلوگیری از بازگشتی شدن تغییرات
            TransferAmount1.setText(formattedValue);
        });

        TransferAmount2.textProperty().addListener((observable, oldValue, newValue) -> {
            // فقط اعداد ویرایش شوند، حروف حذف شوند
            String cleanValue = newValue.replaceAll("[^0-9]", "");

            if (cleanValue.isEmpty()) {
                TransferAmount2.setText("");
                return;
            }

            // تبدیل مقدار به عدد و افزودن کاما
            String formattedValue = formatWithCommas(cleanValue);

            // غیرفعال کردن Listener برای جلوگیری از بازگشتی شدن تغییرات
            TransferAmount2.setText(formattedValue);
        });

        inventory.textProperty().addListener((observable, oldValue, newValue) -> {
            // فقط اعداد ویرایش شوند، حروف حذف شوند
            String cleanValue = newValue.replaceAll("[^0-9]", "");

            if (cleanValue.isEmpty()) {
                inventory.setText("");
                return;
            }

            // تبدیل مقدار به عدد و افزودن کاما
            String formattedValue = formatWithCommas(cleanValue);

            // غیرفعال کردن Listener برای جلوگیری از بازگشتی شدن تغییرات
            inventory.setText(formattedValue);
        });

        // برقراری ارتباط اندازه‌ها
        hbox.prefWidthProperty().bind(anchorPane.widthProperty());
        hbox.prefHeightProperty().bind(anchorPane.heightProperty());

        // هماهنگ کردن اندازه‌ها
        scrollPane.prefWidthProperty().bind(hbox.widthProperty());
        scrollPane.prefHeightProperty().bind(hbox.heightProperty());

        stackPane.prefWidthProperty().bind(scrollPane.widthProperty());
        stackPane.prefHeightProperty().bind(scrollPane.heightProperty());

        // تنظیم ارتفاع VBox به اندازه HBox
        vbox.prefHeightProperty().bind(hbox.heightProperty());
        // وقتی عرض ScrollPane تغییر کنه، عرض VBox نصف اون بشه
        vbox.prefWidthProperty().bind(scrollPane.widthProperty().divide(1.5));

        LoadUser();
        LoadUser1();
        LoadUser3();
        downloadButton.setOnAction(event -> takeScreenshot());
        Download1.setOnAction(event -> takeScreenshot1());
        Download2.setOnAction(event -> takeScreenshot2());

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

    private void LoadUser() {
        grid.getChildren().clear();
        users.clear();
        users.addAll(getData());

        int column = 0;
        int row = 1;
        try {
            for (User user : users) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UserItem.fxml"));
                HBox anchorPane = fxmlLoader.load();
                UserItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(user);

                if (column == 2) {
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

    boolean hasAccount = false;
    String id = null;

    @FXML
    void CreateAccount(ActionEvent event) throws IOException {

        FileReader reader = new FileReader("user.txt");
        Scanner scanner = new Scanner(reader);
        String[] info = new String[7];

        while (scanner.hasNextLine()) {
            for (int i = 0; i < 7; i++) {
                info[i] = extractValue(scanner.nextLine());
            }
            if (NationalCode.getText().equals(info[3])) {
                System.out.println(info[3]);
                System.out.println(NationalCode.getText());
                hasAccount = true;
                id = info[0];
                break;
            }
        }
        reader.close();
        scanner.close();

        LocalDate birthDate = BirthDate.getValue();
        if (birthDate == null) {
            showAlert("خطا", "لطفاً تاریخ تولد را انتخاب کنید!", Alert.AlertType.ERROR);
            return;
        }

        LocalDate today = LocalDate.now();
        int age = Period.between(birthDate, today).getYears();

        if (age >= 18) {
            if (hasAccount == true) {
                System.out.println(info[0]);
                System.out.println(info[1]);
                System.out.println(info[2]);
                System.out.println(info[3]);
                System.out.println(info[4]);
                System.out.println(info[5]);
                System.out.println(info[6]);
                if (USFName.getText().equals(info[1]) && USLname.getText().equals(info[2]) &&
                        gender.getValue().equals(info[5])) {
                    if (AccType.getValue() == null) {
                        showAlert("خطا", "لطفا تمام فیلد ها را پر کنید!", Alert.AlertType.ERROR);
                    } else {
                        String AccountType = AccType.getValue();
                        if (AccountType.equals("سپرده سرمایه گذاری بلند مدت")) {
                            String accountNumber = generateRandomNumber(14);
                            AccNum.setText(accountNumber);
                            shaba.setVisible(false);
                            cardNumber.setVisible(false);
                            ExpiryDate.setVisible(false);
                            CVV21.setVisible(false);
                            cardPassword.setVisible(false);
                            creat1.setVisible(false);
                        } else {
                            // تولید شماره حساب ۱۴ رقمی
                            String accountNumber = generateRandomNumber(14);
                            AccNum.setText(accountNumber);

                            // تولید کد شبا ۲۴ رقمی که با "IR" شروع شود
                            String shabaNumber = "IR" + generateRandomNumber(24);
                            ShabaNum.setText(shabaNumber);

                            // مقداردهی اولیه بخش‌های کارت بانکی
                            CardNum1.setText("6393");
                            CardNum2.setText("4610");
                            CardNum3.setText(generateRandomNumber(4));
                            CardNum4.setText(generateRandomNumber(4));

                            Year.setText("1409");
                            Month.setText("01");

                            // تولید CVV2 سه رقمی
                            CVV2Num.setText(generateRandomNumber(3));

                            // تولید رمز کارت ۴ رقمی
                            CardPass.setText(generateRandomNumber(4));

                            if (USFName.getText().isEmpty() || USLname.getText().isEmpty() || NationalCode.getText().isEmpty() || BirthDate.getValue() == null ||
                                    gender.getValue() == null || AccType.getValue() == null
                            ) {
                                showAlert("خطا", "تمام فیلدها را پر کنید!", Alert.AlertType.ERROR);
                            } else {
                                creat1.setVisible(false);
                            }
                        }
                    }
                } else {
                    showAlert("خطا!", "اطلاعات وارد شده با اطلاعات قبلی یکسان نیست!", Alert.AlertType.ERROR);
                }
            } else {
                if (AccType.getValue() == null) {
                    showAlert("خطا", "لطفا تمام فیلد ها را پر کنید!", Alert.AlertType.ERROR);
                } else {
                    String AccountType = AccType.getValue();
                    if (AccountType.equals("سپرده سرمایه گذاری بلند مدت")) {
                        String accountNumber = generateRandomNumber(14);
                        AccNum.setText(accountNumber);
                        shaba.setVisible(false);
                        cardNumber.setVisible(false);
                        ExpiryDate.setVisible(false);
                        CVV21.setVisible(false);
                        cardPassword.setVisible(false);
                        creat1.setVisible(false);
                    } else {
                        // تولید شماره حساب ۱۴ رقمی
                        String accountNumber = generateRandomNumber(14);
                        AccNum.setText(accountNumber);

                        // تولید کد شبا ۲۴ رقمی که با "IR" شروع شود
                        String shabaNumber = "IR" + generateRandomNumber(24);
                        ShabaNum.setText(shabaNumber);

                        // مقداردهی اولیه بخش‌های کارت بانکی
                        CardNum1.setText("6393");
                        CardNum2.setText("4610");
                        CardNum3.setText(generateRandomNumber(4));
                        CardNum4.setText(generateRandomNumber(4));

                        Year.setText("1403");
                        Month.setText("01");

                        // تولید CVV2 سه رقمی
                        CVV2Num.setText(generateRandomNumber(3));

                        // تولید رمز کارت ۴ رقمی
                        CardPass.setText(generateRandomNumber(4));

                        if (USFName.getText().isEmpty() || USLname.getText().isEmpty() || NationalCode.getText().isEmpty() || BirthDate.getValue() == null ||
                                gender.getValue() == null || AccType.getValue() == null
                        ) {
                            showAlert("خطا", "تمام فیلدها را پر کنید!", Alert.AlertType.ERROR);
                        } else {
                            creat1.setVisible(false);
                        }
                    }
                }
            }
        } else {
            showAlert("خطا", "شما هنوز به ۱۸ سالگی نرسیده‌اید!", Alert.AlertType.ERROR);
        }
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
    void CreateAccount1(ActionEvent event) {
        // دریافت اطلاعات از تکست‌فیلدها
        String firstName = USFName.getText();
        String lastName = USLname.getText();
        String nationalCode = NationalCode.getText();
        LocalDate birthDate = BirthDate.getValue();
        String selectedGender = gender.getSelectionModel().getSelectedItem();
        String AccountNumber = AccNum.getText();
        String ShabaNumber = ShabaNum.getText();
        String CardNumber = CardNum1.getText() + CardNum2.getText() + CardNum3.getText() + CardNum4.getText();
        String expirationDate = Year.getText() + "/" + Month.getText();
        String CVV2Numer = CVV2Num.getText();
        String inventoryPrice = inventory.getText();
        String AccountType = AccType.getValue();
        String CardPassvord = CardPass.getText();
        LocalDate createDate = LocalDate.now();

        try {
            String cleanValue = inventoryPrice.replaceAll(",", "");
            Double.parseDouble(cleanValue); // سعی در تبدیل به عدد
        } catch (NumberFormatException e) {
            showAlert("خطا", "مقدار وارد شده در موجودی اولیه باید عدد باشد!", Alert.AlertType.ERROR);
            return; // اگر عدد نیست از متد خارج شو
        }
        if (AccType.getValue().equals("سپرده سرمایه گذاری بلند مدت")) {

        } else if (firstName.isEmpty() || lastName.isEmpty() || nationalCode.isEmpty() || birthDate == null ||
                selectedGender == null || AccountNumber.isEmpty() || ShabaNumber.isEmpty() || CardNumber.isEmpty() || CVV2Numer.isEmpty() || inventoryPrice.isEmpty() || CardPassvord.isEmpty()
                || AccountType == null) {
            showAlert("خطا", "تمام فیلدها را پر کنید!", Alert.AlertType.ERROR);
            return; // خروج از متد
        }

        // ایجاد یک ID یکتا برای کاربر با استفاده از کد ملی و UUID
        String userId = "@" + UUID.randomUUID().toString().substring(0, 8);

        // نوشتن اطلاعات در فایل
        try {

            if (hasAccount == false) {
                File file = new File("user.txt");
                FileWriter writer = new FileWriter(file, true);  // true برای افزودن به فایل موجود
                writer.write("User ID: " + userId + "\n");
                writer.write("First Name: " + firstName + "\n");
                writer.write("Last Name: " + lastName + "\n");
                writer.write("National Code: " + nationalCode + "\n");
                writer.write("Birth Date: " + birthDate + "\n");
                writer.write("Gender: " + selectedGender + "\n");
                writer.write("---------------" + "\n");  // خط جداکننده برای هر کاربر
                writer.close();

                File newFile = new File("userID.txt");
                FileWriter myWriter = new FileWriter(newFile, true);
                myWriter.write("User ID: " + userId + "\n");
                myWriter.write("Account Number: " + AccountNumber + "\n");
                myWriter.write("Shaba Number: " + ShabaNumber + "\n");
                myWriter.write("Card Number: " + CardNumber + "\n");
                myWriter.write("Card Password: " + CardPassvord + "\n");
                myWriter.write("expiration Date: " + expirationDate + "\n");
                myWriter.write("CVV2 Number: " + CVV2Numer + "\n");
                myWriter.write("Account Type: " + AccountType + "\n");
                myWriter.write("inventory Price: " + inventoryPrice + CURRENCY + "\n");
                myWriter.write("create Date: " + createDate + "\n");
                myWriter.write("---------------\n");
                myWriter.close();

                // پاک کردن محتویات فیلدها پس از ثبت اطلاعات
                clearFields();

                // نمایش پیام موفقیت
                showAlert("موفقیت", "کاربر با موفقیت ثبت شد!", Alert.AlertType.INFORMATION);
                creat1.setVisible(true);
            } else {
                File newFile = new File("userID.txt");
                FileWriter myWriter = new FileWriter(newFile, true);
                myWriter.write("User ID: " + id + "\n");
                myWriter.write("Account Number: " + AccountNumber + "\n");
                myWriter.write("Shaba Number: " + ShabaNumber + "\n");
                myWriter.write("Card Number: " + CardNumber + "\n");
                myWriter.write("Card Password: " + CardPassvord + "\n");
                myWriter.write("expiration Date: " + expirationDate + "\n");
                myWriter.write("CVV2 Number: " + CVV2Numer + "\n");
                myWriter.write("Account Type: " + AccountType + "\n");
                myWriter.write("inventory Price: " + inventoryPrice + CURRENCY + "\n");
                myWriter.write("create Date: " + createDate + "\n");
                myWriter.write("---------------\n");
                myWriter.close();

                // پاک کردن محتویات فیلدها پس از ثبت اطلاعات
                clearFields();

                // نمایش پیام موفقیت
                showAlert("موفقیت", "کاربر با موفقیت ثبت شد!", Alert.AlertType.INFORMATION);
                creat1.setVisible(true);
            }

        } catch (IOException e) {
            showAlert("خطا", "مشکلی در ذخیره اطلاعات رخ داده است!", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    void comeBack(ActionEvent event) {
        creat1.setVisible(true);
    }


    // متد برای پاک کردن محتویات فیلدها
    private void clearFields() {
        USFName.clear();
        USLname.clear();
        NationalCode.clear();
        BirthDate.setValue(null);
        gender.getSelectionModel().clearSelection();
        AccNum.clear();
        ShabaNum.clear();
        CardNum1.clear();
        CardNum2.clear();
        CardNum3.clear();
        CardNum4.clear();
        CVV2Num.clear();
        Year.clear();
        Month.clear();
        inventory.clear();
        AccType.getSelectionModel().clearSelection();
        CardPass.clear();
    }


    // متد نمایش هشدارها
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

    // متد برای نمایش هشدار
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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


            findInformation findInformation = new findInformation();


            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = searchUserIDByCardNumber(cardNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = findInformation.searchUserInfoByUserID(userID);
                if (userInfo != null) {
//                    setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
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


            findInformation findInformation = new findInformation();

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = findInformation.searchUserIDByAccountNumber(depositNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = findInformation.searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    transferArray[3] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه
                } else {
                    showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                }
            } else {
                showAlert("خطا", "شماره سپرده معتبر نیست.");
            }

        } else if (!shabaNum.isEmpty()) {
            if (amount > 1_000_000_000) {
                showAlert("خطا", "مبلغ وارد شده بیش از 1 میلیارد تومان است!");
                return;
            }
            if (!shabaNum.matches("IR\\d{24}")) {
                showAlert("خطا", "شماره شبا نامعتبر است! باید با IR شروع شده و 26 رقم باشد.");
                return;
            }

            transferArray[1] = "شبا";
            transferArray[2] = shabaNum;


            findInformation findInformation = new findInformation();

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = findInformation.searchUserIDByShabaNumber(shabaNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = findInformation.searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    transferArray[3] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه
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


    private void setUserInfoInUI(String firstName, String lastName) {
        transferArray[3] = firstName + " " + lastName;
    }


    @FXML
    void Back(ActionEvent event) {
        one.setVisible(true);  // عنصر را نامرئی می‌کند
        one.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
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

        findInformation findInformation = new findInformation();

        // جستجو برای پیدا کردن User ID از شماره کارت
        String userID = findInformation.searchUserIDByCardNumber(OriginCardNumber);
        if (userID != null) {
            // جستجو برای یافتن نام و نام خانوادگی کاربر
            String[] userInfo = findInformation.searchUserInfoByUserID(userID);
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

        Three.setVisible(false);  // عنصر را نامرئی می‌کند
        Three.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void Back1(ActionEvent event) {
        Two.setVisible(true);  // عنصر را نامرئی می‌کند
        Two.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }


    private String sentCode;  // برای ذخیره کد ارسال‌شده به ایمیل


    @FXML
    void ReceivePassword(ActionEvent event) {
        String CartNumber = OriginCardNumberLabel.getText();
        findInformation findInformation = new findInformation();
        String[] data = findInformation.searchYearMounthCvv2(CartNumber);
        String txtYear = Year1.getText();
        String txtMonth = Month1.getText();
        String cvv2 = CVV2.getText();


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
                String userID = findInformation.searchUserIDByCardNumber(CartNumber);
                if (userID != null) {
                    // جستجو برای یافتن نام و نام خانوادگی کاربر
                    String userInfo = findInformation.searchUserEmail(userID);
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

    private static String generateRandomCode() {
        SecureRandom random = new SecureRandom();
        int code = 100000 + random.nextInt(900000); // تولید عدد ۶ رقمی تصادفی
        return String.valueOf(code);
    }


    @FXML
    void next3(ActionEvent event) throws IOException {
        findInformation findInformation = new findInformation();
        String enteredCode = Password.getText();  // کد واردشده توسط کاربر از تکست فیلد Password

        // بررسی اینکه کد واردشده با کد ارسال‌شده برابر باشد
        if (sentCode != null && sentCode.equals(enteredCode)) {
            String cardNum = transferArray[4].toString();
            Double inventoryStr = searchUserinventoryByCardNumber(cardNum);
            if (transferArray[1].toString().equals("کارت")) {
                Double inventoryStr1 = searchUserinventoryByCardNumber(transferArray[2].toString());

                // گرفتن مقدار خانه اول آرایه و تبدیل به عدد
                String transferStr1 = transferArray[0].toString().trim();
                String transferCleaned1 = transferStr1.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned1);


                // اپدیت موجودی مقصد
                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByCardNumber(transferArray[2].toString(), bigDecimal);
            } else if (transferArray[1].toString().equals("سپرده")) {

                Double inventoryStr1 = searchUserinventoryByAccountNumber(transferArray[2].toString());

                // گرفتن مقدار خانه اول آرایه و تبدیل به عدد
                String transferStr = transferArray[0].toString().trim();
                String transferCleaned = transferStr.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned);


                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByAccountNumber(transferArray[2].toString(), bigDecimal);

            } else if (transferArray[1].toString().equals("شبا")) {
                Double inventoryStr1 = searchUserinventoryByShabaNumber(transferArray[2].toString());

                // گرفتن مقدار خانه اول آرایه و تبدیل به عدد
                String transferStr = transferArray[0].toString().trim();
                String transferCleaned = transferStr.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned);

                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByShabaNumber(transferArray[2].toString(), bigDecimal);
            }

            // گرفتن مقدار خانه اول آرایه و تبدیل به عدد
            String transferStr = transferArray[0].toString().trim();
            String transferCleaned = transferStr.replaceAll("[^\\d]", "");
            int transferAmount = Integer.parseInt(transferCleaned);

            // بررسی مقدار و چاپ نتیجه
            if (inventoryStr > transferAmount) {
                Double remainingAmount = inventoryStr - transferAmount;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount);
                updateInventoryByCardNumber(transferArray[4].toString(), bigDecimal);

                // اگر کدها برابر بودند، عملیات زیر را انجام بده
                Four.setVisible(false);  // عنصر را نامرئی می‌کند
                Four.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند

                String track = generateRandomNumber(9);
                transferArray[6] = track;
                // دریافت تاریخ امروز
                LocalDate today = LocalDate.now();
                // تبدیل تاریخ به آرایه
                String[] dateArray = {
                        String.valueOf(today.getYear()),  // سال
                        String.valueOf(today.getMonthValue()),  // ماه
                        String.valueOf(today.getDayOfMonth())  // روز
                };

                // دریافت زمان فعلی
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


    @FXML
    void Back2(ActionEvent event) {
        Three.setVisible(true);  // عنصر را نامرئی می‌کند
        Three.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
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
        Password.clear();
        Year1.clear();
        Month1.clear();
        CVV2.clear();
        OriginCardNumber.clear();
        ShabaNumber.clear();
        DepositNumber.clear();
        CardNumber.clear();
        TransferAmount.clear();
    }


    @FXML
    void Show(MouseEvent event) {
        search.setVisible(true);  // عنصر را نامرئی می‌کند
        Cancel.setVisible(true);  // عنصر را نامرئی می‌کند

    }

    @FXML
    void Cancel(MouseEvent event) {
        search.setVisible(false);  // عنصر را نامرئی می‌کند
        Cancel.setVisible(false);  // عنصر را نامرئی می‌کند
        grid.getChildren().clear(); // پاک کردن محتوای گرید

        int column = 0;
        int row = 1;

        // بازگرداندن کتاب‌ها به حالت اولیه
        for (User user : users) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UserItem.fxml"));
                HBox anchorPane = fxmlLoader.load();
                UserItemController itemController = fxmlLoader.getController();
                itemController.setData(user);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void SearchId(MouseEvent event) {
        String search = SearchTxt.getText().trim();
        boolean found = false;

        grid.getChildren().clear(); // پاک کردن محتوای گرید

        int column = 0;
        int row = 1;

        for (User user : users) {
            if (user.getID().toLowerCase().contains(search.toLowerCase())) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UserItem.fxml"));
                try {
                    HBox anchorPane = fxmlLoader.load();
                    UserItemController itemController = fxmlLoader.getController();
                    itemController.setData(user);

                    if (column == 2) {
                        column = 0;
                        row++;
                    }

                    grid.add(anchorPane, column++, row);
                    GridPane.setMargin(anchorPane, new Insets(10));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                found = true;
            }
        }

        if (!found) {
            showAlert("خطا", "متاسفانه کاربری با این آیدی یافت نشد!", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void SearchCode(MouseEvent event) {
        String search = SearchTxt1.getText().trim();
        boolean found = false;

        grid.getChildren().clear(); // پاک کردن محتوای گرید

        int column = 0;
        int row = 1;

        for (User user : users) {
            if (user.getCode().toLowerCase().contains(search.toLowerCase())) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UserItem.fxml"));
                try {
                    HBox anchorPane = fxmlLoader.load();
                    UserItemController itemController = fxmlLoader.getController();
                    itemController.setData(user);

                    if (column == 2) {
                        column = 0;
                        row++;
                    }

                    grid.add(anchorPane, column++, row);
                    GridPane.setMargin(anchorPane, new Insets(10));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                found = true;
            }
        }

        if (!found) {
            showAlert("خطا", "متاسفانه کاربری با این کدملی یافت نشد!", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void CancelId(MouseEvent event) {
        grid.getChildren().clear(); // پاک کردن محتوای گرید

        int column = 0;
        int row = 1;

        for (User user : users) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UserItem.fxml"));
                HBox anchorPane = fxmlLoader.load();
                UserItemController itemController = fxmlLoader.getController();
                itemController.setData(user);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void CancelCode(MouseEvent event) {
        grid.getChildren().clear(); // پاک کردن محتوای گرید

        int column = 0;
        int row = 1;

        // بازگرداندن کتاب‌ها به حالت اولیه
        for (User user : users) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UserItem.fxml"));
                HBox anchorPane = fxmlLoader.load();
                UserItemController itemController = fxmlLoader.getController();
                itemController.setData(user);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void takeScreenshot() {
        try {
            // تعیین محدوده‌ای که باید عکس بگیریم
            int x = 295, y = 367, width = 344, height = 340;
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

    private void takeScreenshot1() {
        try {
            // تعیین محدوده‌ای که باید عکس بگیریم
            int x = 1100, y = 367, width = 344, height = 339;
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

    private void takeScreenshot2() {
        try {
            // تعیین محدوده‌ای که باید عکس بگیریم
            int x = 689, y = 364, width = 344, height = 340;
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

    // آرایه برای ذخیره اطلاعات
    private Object[] transferArray1 = new Object[7]; // استفاده از Object به جای long تا امکان مقدار null وجود داشته باشد.

    @FXML
    void next11(ActionEvent event) {
        // دریافت مقدار از TextField و حذف کاماها
        String amountText = TransferAmount1.getText().replace(",", "");

        // بررسی اینکه مقدار خالی نباشد
        if (amountText.isEmpty()) {
            showAlert("خطا", "لطفاً مبلغی وارد کنید.");
            return;
        }

        try {
            // تبدیل مقدار به عدد
            long amount = Long.parseLong(amountText);


            // ذخیره مقدار در خانه اول آرایه
            transferArray1[0] = amount;

            one1.setVisible(false);  // عنصر را نامرئی می‌کند
            one1.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
            Two11.setVisible(false);
            Two11.setManaged(false);

        } catch (NumberFormatException e) {
            showAlert("خطا", "مبلغ وارد شده نامعتبر است.");
        }

    }


    @FXML
    void next12(ActionEvent event) throws IOException {
        // بررسی مقدار ذخیره‌شده در خانه اول (مبلغ انتقالی)
        if (transferArray1[0] == null) {
            showAlert("خطا", "ابتدا مبلغ را وارد کنید.");
            return;
        }

        long amount;
        try {
            amount = (long) transferArray1[0]; // تبدیل مقدار ذخیره شده به عدد
        } catch (Exception e) {
            showAlert("خطا", "مبلغ نامعتبر است!");
            return;
        }

        String depositNum = CardNumber1.getText().trim();

        if (!depositNum.matches("\\d{14}")) {
            showAlert("خطا", "شماره سپرده نامعتبر است! باید 14 رقم باشد.");
            return;
        }

        transferArray1[1] = depositNum;

        // جستجو برای پیدا کردن User ID از شماره کارت
        String userID = searchUserIDByAccountNumber(depositNum);
        if (userID != null) {
            // جستجو برای یافتن نام و نام خانوادگی کاربر
            String[] userInfo = searchUserInfoByUserID(userID);
            if (userInfo != null) {
                setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
                transferArray1[2] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه

                PriceLabel1.setText(TransferAmount1.getText());
                destinationLabel1.setText(transferArray1[1].toString());
                NameLabel1.setText(transferArray1[2].toString());


                findInformation findInformation = new findInformation();

                Double inventoryStr1 = findInformation.searchUserinventoryByAccountNumber(transferArray1[1].toString());


                // گرفتن مقدار خانه اول آرایه و تبدیل به عدد
                String transferStr = transferArray1[0].toString().trim();
                String transferCleaned = transferStr.replaceAll("[^\\d]", "");
                int transferAmount1 = Integer.parseInt(transferCleaned);


                Double remainingAmount1 = inventoryStr1 + transferAmount1;
                BigDecimal bigDecimal = new BigDecimal(remainingAmount1);
                updateInventoryByAccountNumber(transferArray1[1].toString(), bigDecimal);

                String track = generateRandomNumber(9);
                transferArray1[3] = track;
                // دریافت تاریخ امروز
                LocalDate today = LocalDate.now();
                // تبدیل تاریخ به آرایه
                String[] dateArray = {
                        String.valueOf(today.getYear()),  // سال
                        String.valueOf(today.getMonthValue()),  // ماه
                        String.valueOf(today.getDayOfMonth())  // روز
                };

                // دریافت زمان فعلی
                LocalTime now = LocalTime.now();
                String[] timeArray = {
                        String.valueOf(now.getHour()),    // ساعت
                        String.valueOf(now.getMinute()),  // دقیقه
                        String.valueOf(now.getSecond())   // ثانیه
                };

                // نمایش تاریخ
                transferArray1[4] = String.join("/", dateArray);
                transferArray1[5] = String.join(":", timeArray);

                amount1.setText(TransferAmount1.getText());
                destination1.setText(transferArray1[1].toString().trim());
                destinationName1.setText(transferArray1[2].toString().trim());
                trackingNumber1.setText(transferArray1[3].toString().trim());
                DateLabel1.setText(transferArray1[4].toString().trim());
                HourLabel1.setText(transferArray1[5].toString().trim());

                File file = new File("Deposits.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                fw.write("Amount transferred :" + transferArray1[0].toString().trim());
                fw.write("\n");
                fw.write("Transfer type :" + "واریز وجه");
                fw.write("\n");
                fw.write("destination number :" + transferArray1[1].toString().trim());
                fw.write("\n");
                fw.write("destination name : " + transferArray1[2].toString().trim());
                fw.write("\n");
                fw.write("tracking code :" + transferArray1[3].toString().trim());
                fw.write("\n");
                fw.write("Date :" + transferArray1[4].toString().trim());
                fw.write("\n");
                fw.write("Time :" + transferArray1[5].toString().trim());
                fw.write("\n");
                fw.write("-------------" + "\n");

                fw.close();


                Two1.setVisible(false);
                Two1.setManaged(false);

            } else {
                showAlert("خطا", "اطلاعات کاربر یافت نشد.");
            }
        } else {
            showAlert("خطا", "شماره سپرده معتبر نیست.");
        }

    }

    @FXML
    void Show1(MouseEvent event) throws IOException {
        // بررسی مقدار ذخیره‌شده در خانه اول (مبلغ انتقالی)
        if (transferArray1[0] == null) {
            showAlert("خطا", "ابتدا مبلغ را وارد کنید.");
            return;
        }

        long amount;
        try {
            amount = (long) transferArray1[0]; // تبدیل مقدار ذخیره شده به عدد
        } catch (Exception e) {
            showAlert("خطا", "مبلغ نامعتبر است!");
            return;
        }

        String depositNum = CardNumber1.getText().trim();

        if (!depositNum.matches("\\d{14}")) {
            showAlert("خطا", "شماره سپرده نامعتبر است! باید 14 رقم باشد.");
            return;
        }

        transferArray1[1] = depositNum;

        // جستجو برای پیدا کردن User ID از شماره کارت
        String userID = searchUserIDByAccountNumber(depositNum);
        if (userID != null) {
            // جستجو برای یافتن نام و نام خانوادگی کاربر
            String[] userInfo = searchUserInfoByUserID(userID);
            if (userInfo != null) {
                setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
                transferArray1[2] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه

                PriceLabel1.setText(TransferAmount1.getText());
                destinationLabel1.setText(transferArray1[1].toString());
                NameLabel1.setText(transferArray1[2].toString());

                Two11.setVisible(true);
                Two11.setManaged(true);

            } else {
                showAlert("خطا", "اطلاعات کاربر یافت نشد.");
            }
        } else {
            showAlert("خطا", "شماره سپرده معتبر نیست.");
        }

    }


    @FXML
    void Back11(ActionEvent event) {
        one1.setVisible(true);  // عنصر را نامرئی می‌کند
        one1.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void End1(ActionEvent event) {
        TransferAmount1.clear();
        CardNumber1.clear();
        one1.setVisible(true);
        one1.setManaged(true);
        Two1.setVisible(true);
        Two1.setManaged(true);
    }

    // آرایه برای ذخیره اطلاعات
    private Object[] transferArray2 = new Object[7]; // استفاده از Object به جای long تا امکان مقدار null وجود داشته باشد.

    @FXML
    void next21(ActionEvent event) {
        // دریافت مقدار از TextField و حذف کاماها
        String amountText = TransferAmount2.getText().replace(",", "");

        // بررسی اینکه مقدار خالی نباشد
        if (amountText.isEmpty()) {
            showAlert("خطا", "لطفاً مبلغی وارد کنید.");
            return;
        }

        try {
            // تبدیل مقدار به عدد
            long amount = Long.parseLong(amountText);

            // ذخیره مقدار در خانه اول آرایه
            transferArray2[0] = amount;

            one2.setVisible(false);
            one2.setManaged(false);
            Two21.setVisible(false);
            Two21.setManaged(false);

        } catch (NumberFormatException e) {
            showAlert("خطا", "مبلغ وارد شده نامعتبر است.");
        }

    }

    @FXML
    void next22(ActionEvent event) throws IOException {
        // بررسی مقدار ذخیره‌شده در خانه اول (مبلغ انتقالی)
        if (transferArray2[0] == null) {
            showAlert("خطا", "ابتدا مبلغ را وارد کنید.");
            return;
        }

        long amount;
        try {
            amount = (long) transferArray2[0]; // تبدیل مقدار ذخیره شده به عدد
        } catch (Exception e) {
            showAlert("خطا", "مبلغ نامعتبر است!");
            return;
        }

        String depositNum = CardNumber2.getText().trim();


        if (!depositNum.isEmpty()) {
            if (!depositNum.matches("\\d{14}")) {
                showAlert("خطا", "شماره سپرده نامعتبر است! باید 14 رقم باشد.");
                return;
            }

            transferArray2[1] = depositNum;

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = searchUserIDByAccountNumber(depositNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
                    transferArray2[2] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه

                    PriceLabel2.setText(TransferAmount2.getText());
                    destinationLabel2.setText(transferArray2[1].toString());
                    NameLabel2.setText(transferArray2[2].toString());


                    String userID1 = searchUserIDByAccountNumber(transferArray2[1].toString());

                    findInformation findInformation = new findInformation();
                    Double inventoryStr = searchUserinventoryByAccountNumber(transferArray2[1].toString());

                    // گرفتن مقدار خانه اول آرایه و تبدیل به عدد
                    String transferStr = transferArray2[0].toString().trim();
                    String transferCleaned = transferStr.replaceAll("[^\\d]", "");
                    int transferAmount1 = Integer.parseInt(transferCleaned);

                    // حذف تمام حروف غیراعداد (مثل "ريال" و فاصله‌های اضافی)

                    if (inventoryStr >= transferAmount1) {
                        Double remainingAmount = inventoryStr - transferAmount1;
                        BigDecimal bigDecimal = new BigDecimal(remainingAmount);
                        updateInventoryByAccountNumber(transferArray2[1].toString(), bigDecimal);

                        String track = generateRandomNumber(9);
                        transferArray2[3] = track;
                        // دریافت تاریخ امروز
                        LocalDate today = LocalDate.now();
                        // تبدیل تاریخ به آرایه
                        String[] dateArray = {
                                String.valueOf(today.getYear()),  // سال
                                String.valueOf(today.getMonthValue()),  // ماه
                                String.valueOf(today.getDayOfMonth())  // روز
                        };

                        // دریافت زمان فعلی
                        LocalTime now = LocalTime.now();
                        String[] timeArray = {
                                String.valueOf(now.getHour()),    // ساعت
                                String.valueOf(now.getMinute()),  // دقیقه
                                String.valueOf(now.getSecond())   // ثانیه
                        };

                        // نمایش تاریخ
                        transferArray2[4] = String.join("/", dateArray);
                        transferArray2[5] = String.join(":", timeArray);

                        amount2.setText(TransferAmount2.getText());
                        destination2.setText(transferArray2[1].toString().trim());
                        destinationName2.setText(transferArray2[2].toString().trim());
                        trackingNumber2.setText(transferArray2[3].toString().trim());
                        DateLabel2.setText(transferArray2[4].toString().trim());
                        HourLabel2.setText(transferArray2[5].toString().trim());

                        File file = new File("Deposits.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        fw.write("Amount transferred : " + transferArray2[0].toString().trim());
                        fw.write("\n");
                        fw.write("Transfer type : " + "برداشت وجه");
                        fw.write("\n");
                        fw.write("destination number : " + transferArray2[1].toString().trim());
                        fw.write("\n");
                        fw.write("destination name : " + transferArray2[2].toString().trim());
                        fw.write("\n");
                        fw.write("tracking code : " + transferArray2[3].toString().trim());
                        fw.write("\n");
                        fw.write("Date : " + transferArray2[4].toString().trim());
                        fw.write("\n");
                        fw.write("Time : " + transferArray2[5].toString().trim());
                        fw.write("\n");
                        fw.write("-------------");
                        fw.write("\n");
                        fw.close();
                        Two2.setVisible(false);
                        Two2.setManaged(false);
                        TransferAmount2.clear();
                        CardNumber2.clear();
                    } else {
                        showAlert("خطا!", "موجودی کافی نیست !");
                    }
                } else {
                    showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                }
            } else {
                showAlert("خطا", "شماره سپرده معتبر نیست.");
            }
        }
    }

    @FXML
    void Show2(MouseEvent event) throws IOException {
        // بررسی مقدار ذخیره‌شده در خانه اول (مبلغ انتقالی)
        if (transferArray2[0] == null) {
            showAlert("خطا", "ابتدا مبلغ را وارد کنید.");
            return;
        }

        long amount;
        try {
            amount = (long) transferArray2[0]; // تبدیل مقدار ذخیره شده به عدد
        } catch (Exception e) {
            showAlert("خطا", "مبلغ نامعتبر است!");
            return;
        }

        String depositNum = CardNumber2.getText().trim();


        if (!depositNum.matches("\\d{14}")) {
            showAlert("خطا", "شماره سپرده نامعتبر است! باید 14 رقم باشد.");
            return;
        }

        transferArray2[1] = depositNum;


        // جستجو برای پیدا کردن User ID از شماره کارت
        String userID = searchUserIDByAccountNumber(depositNum);
        if (userID != null) {
            // جستجو برای یافتن نام و نام خانوادگی کاربر
            String[] userInfo = searchUserInfoByUserID(userID);
            if (userInfo != null) {
                setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
                transferArray2[2] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه

                PriceLabel2.setText(TransferAmount2.getText());
                destinationLabel2.setText(transferArray2[1].toString());
                NameLabel2.setText(transferArray2[2].toString());

                Two21.setVisible(true);
                Two21.setManaged(true);

            } else {
                showAlert("خطا", "اطلاعات کاربر یافت نشد.");
            }
        } else {
            showAlert("خطا", "شماره سپرده معتبر نیست.");
        }
    }

    @FXML
    void Back21(ActionEvent event) {
        one2.setVisible(true);  // عنصر را نامرئی می‌کند
        one2.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void End2(ActionEvent event) {
        one2.setVisible(true);
        one2.setManaged(true);
        Two2.setVisible(true);
        Two2.setManaged(true);
    }

    private List<Card> cards = new ArrayList<>();

    public List<Card> getData1() {
        List<Card> cards = new ArrayList<>();
        try {
            File cartFile = new File("userID.txt");
            Scanner reader = new Scanner(cartFile);
            while (reader.hasNextLine()) {
                Card card = new Card();
                reader.nextLine();
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
                    fxmlLoader.setLocation(getClass().getResource("../views/EmployeeCardItem.fxml"));
                    VBox anchorPane = fxmlLoader.load();
                    EmployeeCardItemController cartItemController = fxmlLoader.getController();
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
    void searchbtn(ActionEvent event) throws FileNotFoundException {
        boolean found = false;
        String Name = NameAndFamilyTextfield.getText();
        String Code = nationalCodeTextfield.getText();

        if (Name == null || Name.isEmpty()) {
            showAlert("خطا", "نام و نام خانوادگی نمی‌تواند خالی باشد.", Alert.AlertType.ERROR);
            return;
        }

        if (Code == null || Code.isEmpty()) {
            showAlert("خطا", "کد ملی نمی‌تواند خالی باشد.", Alert.AlertType.ERROR);
            return;
        }

            FileReader reader = new FileReader("user.txt");
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String id = extractValue(scanner.nextLine());
                String name = extractValue(scanner.nextLine());
                String family = extractValue(scanner.nextLine());
                String nationalCode = extractValue(scanner.nextLine());
                scanner.nextLine();
                scanner.nextLine();
                scanner.nextLine();
                if (Name.equals(name +" "+ family) && Code.equals(nationalCode)) {
                    found = true;
                    getData2(id);
                    LoadUser2(id);

                }
            }
            if (found == false ) {
                showAlert("خطا", "حساب مورد نظر یافت نشد!", Alert.AlertType.ERROR);
            }


    }

    private List<Card> cards1 = new ArrayList<>();

    public List<Card> getData2(String id) {
        List<Card> cards = new ArrayList<>();
        try {
            File cartFile = new File("userID.txt");
            Scanner reader = new Scanner(cartFile);
            while (reader.hasNextLine()) {
                Card card = new Card();
                if(id.equals(extractValue(reader.nextLine()))){
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

    public void LoadUser2(String id) {
        Platform.runLater(() -> {
            grid1.getChildren().clear();
            cards1.clear();
            cards1.addAll(getData2(id));

            int column = 0;
            int row = 1;
            try {
                for (Card card : cards1) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/EmployeeCardItem.fxml"));
                    VBox anchorPane = fxmlLoader.load();
                    EmployeeCardItemController cartItemController = fxmlLoader.getController();
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
    void searchbtn1(ActionEvent event) throws FileNotFoundException {
        boolean found = false;
        String Name = NameAndFamilyTextfield1.getText();
        String Code = nationalCodeTextfield1.getText();

        if (Name == null || Name.isEmpty()) {
            showAlert("خطا", "نام و نام خانوادگی نمی‌تواند خالی باشد.", Alert.AlertType.ERROR);
            return;
        }

        if (Code == null || Code.isEmpty()) {
            showAlert("خطا", "کد ملی نمی‌تواند خالی باشد.", Alert.AlertType.ERROR);
            return;
        }

        FileReader reader = new FileReader("user.txt");
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String id = extractValue(scanner.nextLine());
            String name = extractValue(scanner.nextLine());
            String family = extractValue(scanner.nextLine());
            String nationalCode = extractValue(scanner.nextLine());
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            if (Name.equals(name +" "+ family) && Code.equals(nationalCode)) {
                found = true;
                getData31(id);
                LoadUser31(id);

            }
        }
        if (found == false ) {
            showAlert("خطا", "حساب مورد نظر یافت نشد!", Alert.AlertType.ERROR);
        }
    }

    private List<Deposit> deposits = new ArrayList<>();

    private List<Deposit> getData3() {
        List<Deposit> deposits = new ArrayList<>();
        try {

            File depositFile = new File("userID.txt");
            Scanner reader1 = new Scanner(depositFile);
            while (reader1.hasNextLine()) {
                    Deposit deposit = new Deposit();
                    reader1.nextLine();
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

    private void LoadUser3() {
        grid2.getChildren().clear();
        deposits.clear();
        deposits.addAll(getData3());

        int column = 0;
        int row = 1;
        try {
            for (Deposit deposit : deposits) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/EmployeeDepositItem.fxml"));
                VBox anchorPane = fxmlLoader.load();
                EmployeeDepositItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(deposit,this);
                cartItemController.setItemNode(anchorPane);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid2.add(anchorPane, column++, row);
                grid2.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid2.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid2.setMaxWidth(Region.USE_PREF_SIZE);

                grid2.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid2.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid2.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeItemFromGrid(EmployeeDepositItemController itemController) {
        // گرفتن نود مربوط به آیتم از کنترلر
        Node itemNode = itemController.getItemNode(); // فرض بر این است که متدی به نام getItemNode در Item1Controller دارید که نود را باز می‌گرداند

        // حذف نود از grid
        grid2.getChildren().remove(itemNode);
    }

    private List<Deposit> deposits1 = new ArrayList<>();

    private List<Deposit> getData31(String id) {
        List<Deposit> deposits = new ArrayList<>();
        try {

            File depositFile = new File("userID.txt");
            Scanner reader1 = new Scanner(depositFile);
            while (reader1.hasNextLine()) {
                Deposit deposit = new Deposit();
                if(id.equals(extractValue(reader1.nextLine()))){
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

    private void LoadUser31(String id) {
        grid2.getChildren().clear();
        deposits1.clear();
        deposits1.addAll(getData31(id));

        int column = 0;
        int row = 1;
        try {
            for (Deposit deposit : deposits1) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/EmployeeDepositItem.fxml"));
                VBox anchorPane = fxmlLoader.load();
                EmployeeDepositItemController cartItemController = fxmlLoader.getController();
                cartItemController.setData(deposit,this);
                cartItemController.setItemNode(anchorPane);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid2.add(anchorPane, column++, row);
                grid2.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid2.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid2.setMaxWidth(Region.USE_PREF_SIZE);

                grid2.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid2.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid2.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
