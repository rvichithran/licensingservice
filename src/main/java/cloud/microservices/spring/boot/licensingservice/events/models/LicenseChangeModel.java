package cloud.microservices.spring.boot.licensingservice.events.models;

public class LicenseChangeModel {
    private String action;
    private String licenseId;

    public LicenseChangeModel(String action, String licenseId) {
        this.action = action;
        this.licenseId = licenseId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
}
