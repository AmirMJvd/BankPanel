package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

import static main.Main.CURRENCY;

public class EmployeeController {
    @FXML
    private TextField AccNum;

    @FXML
    private ComboBox<String> AccType;

    @FXML
    private ComboBox<String> type ;

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
    private TextField OriginCardNumber;

    @FXML
    private TextField CVV2;

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
    private VBox Three1;

    @FXML
    private VBox Four;

    @FXML
    private VBox Five;

    @FXML
    private HBox search;

    @FXML
    private ImageView Cancel;

    @FXML
    private Label NameLabel;

    @FXML
    private Label PriceLabel;

    @FXML
    private Label destinationLabel;

    @FXML
    private Label OriginCardNumberLabel;


    @FXML
    private ComboBox<String> gender;

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
                reader.nextLine();
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
        AccType.getItems().addAll("بلند مدت", "کوتاه مدت");
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

        LoadUser();

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




    @FXML
    void create(ActionEvent event) {
        // تولید شماره حساب ۱۴ رقمی
        String accountNumber = generateRandomNumber(14);
        AccNum.setText(accountNumber);

        // تولید کد شبا ۲۴ رقمی که با "IR" شروع شود
        String shabaNumber = "IR" + generateRandomNumber(22);
        ShabaNum.setText(shabaNumber);

        // مقداردهی اولیه بخش‌های کارت بانکی
        CardNum1.setText("6393");
        CardNum2.setText("4610");
        CardNum3.setText(generateRandomNumber(4));
        CardNum4.setText(generateRandomNumber(4));

        // تنظیم تاریخ انقضا (۵ سال بعد بدون روز)
        LocalDate expirationDate = LocalDate.now().plusYears(5);
        ExpDate.setValue(expirationDate);

        // تولید CVV2 سه رقمی
        CVV2Num.setText(generateRandomNumber(3));

        // تولید رمز کارت ۴ رقمی
        CardPass.setText(generateRandomNumber(4));
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
    void registration(ActionEvent event) {
        // دریافت اطلاعات از تکست‌فیلدها
        String firstName = USFName.getText();
        String lastName = USLname.getText();
        String nationalCode = NationalCode.getText();
        LocalDate birthDate = BirthDate.getValue();
        String selectedGender = gender.getSelectionModel().getSelectedItem();
        String userName = "";
        String mobile ="";
        String userEmail = "";
        String userPassword = "";
        String AccountNumber = AccNum.getText();
        String ShabaNumber = ShabaNum.getText();
        String CardNumber = CardNum1.getText() + CardNum2.getText() + CardNum3.getText() + CardNum4.getText();
        String expirationDate = ExpDate.getValue().toString();
        String CVV2Numer = CVV2Num.getText();
        String inventoryPrice = inventory.getText();
        String AccountType = AccType.getValue();
        String CardPassvord = CardPass.getText();

        try {
            Double.parseDouble(inventoryPrice); // سعی در تبدیل به عدد
        } catch (NumberFormatException e) {
            showAlert("خطا", "مقدار وارد شده در موجودی اولیه باید عدد باشد!", Alert.AlertType.ERROR);
            return; // اگر عدد نیست از متد خارج شو
        }

        if (firstName.isEmpty() || lastName.isEmpty() || nationalCode.isEmpty() || birthDate == null ||
                selectedGender == null || AccountNumber.isEmpty() || ShabaNumber.isEmpty() ||CardNumber.isEmpty() ||CVV2Numer.isEmpty() ||inventoryPrice.isEmpty() ||CardPassvord.isEmpty()
                ||expirationDate == null ||  AccountType == null ) {

            showAlert("خطا", "تمام فیلدها را پر کنید!", Alert.AlertType.ERROR);
            return; // خروج از متد
        }

        // ایجاد یک ID یکتا برای کاربر با استفاده از کد ملی و UUID
        String userId =  "@" + UUID.randomUUID().toString().substring(0, 8);

        // نوشتن اطلاعات در فایل
        try {
            File file = new File("user.txt");
            FileWriter writer = new FileWriter(file, true);  // true برای افزودن به فایل موجود
            writer.write("User ID: " + userId + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("National Code: " + nationalCode + "\n");
            writer.write("Birth Date: " + birthDate + "\n");
            writer.write("Gender: " + selectedGender + "\n");
            writer.write("Username: " + userName + "\n");
            writer.write("Mobile Number: " + mobile + "\n");
            writer.write("Email: " + userEmail + "\n");
            writer.write("Password: " + userPassword + "\n");
            writer.write("---------------\n");  // خط جداکننده برای هر کاربر
            writer.close();

            File newFile = new File("userID.txt");
            FileWriter myWriter = new FileWriter(newFile, true);
            myWriter.write("User ID: " + userId + "\n");
            myWriter.write("Account Number: " + AccountNumber + "\n");
            myWriter.write("Shaba Number: " + ShabaNumber + "\n");
            myWriter.write("Card Number: " + CardNumber + "\n");
            myWriter.write("Card Passvord: " + CardPassvord + "\n");
            myWriter.write("expiration Date: " + expirationDate + "\n");
            myWriter.write("CVV2 Number: " + CVV2Numer + "\n");
            myWriter.write("Account Type: " + AccountType + "\n");
            myWriter.write("inventory Price: " +  inventoryPrice  + CURRENCY + "\n");
            myWriter.write("---------------\n");
            myWriter.close();

            // پاک کردن محتویات فیلدها پس از ثبت اطلاعات
            clearFields();

            // نمایش پیام موفقیت
            showAlert("موفقیت", "کاربر با موفقیت ثبت شد!", Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            showAlert("خطا", "مشکلی در ذخیره اطلاعات رخ داده است!", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
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
        ExpDate.setValue(null);
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
            if (amount > 100_000_000) {
                showAlert("مبلغ بیش از حد مجاز", "مبلغ وارد شده بیش از 100 میلیون تومان است!");
                return;
            }

            // ذخیره مقدار در خانه اول آرایه
            transferArray[0] = amount;

            // مخفی کردن عنصر
            one.setVisible(false);
            one.setManaged(false);

            // پیام موفقیت‌آمیز
            showAlert("موفقیت", "مبلغ ذخیره شد: " + amount);
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
                showAlert("خطا", "مبلغ وارد شده بیش از 100 میلیون تومان است!");
                return;
            }
            if (!cardNum.matches("\\d{16}")) {
                showAlert("خطا", "شماره کارت نامعتبر است! باید 16 رقم باشد.");
                return;
            }

            // ذخیره شماره کارت در آرایه
            transferArray[1] = "کارت";
            transferArray[2] = cardNum;
            showAlert("موفقیت", "شماره کارت ثبت شد.");

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = searchUserIDByCardNumber(cardNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
                    transferArray[3] = userInfo[0] + " " + userInfo[1]; // ذخیره در آرایه
                } else {
                    showAlert("خطا", "اطلاعات کاربر یافت نشد.");
                }
            } else {
                showAlert("خطا", "شماره کارت معتبر نیست.");
            }

        } else if (!depositNum.isEmpty()) {
            if (amount > 1_000_000_000) {
                showAlert("خطا", "مبلغ وارد شده بیش از 1 میلیارد تومان است!");
                return;
            }
            if (!depositNum.matches("\\d{14}")) {
                showAlert("خطا", "شماره سپرده نامعتبر است! باید 14 رقم باشد.");
                return;
            }

            transferArray[1] = "سپرده";
            transferArray[2] = depositNum;
            showAlert("موفقیت", "شماره سپرده ثبت شد.");

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = searchUserIDByAccountNumber(depositNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
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
            showAlert("موفقیت", "شماره شبا ثبت شد.");

            // جستجو برای پیدا کردن User ID از شماره کارت
            String userID = searchUserIDByShabaNumber(shabaNum);
            if (userID != null) {
                // جستجو برای یافتن نام و نام خانوادگی کاربر
                String[] userInfo = searchUserInfoByUserID(userID);
                if (userInfo != null) {
                    setUserInfoInUI(userInfo[0], userInfo[1]);  // نمایش نام و نام خانوادگی
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

        for (int i = 0; i < 4; i++) {
            System.out.println("transferArray[" + i + "]: " + transferArray[i]);
        }

        PriceLabel.setText(transferArray[0].toString());
        destinationLabel.setText(transferArray[2].toString());
        NameLabel.setText(transferArray[3].toString());

        // مخفی کردن بخش مربوطه
        Two.setVisible(false);
        Two.setManaged(false);
    }

    private String searchUserIDByCardNumber(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            String userID = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                // چاپ برای دیباگ
                System.out.println("خط از فایل: " + line);
                reader.readLine();
                reader.readLine();
                String Code = reader.readLine();


                // بررسی می‌کنیم که آیا خط چهارم شامل شماره کارت مورد نظر است
                if (Code.startsWith("Card Number:")) {
                    String storedCardNumber = Code.split(":")[1].trim(); // گرفتن شماره کارت از فایل
                    String userInputCardNumber = cardNumber.trim(); // حذف فضای اضافی از ورودی کاربر


                    if (storedCardNumber.equals(userInputCardNumber)) {
                        // اگر شماره کارت مطابقت داشته باشد، سطر اول را که User ID است می‌خوانیم
                        userID = line; // سطر بعدی که User ID است
                        // چاپ userID برای دیباگ
                        break;
                    }
                }

                // عبور از ۹ خط دیگر برای رسیدن به اطلاعات کاربر بعدی
                for (int i = 0; i < 6; i++) {
                    reader.readLine(); // عبور از بقیه خطوط
                }
            }

            return userID != null ? userID.split(":")[1].trim() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String searchUserIDByAccountNumber(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            String userID = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                // چاپ برای دیباگ
                System.out.println("خط از فایل: " + line);
                String Code = reader.readLine();


                // بررسی می‌کنیم که آیا خط چهارم شامل شماره کارت مورد نظر است
                if (Code.startsWith("Account Number:")) {
                    String storedCardNumber = Code.split(":")[1].trim(); // گرفتن شماره کارت از فایل
                    String userInputCardNumber = cardNumber.trim(); // حذف فضای اضافی از ورودی کاربر



                    if (storedCardNumber.equals(userInputCardNumber)) {
                        // اگر شماره کارت مطابقت داشته باشد، سطر اول را که User ID است می‌خوانیم
                        userID = line; // سطر بعدی که User ID است
                        // چاپ userID برای دیباگ
                        break;
                    }
                }

                // عبور از ۹ خط دیگر برای رسیدن به اطلاعات کاربر بعدی
                for (int i = 0; i < 8; i++) {
                    reader.readLine(); // عبور از بقیه خطوط
                }
            }

            return userID != null ? userID.split(":")[1].trim() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String searchUserIDByShabaNumber(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            String userID = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                // چاپ برای دیباگ
                System.out.println("خط از فایل: " + line);
                reader.readLine();
                String Code = reader.readLine();


                // بررسی می‌کنیم که آیا خط چهارم شامل شماره کارت مورد نظر است
                if (Code.startsWith("Shaba Number:")) {
                    String storedCardNumber = Code.split(":")[1].trim(); // گرفتن شماره کارت از فایل
                    String userInputCardNumber = cardNumber.trim(); // حذف فضای اضافی از ورودی کاربر



                    if (storedCardNumber.equals(userInputCardNumber)) {
                        // اگر شماره کارت مطابقت داشته باشد، سطر اول را که User ID است می‌خوانیم
                        userID = line; // سطر بعدی که User ID است
                        // چاپ userID برای دیباگ
                        break;
                    }
                }

                // عبور از ۹ خط دیگر برای رسیدن به اطلاعات کاربر بعدی
                for (int i = 0; i < 7; i++) {
                    reader.readLine(); // عبور از بقیه خطوط
                }
            }

            return userID != null ? userID.split(":")[1].trim() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[] searchUserInfoByUserID(String userID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            String firstName = null;
            String lastName = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User ID: " + userID)) {
                    // به دنبال نام و نام خانوادگی می‌گردیم
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("First Name:")) {
                            firstName = line.split(":")[1].trim();
                        } else if (line.startsWith("Last Name:")) {
                            lastName = line.split(":")[1].trim();
                        }
                        if (firstName != null && lastName != null) {
                            break;
                        }
                    }
                    return new String[] { firstName, lastName };
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void setUserInfoInUI(String firstName, String lastName) {
        transferArray[3]= firstName + " " + lastName;
    }




    @FXML
    void Back (ActionEvent event) {
        one.setVisible(true);  // عنصر را نامرئی می‌کند
        one.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void next2 (ActionEvent event) {
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
        Three.setVisible(false);  // عنصر را نامرئی می‌کند
        Three.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void Back1 (ActionEvent event) {
        Two.setVisible(true);  // عنصر را نامرئی می‌کند
        Two.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

//    @FXML
//    void ReceivePassword(ActionEvent event) {
//        String CartNumber =OriginCardNumberLabel.getText();
//        String [] Date = searchYear(CartNumber);
//        String txtYear = Year1.getText();
//        String txtMonth = Month1.getText();
//        String cvv2 = CVV2.getText();
//
//        if (txtYear.isEmpty() || txtMonth.isEmpty() || cvv2.isEmpty()) {
//            showAlert("خطا", "لطفاً سال و ماه و CVV2 را وارد کنید.");
//            return; // از ادامه اجرا جلوگیری می‌کنیم
//        }
//        if(Date!=null){
//            String Year = Date[0];
//            String Month = Date[1];
//            if(Year.equals(txtYear) && Month.equals(txtMonth)){
//                // جستجو برای پیدا کردن User ID از شماره کارت
//                String userID = searchUserIDByCardNumber(CartNumber);
//                if (userID != null) {
//                    // جستجو برای یافتن نام و نام خانوادگی کاربر
//                    String userInfo = searchUserEmail(userID);
//                    if (userInfo != null) {
//                        String recipient = userInfo; // ایمیل گیرنده
//                        String code = generateRandomCode(); // تولید رمز تصادفی
//                        boolean isSent = sendEmail(recipient, code);
//                        if (isSent) {
//                            showAlert("موفقیت", "رمز پویا به ایمیل شما ارسال گردید !");
//                        } else {
//                            showAlert("خطا", "ارسال رمز نا موفق!");
//                        }
//                    } else {
//                        showAlert("خطا", "اطلاعات کاربر یافت نشد.");
//                    }
//                } else {
//                    showAlert("خطا", "شماره کارت معتبر نیست.");
//                }
//            }else {
//                showAlert("خطا!","تاریخ انقضا اشتباه هست !");
//            }
//
//        }else {
//            showAlert("خطا!","تاریخ انقضا پیدا نشد");
//        }
//
//    }

    private String sentCode;  // برای ذخیره کد ارسال‌شده به ایمیل


    @FXML
    void ReceivePassword(ActionEvent event) {
        String CartNumber = OriginCardNumberLabel.getText();
        String[] data = searchYear(CartNumber);  // تغییر نام متغیر Date به data
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
                String userID = searchUserIDByCardNumber(CartNumber);
                if (userID != null) {
                    // جستجو برای یافتن نام و نام خانوادگی کاربر
                    String userInfo = searchUserEmail(userID);
                    if (userInfo != null) {
                        String recipient = userInfo; // ایمیل گیرنده
                        String code = generateRandomCode(); // تولید رمز تصادفی
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


    private String[] searchYear(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;

            // متغیرهای سال، ماه و CVV2 برای ذخیره
            String year = null;
            String month = null;
            String cvv2 = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                // عبور از خطوط غیر ضروری
                reader.readLine();  // عبور از خط بعدی
                reader.readLine();  // عبور از خط بعدی
                String code = reader.readLine();  // خواندن کد کارت

                // بررسی می‌کنیم که آیا خط چهارم شامل شماره کارت مورد نظر است
                if (code.startsWith("Card Number:")) {
                    String storedCardNumber = code.split(":")[1].trim();  // گرفتن شماره کارت از فایل
                    String userInputCardNumber = cardNumber.trim();  // حذف فضای اضافی از ورودی کاربر
                    reader.readLine();
                    // اگر شماره کارت‌ها برابر بودند
                    if (storedCardNumber.equals(userInputCardNumber)) {

                        String date = reader.readLine().split(":")[1].trim();  // گرفتن تاریخ
                        String cvv2Line = reader.readLine().split(":")[1].trim();  // گرفتن CVV2

                        // بررسی اینکه تاریخ فرمت درست داشته باشد
                        if (date.contains("-")) {
                            String[] parts = date.split("-");

                            // بررسی اینکه آرایه دارای دو قسمت باشد
                            if (parts.length == 2) {
                                year = parts[0];  // سال
                                month = parts[1];  // ماه
                            } else {
                                System.out.println("فرمت تاریخ اشتباه است: " + date);
                            }
                        } else {
                            System.out.println("تاریخ فرمت اشتباهی دارد: " + date);
                        }

                        cvv2 = cvv2Line;  // ذخیره CVV2
                        break;  // پس از پیدا کردن شماره کارت، تاریخ و CVV2، از حلقه خارج می‌شویم
                    }
                }
            }

            // اگر سال، ماه یا CVV2 مقداردهی نشد، null برگشت می‌دهیم
            if (year == null || month == null || cvv2 == null) {
                return null;
            }

            // بازگشت سال، ماه و CVV2
            return new String[]{year, month, cvv2};

        } catch (IOException e) {
            e.printStackTrace();
        }

        // در صورتی که خطای ورودی یا خروجی رخ دهد، null برمی‌گردانیم
        return null;
    }



    private String searchUserEmail(String userID) {

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            String Email= "";

            while ((line = reader.readLine()) != null) {
                if (line.equals(userID)) {
                    reader.readLine();
                    Email = reader.readLine();
                    return Email;

                }else {

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateRandomCode() {
        SecureRandom random = new SecureRandom();
        int code = 100000 + random.nextInt(900000); // تولید عدد ۶ رقمی تصادفی
        return String.valueOf(code);
    }

    private static boolean sendEmail(String recipient, String code) {
        final String senderEmail = "bookstore.java.1403@gmail.com";
        final String senderPassword = "grgf ycdk suio bxbl"; // امنیتی نیست، باید از OAuth استفاده کنید

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("*بانک جاواد*");
            message.setText("رمز اینترنتی شما : " + code);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    void next3(ActionEvent event) {
        String enteredCode = Password.getText();  // کد واردشده توسط کاربر از تکست فیلد Password

        // بررسی اینکه کد واردشده با کد ارسال‌شده برابر باشد
        if (sentCode != null && sentCode.equals(enteredCode)) {
            // اگر کدها برابر بودند، عملیات زیر را انجام بده
            Four.setVisible(false);  // عنصر را نامرئی می‌کند
            Four.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند
        } else {
            showAlert("خطا", "کد وارد شده اشتباه است.");
        }
    }



    @FXML
    void Back2 (ActionEvent event) {
        Three.setVisible(true);  // عنصر را نامرئی می‌کند
        Three.setManaged(true);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
    }

    @FXML
    void End (ActionEvent event) {
        Five.setVisible(false);  // عنصر را نامرئی می‌کند
        Five.setManaged(false);  // فضای عنصر را از Layout حذف می‌کند (اختیاری)
        one.setVisible(true);
        Two.setVisible(true);
        Three.setVisible(true);
        Four.setVisible(true);
        Five.setVisible(true);
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
    void SearchCode (MouseEvent event) {
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
    void CancelId (MouseEvent event) {
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
    void CancelCode (MouseEvent event) {
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
}
