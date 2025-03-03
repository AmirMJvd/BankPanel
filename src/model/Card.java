package model;

public class Card {
    private String ShebaNum;
    private String DepositNum;
    private String CardNum;
    private String year;
    private String month;
    private String inventory;


    public String getShebaNum() {return ShebaNum;}

    public void setShebaNum(String ShebaNum) {
        this.ShebaNum = ShebaNum;
    }

    public String getDepositNum() {return DepositNum;}

    public void setDepositNum(String DepositNum) {this.DepositNum = DepositNum;}

    public String getCardNum() {return CardNum;}

    public void setCardNum(String CardNum) {this.CardNum = CardNum;}

    public String getyear() {return year;}

    public void setyear(String year) {this.year = year;}

    public String getMonth() {return month;}

    public void setMonth(String month) {this.month = month;}

    public String getInventory() {return inventory;}

    public void setInventory(String inventory) {this.inventory = inventory;}
}
