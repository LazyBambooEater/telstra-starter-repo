package stepDefinitions;

public class TestJson {
    private String iccid;
    private String customerEmail;


    public TestJson(String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    } 

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}