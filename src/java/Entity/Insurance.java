
package Entity;

public class Insurance extends BaseEntity {
    private String provider;
    private String coverageDetails;

    public Insurance() {
    
    }

    public Insurance(String provider, String coverageDetails, int id, String name) {
        super(id, name);
        this.provider = provider;
        this.coverageDetails = coverageDetails;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    @Override
    public String toString() {
        return "Insurance{" + "provider=" + provider + ", coverageDetails=" + coverageDetails + '}';
    }
    
    
}
