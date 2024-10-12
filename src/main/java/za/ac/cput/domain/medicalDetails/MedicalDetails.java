package za.ac.cput.domain.medicalDetails;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class MedicalDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String testResults;
    private String allergies;
    private String prescribedMedication;
    private String treatmentPlan;

    public MedicalDetails() {
    }

    public MedicalDetails(long id, String testResults, String allergies, String prescribedMedication, String treatmentPlan) {
        this.id = id;
        this.testResults = testResults;
        this.allergies = allergies;
        this.prescribedMedication = prescribedMedication;
        this.treatmentPlan = treatmentPlan;
    }

    public long getId() {
        return id;
    }

    public String getTestResults() {
        return testResults;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getPrescribedMedication() {
        return prescribedMedication;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }
}
