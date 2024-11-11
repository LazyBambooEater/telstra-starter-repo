package au.com.telstra.simcardactivator;

public class SimCard {
    
    private String simNumber;
    private String customerEmail;

    public SimCard(String simNumber, String customerEmail) {
        this.simNumber = simNumber;
        this.customerEmail = customerEmail;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }
}


