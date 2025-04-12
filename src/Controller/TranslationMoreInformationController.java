package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static Controller.transferItemController.*;

public class TranslationMoreInformationController {
    @FXML
    private Label Amount;

    @FXML
    private Label Card1;

    @FXML
    private Label Code;

    @FXML
    private Label Date;

    @FXML
    private Label bCard;

    @FXML
    private Label Name;

    @FXML
    private Label Name1;

    @FXML
    private Label Time;

    @FXML
    private Label cardNumber;

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
            FileReader Transfers = new FileReader("Transfers.txt");
            Scanner scanner = new Scanner(Transfers);
            while (scanner.hasNextLine()) {
                String amount = extractValue(scanner.nextLine());
                String type = extractValue(scanner.nextLine());
                String cardmax = extractValue(scanner.nextLine());
                String namemax = extractValue(scanner.nextLine());
                String cardmab = extractValue(scanner.nextLine());
                String namemab = extractValue(scanner.nextLine());
                String code = extractValue(scanner.nextLine());
                String date = extractValue(scanner.nextLine());
                String time = extractValue(scanner.nextLine());
                scanner.nextLine();
                if (date.equals(Date123) && time.equals(Time123)) {
                    bCard.setText("به " + type);
                    cardNumber.setText(cardmab);
                    Name.setText(namemab);
                    Card1.setText(cardmax);
                    Name1.setText(namemax);
                    Code.setText(code);
                    Amount.setText(amount + " ریال");
                }

            }



    }

}
