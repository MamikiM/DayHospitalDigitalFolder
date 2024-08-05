package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class PharmacyQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queue_seq")
    @SequenceGenerator(name = "queue_seq", sequenceName = "queue_sequence", initialValue = 1, allocationSize = 1)
    private int queueNumber;
    private String patientId;
    private String firstName;
    private String lastName;
    private String prescribedMedication;
    private String treatmentPlan;

    public PharmacyQueue() {
    }

    public PharmacyQueue(String patientId, int queueNumber, String firstName, String lastName, String prescribedMedication, String treatmentPlan) {
        this.patientId = patientId;
        this.queueNumber = queueNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.prescribedMedication = prescribedMedication;
        this.treatmentPlan = treatmentPlan;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPrescribedMedication(String prescribedMedication) {
        this.prescribedMedication = prescribedMedication;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getPatientId() {
        return patientId;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPrescribedMedication() {
        return prescribedMedication;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    @Override
    public String toString() {
        return "PharmacyQueue{" +
                "patientId='" + patientId + '\'' +
                ", queueNumber=" + queueNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", prescribedMedication='" + prescribedMedication + '\'' +
                ", treatmentPlan='" + treatmentPlan + '\'' +
                '}';
    }
}
