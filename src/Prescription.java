
public class Prescription
{
    private Doctor doctor ;
    private Patient patient ;
    private String medicines ;
    private String date;
    private String WhoWroteThePrescription ;

    public Doctor getDoctor() {
        return doctor;
    }

    public String getMedicines() {
        return medicines;
    }

    public String getDate() {
        return date;
    }

    public String getWhoWroteThePrescription() {
        return WhoWroteThePrescription;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWhoWroteThePrescription(String whoWroteThePrescription) {
        WhoWroteThePrescription = whoWroteThePrescription;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                " " + patient +
                ", medicines='" + medicines + '\'' +
                ", date=" + date +
                ", Wrote by =" + WhoWroteThePrescription +
                '}';
    }
}
