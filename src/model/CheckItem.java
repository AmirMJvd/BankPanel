package model;

public class CheckItem {
    private String name, trackingNumber, accountNumber, checkPages;
    private String nationall, phonenumb, postnumb, acctype;

    public CheckItem(String name, String trackingNumber, String accountNumber, String checkPages,
                     String nationall, String phonenumb, String postnumb, String acctype) {
        this.name = name;
        this.trackingNumber = trackingNumber;
        this.accountNumber = accountNumber;
        this.checkPages = checkPages;
        this.nationall = nationall;
        this.phonenumb = phonenumb;
        this.postnumb = postnumb;
        this.acctype = acctype;
    }

    public String getName() { return name; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getAccountNumber() { return accountNumber; }
    public String getCheckPages() { return checkPages; }
    public String getNational() { return nationall; }
    public String getPhoneNumber() { return phonenumb; }
    public String getPostCode() { return postnumb; }
    public String getAccountType() { return acctype; }

}
