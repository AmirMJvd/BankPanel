package model;

public class vam {
    private String vamtype ;
    private String AccountNumber;

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    private String ID ;
    private String name ;
    private String nationalcode ;

    public String getVamtype() {
        return vamtype;
    }

    public void setVamtype(String vamtype) {
        this.vamtype = vamtype;
    }

    public String getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
