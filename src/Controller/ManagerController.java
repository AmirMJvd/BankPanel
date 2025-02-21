package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import static main.Main.CURRENCY;

public class ManagerController {

    @FXML
    private TextField AccNum;

    @FXML
    private ComboBox<String> AccType;

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
    private TextField ManFName;

    @FXML
    private TextField ManLName;

    @FXML
    private TextField NationalCode;

    @FXML
    private TextField Password;

    @FXML
    private TextField PasswordRepetition;

    @FXML
    private Label Role;

    @FXML
    private ComboBox<String> RoleCombo;

    @FXML
    private ComboBox<String> branch;

    @FXML
    private TextField ShabaNum;

    @FXML
    private TextField USFName;

    @FXML
    private TextField USLname;

    @FXML
    private TextField UserName;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private TextField inventory;

    private String userID;

    private final SecureRandom random = new SecureRandom(); // برای تولید اعداد تصادفی امن‌تر

    @FXML
    public void initialize() {
        gender.getItems().addAll("مرد", "زن");
        AccType.getItems().addAll("بلند مدت" , "کوتاه مدت");
        RoleCombo.getItems().addAll("مدیر" , "کارمند");
        branch.getItems().addAll("مرکزی" , "آبرسان","شهناز");
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

    // این متد برای دریافت userID از LoginController است
    public void setUserID(String userID) {
        this.userID = userID;
        // حالا می‌توانید از userID در هر متدی که نیاز دارید استفاده کنید.
    }

    @FXML
    void RegistrationAdmin (ActionEvent event) {
        String username = UserName.getText().trim();
        String phone = ManLName.getText().trim();
        String birthDate = ManFName.getText().trim();
        String pass = Password.getText().trim();
        String passRepeat = PasswordRepetition.getText().trim();
        String selectedGender = RoleCombo.getSelectionModel().getSelectedItem();
        String selectedGender1 = branch.getSelectionModel().getSelectedItem();

        // بررسی اینکه هیچ فیلدی خالی نباشد
        if (username.isEmpty() || phone.isEmpty() || birthDate.isEmpty() || pass.isEmpty() || passRepeat.isEmpty()) {
            showAlert1(Alert.AlertType.ERROR, "خطا", "تمامی فیلدها باید پر شوند!");
            return;
        }

        // بررسی مطابقت رمز عبور
        if (!pass.equals(passRepeat)) {
            showAlert1(Alert.AlertType.ERROR, "خطا", "رمز عبور و تکرار آن مطابقت ندارند!");
            return;
        }

        // بررسی اینکه نام کاربری از قبل وجود نداشته باشد
        if (isUsernameExists(username)) {
            showAlert1(Alert.AlertType.ERROR, "خطا", "این نام کاربری قبلاً ثبت شده است!");
            return;
        }

        // ذخیره اطلاعات در فایل
        saveUserData(username, pass, phone, birthDate , selectedGender ,selectedGender1);
        showAlert1(Alert.AlertType.INFORMATION, "موفقیت", "ثبت‌نام با موفقیت انجام شد!");
        clearFields1();
    }

    private boolean isUsernameExists(String username) {
        File file = new File("users.txt");
        if (!file.exists()) return false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String existingUsername = scanner.nextLine().trim();
                if (existingUsername.equals(username)) {
                    return true;  // نام کاربری یافت شد
                }
                // رد شدن از سطرهای دیگر (رمز عبور، شماره موبایل، تاریخ تولد، نوع کاربر)
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
                if (scanner.hasNextLine()) scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void saveUserData(String username, String password, String phone, String birthDate,String selectedGender,String selectedGender1) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {

            writer.write(username + "\n");
            writer.write(password + "\n");
            writer.write(selectedGender1 + "\n");
            writer.write(phone + "\n");
            writer.write(birthDate + "\n");
            writer.write(selectedGender +"\n"); // سطر پنجم مشخص‌کننده نوع کاربر
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert1(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields1() {
        UserName.clear();
        ManLName.clear();
        ManFName.clear();
        Password.clear();
        PasswordRepetition.clear();
        RoleCombo.getSelectionModel().clearSelection();
    }


}
