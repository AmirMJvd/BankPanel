package service;

import model.Account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

import static service.findInformation.*;

public class AccountManager {

    private Double profit = 0.0;

    Account account = new Account();

    LocalDate today = LocalDate.now();

    private String extractValue(String line) {
        int colonIndex = line.indexOf(":");
        if (colonIndex != -1) {
            return line.substring(colonIndex + 1).trim();
        }
        return line.trim();
    }

    public void ReadFile() throws IOException {
        FileReader fr = new FileReader("userID.txt");
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
//            account.setUserId(extractValue(sc.nextLine()));
//            account.setAccountNumber(extractValue(sc.nextLine()));
//            for (int j = 0; j < 5; j++) {
//                sc.nextLine();
//            }
//            account.setAccountType(extractValue(sc.nextLine()));
//            account.setInventoryPrice(extractValue(sc.nextLine()));
//            account.setCreateDate(extractValue(sc.nextLine()));
//            sc.nextLine();
        if (!sc.hasNextLine()) break;

        account.setUserId(extractValue(sc.nextLine()));

        if (!sc.hasNextLine()) break;
        account.setAccountNumber(extractValue(sc.nextLine()));

        for (int j = 0; j < 5; j++) {
            if (!sc.hasNextLine()) break;
            sc.nextLine();
        }

        if (!sc.hasNextLine()) break;
        account.setAccountType(extractValue(sc.nextLine()));

        if (!sc.hasNextLine()) break;
        account.setInventoryPrice(extractValue(sc.nextLine()));

        if (!sc.hasNextLine()) break;
        account.setCreateDate(extractValue(sc.nextLine()));

        if (!sc.hasNextLine()) break;
        sc.nextLine();



        if(account.getAccountType().equals("سپرده سرمایه گذاری کوتاه مدت") || account.getAccountType().equals("سپرده سرمایه گذاری بلند مدت") ){
                String LastDate = CalculatingTheNumberOfWinningsCast(account.getAccountNumber());
                if (LastDate.equals("")){
                    LocalDate givenDate = LocalDate.parse(account.getCreateDate(), DateTimeFormatter.ISO_LOCAL_DATE);
                    int daysBetween = (int) ChronoUnit.DAYS.between(givenDate, today);
                    if (daysBetween != 0) {
                        profit = ProfitCalculation(account.getAccountNumber(), account.getAccountType(), daysBetween);
                        BigDecimal bigDecimal = new BigDecimal(Math.round(profit));
                        WriteFile(bigDecimal, account.getAccountNumber(), today);
                        updateInventoryByAccountNumber(account.getAccountNumber(), bigDecimal);
                    }
                }else{

                    LocalDate givenDate = LocalDate.parse(LastDate, DateTimeFormatter.ISO_LOCAL_DATE);
                    int daysBetween = (int) ChronoUnit.DAYS.between(givenDate, today);
                    if (daysBetween != 0){
                        profit = ProfitCalculation(account.getAccountNumber(), account.getAccountType(), daysBetween);
                        BigDecimal bigDecimal = new BigDecimal(profit);
                        WriteFile(bigDecimal,account.getAccountNumber(),today);
                        updateInventoryByAccountNumber(account.getAccountNumber(),bigDecimal);
                    }


                }
            }

        }
        sc.close();
    }


    private Double ProfitCalculation(String AccountNumber, String AccountType, int count) throws FileNotFoundException {
        Double inventory = searchUserinventoryByAccountNumber(AccountNumber);
        return calculateCompoundProfit(inventory, AccountType, count);
    }

    private Double calculateCompoundProfit(Double inventory, String AccountType, int count) {
        if (count <= 0) {
            return inventory;
        }

        Double monthlyRate = 0.0;
        if (AccountType.equals("سپرده سرمایه گذاری بلند مدت")) {
            monthlyRate = 0.02;
        } else if (AccountType.equals("سپرده سرمایه گذاری کوتاه مدت")) {
            monthlyRate = 0.015;
        }

        Double newInventory = inventory + (inventory * monthlyRate);
        return calculateCompoundProfit(newInventory, AccountType, count - 1);
    }




    private String CalculatingTheNumberOfWinningsCast(String AccountNumber) throws FileNotFoundException {
        FileReader fr = new FileReader("Deposits.txt");
        Scanner sc = new Scanner(fr);
        String LastDate = "";

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("Transfer type :واریز سود")) {
                if (sc.hasNextLine()) {
                    String destinationLine = sc.nextLine();
                    if (destinationLine.startsWith("destination number :" + AccountNumber)) {
                        // رد شدن از دو خط بعدی
                        if (sc.hasNextLine()) sc.nextLine(); // skip 1
                        if (sc.hasNextLine()) sc.nextLine(); // skip 2
                        if (sc.hasNextLine()) {
                            LastDate = extractValue(sc.nextLine());
                        }
                    }
                }
            }
        }

        return LastDate;
    }


    private final SecureRandom random = new SecureRandom();
    private String generateRandomNumber(int length) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            number.append(random.nextInt(10)); // عدد تصادفی بین 0 تا 9
        }
        return number.toString();
    }

    private void WriteFile(BigDecimal amount,String accountNumber,LocalDate today) throws IOException {
        String[] name = searchUserInfoByUserID(searchUserIDByAccountNumber(accountNumber));
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        Double inventory = searchUserinventoryByAccountNumber(accountNumber);
        BigDecimal bigDecimal = new BigDecimal(inventory);

        BigDecimal result = amount.subtract(bigDecimal);



        FileWriter fileWriter = new FileWriter("Deposits.txt", true);
        fileWriter.write("Amount transferred : " + result + "\n");
        fileWriter.write("Transfer type :واریز سود" + "\n");
        fileWriter.write("destination number :" + accountNumber + "\n");
        fileWriter.write("destination name : " + name[0] +" " +name[1] + "\n");
        fileWriter.write("tracking code : " + generateRandomNumber(9)+ "\n");
        fileWriter.write("Date :" + today +"\n" );
        fileWriter.write("Time : " + formattedTime + "\n");
        fileWriter.write("-------------" + "\n");
        fileWriter.close();
    }

}
