package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class findInformation {

    // تابع برای استخراج مقادیر از خط‌ها
    private String extractValue(String line) {
        // فرض بر این است که حرف اضافه با دو نقطه (: ) تمام می‌شود.
        if (line.contains(":")) {
            return line.split(":")[1].trim();  // مقدار بعد از ":" را گرفته و فضای اضافی را حذف می‌کنیم.
        }
        return line.trim();  // در صورتی که ":" وجود نداشت، کل خط را trim می‌کنیم.
    }

    public static Double searchUserinventoryByAccountNumber(String accountNumber) throws FileNotFoundException {
        File file = new File("userID.txt");
        Scanner scanner = new Scanner(file);
        Double inventory = null;
        boolean found = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); // حذف فاصله‌های اضافی

            if (line.startsWith("Account Number: ") && line.contains(accountNumber)) {
                found = true;
                // رد کردن 6 خط بعدی
                for (int i = 0; i < 6 && scanner.hasNextLine(); i++) {
                    scanner.nextLine();
                }

                // خواندن مقدار موجودی
                if (scanner.hasNextLine()) {
                    String inventoryLine = scanner.nextLine().trim();

                    // استخراج مقدار عددی از خط
                    if (inventoryLine.startsWith("inventory Price: ")) {
                        String inventoryValue = inventoryLine.replaceAll("[^0-9]", ""); // حذف کاراکترهای غیرعددی
                        inventory = Double.parseDouble(inventoryValue);
                    }
                }
                break; // بعد از پیدا کردن مقدار، از حلقه خارج شو
            }
        }

        scanner.close(); // بستن فایل برای جلوگیری از نشتی منابع

        return found ? inventory : null; // اگر پیدا شد مقدار را برگردان، در غیر این صورت null
    }

    public static Double searchUserinventoryByShabaNumber(String ShabaNumber) throws FileNotFoundException {
        File file = new File("userID.txt");
        Scanner scanner = new Scanner(file);
        Double inventory = null;
        boolean found = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); // حذف فاصله‌های اضافی

            if (line.startsWith("Shaba Number: ") && line.contains(ShabaNumber)) {
                found = true;
                // رد کردن 6 خط بعدی
                for (int i = 0; i < 5 && scanner.hasNextLine(); i++) {
                    scanner.nextLine();
                }

                // خواندن مقدار موجودی
                if (scanner.hasNextLine()) {
                    String inventoryLine = scanner.nextLine().trim();

                    // استخراج مقدار عددی از خط
                    if (inventoryLine.startsWith("inventory Price: ")) {
                        String inventoryValue = inventoryLine.replaceAll("[^0-9]", ""); // حذف کاراکترهای غیرعددی
                        inventory = Double.parseDouble(inventoryValue);
                    }
                }
                break; // بعد از پیدا کردن مقدار، از حلقه خارج شو
            }
        }

        scanner.close(); // بستن فایل برای جلوگیری از نشتی منابع

        return found ? inventory : null; // اگر پیدا شد مقدار را برگردان، در غیر این صورت null
    }

    public static Double searchUserinventoryByCardNumber(String cardNumber) throws FileNotFoundException {
        File file = new File("userID.txt");
        Scanner scanner = new Scanner(file);
        Double inventory = null;
        boolean found = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); // حذف فاصله‌های اضافی

            if (line.startsWith("Card Number: ") && line.contains(cardNumber)) {
                found = true;
                // رد کردن 6 خط بعدی
                for (int i = 0; i < 4 && scanner.hasNextLine(); i++) {
                    scanner.nextLine();
                }

                // خواندن مقدار موجودی
                if (scanner.hasNextLine()) {
                    String inventoryLine = scanner.nextLine().trim();

                    // استخراج مقدار عددی از خط
                    if (inventoryLine.startsWith("inventory Price: ")) {
                        String inventoryValue = inventoryLine.replaceAll("[^0-9]", ""); // حذف کاراکترهای غیرعددی
                        inventory = Double.parseDouble(inventoryValue);
                    }
                }
                break; // بعد از پیدا کردن مقدار، از حلقه خارج شو
            }
        }

        scanner.close(); // بستن فایل برای جلوگیری از نشتی منابع

        return found ? inventory : null; // اگر پیدا شد مقدار را برگردان، در غیر این صورت null
    }

    public static void updateInventoryByAccountNumber(String accountNumber, BigDecimal remainingAmount) throws FileNotFoundException {
        String fileName = "userID.txt";
        List<String> lines = new ArrayList<>();

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Account Number: " + accountNumber)) {
                    int targetLineIndex = i + 7; // رفتن به خط هشتم

                    if (targetLineIndex < lines.size()) {
                        // تغییر مقدار inventory
                        lines.set(targetLineIndex, "inventory Price: " + remainingAmount + "  ريال");
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

    public static void updateInventoryByShabaNumber(String ShabaNumber, BigDecimal remainingAmount) throws FileNotFoundException {
        String fileName = "userID.txt";
        List<String> lines = new ArrayList<>();

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Shaba Number: " + ShabaNumber)) {
                    int targetLineIndex = i + 6; // رفتن به خط هشتم

                    if (targetLineIndex < lines.size()) {
                        // تغییر مقدار inventory
                        lines.set(targetLineIndex, "inventory Price: " + remainingAmount + "  ريال");
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

    public static void updateInventoryByCardNumber(String CardNumber, BigDecimal remainingAmount) throws FileNotFoundException {
        String fileName = "userID.txt";
        List<String> lines = new ArrayList<>();

        try {
            // خواندن تمام خطوط فایل
            lines = Files.readAllLines(Paths.get(fileName));

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).trim().equals("Card Number: " + CardNumber)) {
                    int targetLineIndex = i + 5; // رفتن به خط هشتم

                    if (targetLineIndex < lines.size()) {
                        // تغییر مقدار inventory
                        lines.set(targetLineIndex, "inventory Price: " + remainingAmount + "  ريال");
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

    public static String[] searchYearMounthCvv2(String cardNumber) {
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
                if (code.startsWith("Card Number: " + cardNumber)) {
                    String storedCardNumber = code.split(":")[1].trim();  // گرفتن شماره کارت از فایل
                    String userInputCardNumber = cardNumber.trim();  // حذف فضای اضافی از ورودی کاربر
                    reader.readLine();
                    // اگر شماره کارت‌ها برابر بودند
                    if (storedCardNumber.equals(userInputCardNumber)) {

                        String date = reader.readLine().split(":")[1].trim();  // گرفتن تاریخ
                        String cvv2Line = reader.readLine().split(":")[1].trim();  // گرفتن CVV2

                        // بررسی اینکه تاریخ فرمت درست داشته باشد
                        if (date.contains("/")) {
                            String[] parts = date.split("/");

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
                    }else {

                    }
                }else {

                    for (int i =0; i<7 ;i++){
                        reader.readLine();
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

    public static String searchUserIDByCardNumber(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            String userID = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                reader.readLine();
                reader.readLine();
                String Code = reader.readLine();

                // بررسی می‌کنیم که آیا خط چهارم شامل شماره کارت مورد نظر است
                if (Code.startsWith("Card Number: ")) {
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

    public static String[] searchUserInfoByUserID(String userID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            String firstName = null;
            String lastName = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User ID: " + userID)) {
                    // به دنبال نام و نام خانوادگی می‌گردیم
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("First Name: ")) {
                            firstName = line.split(":")[1].trim();
                        } else if (line.startsWith("Last Name: ")) {
                            lastName = line.split(":")[1].trim();
                        }
                        if (firstName != null && lastName != null) {
                            break;
                        }
                    }
                    return new String[]{firstName, lastName};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String searchUserIDByAccountNumber(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            String userID = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                // چاپ برای دیباگ

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
                for (int i = 0; i < 9; i++) {
                    reader.readLine(); // عبور از بقیه خطوط
                }
            }

            return userID != null ? userID.split(":")[1].trim() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String searchUserIDByShabaNumber(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            String userID = null;

            // در هر بار 10 خط می‌خوانیم چون هر کاربر 10 سطر دارد
            while ((line = reader.readLine()) != null) {
                // چاپ برای دیباگ

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

    public  static String searchUserEmail(String userID) {

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            String Email = "";

            while ((line = reader.readLine()) != null) {
                if (line.equals(userID)) {
                    reader.readLine();
                    Email = reader.readLine();
                    return Email;
                } else {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public   static boolean sendEmail(String recipient, String code) {
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


}
