package au.com.telstra.simcardactivator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimCard {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String simNumber;
    @Column(nullable = false)
    private String customerEmail;
    private boolean active = false;

    public SimCard(String simNumber, String customerEmail) {
        this.simNumber = simNumber;
        this.customerEmail = customerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean getActive() {
        return active;
    }
    @Override
    public String toString() {
        return "SimCard{" +
            "id=" + id +
            ", simNumber='" + simNumber + '\'' +
            ", customerEmail='" + customerEmail + '\'' +
            ", active=" + active +
            '}';
    }

}


