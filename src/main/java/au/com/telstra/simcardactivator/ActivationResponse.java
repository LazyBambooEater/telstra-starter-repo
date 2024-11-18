package au.com.telstra.simcardactivator;

public class ActivationResponse {
    private boolean success;

    public boolean isActivated() {
        return success;
    }

    public void setActivated(boolean success) {
        this.success = success;
    }
}
