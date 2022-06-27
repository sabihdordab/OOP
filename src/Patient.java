public class Patient extends Person
{
    private Doctor doctor ;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return " Patient information {" +
                " fullName='" + getFullName() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address ='" + getAddress() + '\'' +
                ", email ='" + getEmail() + '\'' +
                ", doctor ='" + doctor + '\'' +
                '}';
    }
}
