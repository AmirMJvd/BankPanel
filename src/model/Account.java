package model;
import java.time.LocalDate;

public class Account {
    private String userId;
    private String accountNumber;
    private String accountType;
    private String inventoryPrice;
    private String createDate;

//    public Account(String userId, String accountNumber, String accountType, String inventoryPrice, String createDate) {
//        this.userId = userId;
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//        this.inventoryPrice = inventoryPrice;
//        this.createDate = createDate;
//    }

    public String getUserId() {
        return userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getInventoryPrice() {
        return inventoryPrice;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setInventoryPrice(String inventoryPrice) {
        this.inventoryPrice = inventoryPrice;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}
