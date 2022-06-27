import java.util.ArrayList;

enum Proficiency
{
    GENERAL,
    CARDIOLOGIST,
    NEUROLOGIST,
    PSYCHIATRIST,
}

public class Doctor extends Person
{
    private int capacity;
    private Proficiency proficiency;
    private ArrayList<Patient> patients = new ArrayList<>();

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }
    public void removePatient(Patient patient) {
        this.patients.remove(patient);
    }

    @Override
    public String toString() {
        return " Doctor information {" +
                " Doctor " + getFullName() +
                ", username = " + getUsername() +
                ", email =  " + getEmail() +
                ", capacity = " + capacity +
                ", proficiency = " + proficiency + '\'' +
                '}';
    }
}
