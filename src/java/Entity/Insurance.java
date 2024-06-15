
package Entity;

public class Insurance extends BaseEntity {
    private String provider;
    private String coverageDetails;
    private Patient patient;

    public Insurance() {
    
    }

    public Insurance(String provider, String coverageDetails, Patient patient, int id, String name) {
        super(id, name);
        this.provider = provider;
        this.coverageDetails = coverageDetails;
        this.patient = patient;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    

    @Override
    public String toString() {
        return "Insurance{" + "provider=" + provider + ", coverageDetails=" + coverageDetails + '}';
    }
    
    
}
