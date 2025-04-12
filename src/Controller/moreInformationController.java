package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static Controller.transferItemController.*;
import static service.findInformation.searchUserIDByCardNumber;
import static service.findInformation.searchUserInfoByUserID;

public class moreInformationController {

    @FXML
    private Label Amount;

    @FXML
    private Label Code;

    @FXML
    private Label Name;

    @FXML
    private Label cardNumber;

    @FXML
    private Label Date;

    @FXML
    private Label Time;

    String Type = Type123;

    @FXML
    private void initialize() throws FileNotFoundException {
        Date.setText(Date123);
        Time.setText(Time123);
        Type = Type123;
        setData();
    }

    // تابع برای استخراج مقادیر از خط‌ها
    private String extractValue(String line) {
        // فرض بر این است که حرف اضافه با دو نقطه (: ) تمام می‌شود.
        int colonIndex = line.indexOf(":");
        if (colonIndex != -1) {
            return line.substring(colonIndex + 1).trim();  // کل مقدار بعد از اولین ":" را می‌گیرد.
        }
        return line.trim();  // در صورتی که ":" وجود نداشت، کل خط را trim می‌کنیم.
    }

    private void setData() throws FileNotFoundException {
        if(Type.startsWith(" پرداخت قبض ")) {

            FileReader Bill = new FileReader("Bill.txt");
            Scanner scanner = new Scanner(Bill);
            while(scanner.hasNextLine()) {
                for(int i =0;i<4;i++){
                    scanner.nextLine();
                }

                String amount = extractValue(scanner.nextLine());
                for(int i =0;i<3;i++){
                    scanner.nextLine();
                }
                String card = extractValue(scanner.nextLine());
                String code = extractValue(scanner.nextLine());
                String date = extractValue(scanner.nextLine());
                String time = extractValue(scanner.nextLine());
                scanner.nextLine();
                if(date.equals( Date123)&&time.equals(Time123)){
                    String userId = searchUserIDByCardNumber(card);
                    String[] name = searchUserInfoByUserID(userId);


                    Name.setText(name[0]+" "+name[1]);
                    cardNumber.setText(card);
                    Code.setText(code);
                    Amount.setText(amount+" ریال");
                }

            }

        }else if(Type123.startsWith(" شارژ تلفن همراه ")){
            FileReader Phone = new FileReader("PhoneCharge.txt");
            Scanner scanner = new Scanner(Phone);
            while(scanner.hasNextLine()) {
                scanner.nextLine();
                String amount = extractValue(scanner.nextLine());
                scanner.nextLine();
                scanner.nextLine();
                String card = extractValue(scanner.nextLine());
                String name = extractValue(scanner.nextLine());
                String code = extractValue(scanner.nextLine());
                String date = extractValue(scanner.nextLine());
                String time = extractValue(scanner.nextLine());
                scanner.nextLine();
                if(date.equals( Date123)&&time.equals(Time123)){
                    Name.setText(name);
                    cardNumber.setText(card);
                    Code.setText(code);
                    Amount.setText(amount+" ریال");
                }

            }

        }else if(Type123.startsWith("برداشت وجه")||Type123.startsWith("واریز وجه")||Type123.startsWith("واریز سود")){
            FileReader diposit = new FileReader("Deposits.txt");
            Scanner scanner = new Scanner(diposit);
            while(scanner.hasNextLine()) {
                String amount = extractValue(scanner.nextLine());
                scanner.nextLine();
                String deposit = extractValue(scanner.nextLine());
                String name = extractValue(scanner.nextLine());
                String code = extractValue(scanner.nextLine());
                String date = extractValue(scanner.nextLine());
                String time = extractValue(scanner.nextLine());
                scanner.nextLine();
                if(date.equals( Date123)&&time.equals(Time123)){
                    Name.setText(name);
                    cardNumber.setText(deposit);
                    Code.setText(code);
                    Amount.setText(amount+" ریال");
                }

            }
        }
    }
}
