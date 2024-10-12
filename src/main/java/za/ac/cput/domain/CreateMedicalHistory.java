package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class CreateMedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queue_seq")
    @SequenceGenerator(name = "queue_seq", sequenceName = "history_ids", initialValue = 1, allocationSize = 1)
    private int historyId;
    private String patientIdMh;
    private String firstNameMh;
    private String lastNameMh;
    private String testResultsMh;
    private String allergiesMh;
    private String prescribedMedicationMh;
    private String treatmentPlanMh;
    private String dateCreateMh;

    public CreateMedicalHistory() {
    }

    public CreateMedicalHistory(int historyId, String patientIdMh, String firstNameMh, String lastNameMh, String testResultsMh, String allergiesMh, String prescribedMedicationMh, String treatmentPlanMh, String dateCreateMh) {
        this.historyId = historyId;
        this.patientIdMh = patientIdMh;
        this.firstNameMh = firstNameMh;
        this.lastNameMh = lastNameMh;
        this.testResultsMh = testResultsMh;
        this.allergiesMh = allergiesMh;
        this.prescribedMedicationMh = prescribedMedicationMh;
        this.treatmentPlanMh = treatmentPlanMh;
        this.dateCreateMh = dateCreateMh;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public void setPatientIdMh(String patientIdMh) {
        this.patientIdMh = patientIdMh;
    }

    public void setFirstNameMh(String firstNameMh) {
        this.firstNameMh = firstNameMh;
    }

    public void setLastNameMh(String lastNameMh) {
        this.lastNameMh = lastNameMh;
    }

    public void setTestResultsMh(String testResultsMh) {
        this.testResultsMh = testResultsMh;
    }

    public void setAllergiesMh(String allergiesMh) {
        this.allergiesMh = allergiesMh;
    }

    public void setPrescribedMedicationMh(String prescribedMedicationMh) {
        this.prescribedMedicationMh = prescribedMedicationMh;
    }

    public void setTreatmentPlanMh(String treatmentPlanMh) {
        this.treatmentPlanMh = treatmentPlanMh;
    }

    public void setDateCreateMh(String dateCreateMh) {
        this.dateCreateMh = dateCreateMh;
    }

    public int getHistoryId() {
        return historyId;
    }

    public String getPatientIdMh() {
        return patientIdMh;
    }

    public String getFirstNameMh() {
        return firstNameMh;
    }

    public String getLastNameMh() {
        return lastNameMh;
    }

    public String getTestResultsMh() {
        return testResultsMh;
    }

    public String getAllergiesMh() {
        return allergiesMh;
    }

    public String getPrescribedMedicationMh() {
        return prescribedMedicationMh;
    }

    public String getTreatmentPlanMh() {
        return treatmentPlanMh;
    }

    public String getDateCreateMh() {
        return dateCreateMh;
    }

    @Override
    public String toString() {
        return "CreateMedicalHistory{" +
                "historyId=" + historyId +
                ", patientIdMh='" + patientIdMh + '\'' +
                ", firstNameMh='" + firstNameMh + '\'' +
                ", lastNameMh='" + lastNameMh + '\'' +
                ", testResultsMh='" + testResultsMh + '\'' +
                ", allergiesMh='" + allergiesMh + '\'' +
                ", prescribedMedicationMh='" + prescribedMedicationMh + '\'' +
                ", treatmentPlanMh='" + treatmentPlanMh + '\'' +
                ", dateCreateMh='" + dateCreateMh + '\'' +
                '}';
    }
}




