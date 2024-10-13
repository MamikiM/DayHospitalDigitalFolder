package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Patient {
    @Id
    private String patientId;
    private String firstName;
    private String lastName;
    private String testResults;
    private String allergies;
    private String prescribedMedication;
    private String treatmentPlan;

    public Patient() {
    }

    public Patient(String patientId, String firstName, String lastName, String testResults, String allergies, String prescribedMedication, String treatmentPlan) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.testResults = testResults;
        this.allergies = allergies;
        this.prescribedMedication = prescribedMedication;
        this.treatmentPlan = treatmentPlan;
    }

    public String getPatientId() {
        return patientId;
    }

    public Patient setPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }



    public String getFirstName() {
        return firstName;
    }

    public Patient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Patient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTestResults() {
        return testResults;
    }

    public Patient setTestResults(String testResults) {
        this.testResults = testResults;
        return this;
    }

    public String getAllergies() {
        return allergies;
    }

    public Patient setAllergies(String allergies) {
        this.allergies = allergies;
        return this;
    }

    public String getPrescribedMedication() {
        return prescribedMedication;
    }

    public Patient setPrescribedMedication(String prescribedMedication) {
        this.prescribedMedication = prescribedMedication;
        return this;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public Patient setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        return this;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", testResults=" + testResults + ", allergies=" + allergies + ", prescribedMedication="
                + prescribedMedication + ", treatmentPlan=" + treatmentPlan + "]";
    }

    


}