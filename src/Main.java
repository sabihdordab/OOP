
import  java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main
{
    static Scanner scan = new Scanner(System.in) ;
    static  ArrayList<Person> people = new ArrayList<>();
    static  ArrayList<Turn> turns = new ArrayList<>();
    static ArrayList<Prescription> prescriptions = new ArrayList<>();
    static String input ;
    public static void main(String[] args)
    {
        mainMenu();
    }

    public static void printStars()
    {
        for(int i = 0 ; i < 50 ; i++ )
            System.out.print("*");
        System.out.println();
    }

    public static void mainMenu()
    {

        System.out.println();
        printStars();
        System.out.printf("%s%29s%20s%n","*"," [1] Register","*");
        printStars();
        System.out.printf("%s%27s%22s%n","*"," [2] Login","*");
        printStars();
        System.out.printf("%s%27s%22s%n","*"," [3] Exit","*");
        printStars();
        while (true)   // loop for getting correct input
        {
            System.out.println(" Where should we go? enter number of that place : ");
            char input  = scan.next().charAt(0);
            if (input == '1')
            {
                register();
                break;
            }else if (input == '2')
            {
                login();
                break;
            }
            else if (input == '3')
            {
                System.out.println("  /\\_____/\\ ");
                System.out.println("  ( -   .  + )");
                System.out.println(" (-->| GOOD LUCK |<");
                System.out.println("  -----------");
                System.out.println("  //|_|  |_|//");

                System.exit(0 );
            }
            else
            {
                System.out.println(" Wrong input!");
            }
        }

    }

    public static void register()
    {
        printStars();
        System.out.println(" [1] Register as a doctor ");
        System.out.println(" [2] Register as a patient ");
        System.out.println(" [3] back");
        printStars();
        while (true)
        {
            System.out.println(" Enter the number : ");
            char input  = scan.next().charAt(0);
            if (input == '1')
            {
                registerAsDoctor();
                break;
            }else if (input == '2')
            {
                registerAsPatient();
                break;
            }else if (input == '3')
            {
                mainMenu();
                break;

            }else
            {
                System.out.println(" Wrong input!");
            }
        }
    }

    public static void registerAsDoctor()
    {
        printStars();

        Doctor doctor = new Doctor();

        initialize(doctor); // doctor is a person and patient is a person too , we initialize doctor as a person first that just for trying to have a clean code and principle : "dry" ...

        //doctor is a child of Person class and doctor class have more property , so we Continue

        System.out.printf("%n%s%n%s%n%s%n%s%n"," [1] GENERAL"," [2] CARDIOLOGIST"," [3] NEUROLOGIST"," [4] PSYCHIATRIST");
        System.out.println();
        while (true)
        {
            System.out.println(" Choose your proficiency :");
            char input = scan.next().charAt(0);
            if(input == '1')
            {
                doctor.setProficiency(Proficiency.GENERAL);
                break;
            }
            else if (input == '2')
            {
                doctor.setProficiency(Proficiency.CARDIOLOGIST);
                break;
            }
            else if (input == '3')
            {
                doctor.setProficiency(Proficiency.NEUROLOGIST);
                break;
            }
            else if (input == '4')
            {
                doctor.setProficiency(Proficiency.PSYCHIATRIST);
                break;
            }
            else
            {
                System.out.println(" wrong input!!");
            }

        }


        while (true)
        {
            System.out.println(" Enter your capacity : ");
            input = scan.next();
            if (Pattern.matches("^[0-9]+$",input))
            {
                doctor.setCapacity(Integer.parseInt(input));
                break;
            }
            else
            {
                System.out.println("Wrong input capacity is a number!");
            }
        }

        people.add(doctor);

        printStars();

        mainMenu();

    }
    public static void registerAsPatient()
    {
        printStars();

        Patient patient = new Patient();

        initialize(patient);

        people.add(patient);

        printStars();

        mainMenu();
    }
    public static void initialize(Person person)
    {
        System.out.println(" Enter your fullName : ");
        scan.nextLine();
        String fullName = scan.nextLine();
        person.setFullName(fullName);

        setUsername();
        person.setUsername(input);

        setPassword();
        person.setPassword(input);

        setEmail();
        person.setEmail(input);

        setPhoneNumber();
        person.setPhoneNumber(input);

        System.out.println(" Enter your Address : ");
        scan.nextLine();
        String address = scan.nextLine();
        person.setAddress(address);

    }

    public static void setUsername()
    {
        System.out.println(" Enter your username : ");
        input = scan.next();
        for(Person  person : people )
        {
            if( input.equals(person.getUsername()))
            {
                System.out.println(" This username is already registered");
                setUsername();
                return;
            }
        }
        if (Pattern.matches("^[a-zA-Z0-9]+$",input))
        {
            return;
        }
        System.out.println(" incorrect username");
        setUsername();
    }

    public static void setPassword()
    {
        System.out.println(" Enter your password");
        input = scan.next();
        if (Pattern.matches("^[0-9a-zA-Z]{8,1000}$",input))// its just better
        {
            System.out.println(" Done");
            return;
        }
        //else:
        System.out.println(" Password must be larger than 8 characters and contain only numbers or letters");
        setPassword();


    }

    public  static void setEmail()
    {
        System.out.println(" Enter your Email");
        input = scan.next();
        if (Pattern.matches("^[\\_ a-zA-z0-9 \\.]+[@][a-zA-Z0-9]+\\.[a-zA-Z]{3}$",input))
        {
            System.out.println(" Done");
            return;
        }
        //else:
        System.out.println(" Email is incorrect");
        setEmail();


    }

    public static void setPhoneNumber()
    {
        System.out.println(" Enter your phone number : ");
        input = scan.next();
        if(Pattern.matches("^09[0-9]{9}$", input ))
        {
            System.out.println(" Done");
        }
        else if(Pattern.matches("^\\+989[0-9]{9}$", input ))
        {
            System.out.println(" Done");
        }
        else if (Pattern.matches("^00989[0-9]{9}$", input ))
        {
            System.out.println(" Done");
        }
        else
        {
            System.out.println(" Phone number is incorrect");
            setPhoneNumber();
        }
    }

    public static void login()
    {
        boolean loginScale = false ;
        printStars();
        System.out.println(" enter your username : ");
        String username = scan.next();
        for (Person person : people)
        {
            if(username.equals(person.getUsername()))
            {
                System.out.println(" Enter your password: ");
                String password = scan.next();
                if (password.equals(person.getPassword()))
                {
                    loginScale = true;
                    System.out.println();
                    if(person instanceof Patient)
                    {
                      patientMenu( (Patient) person );
                    }
                    else
                    {
                        doctorMenu( (Doctor) person );
                    }
                    break;
                }
            }
        }
        if(!loginScale)
        {
            System.out.println("Your username does not exist or password is wrong!!");
            System.out.println(" If you did not register , enter y else N : ");
            char input = scan.next().charAt(0);
            if (input == 'y')
            {
                register();
                return;
            }
            printStars();
            login();
        }
    }


    public static  void doctorMenu(Doctor doctor)
    {
        printStars();
        System.out.println();
        System.out.println(doctor);
        System.out.println();
        printStars();

        System.out.println();
        patientsList(doctor);
        System.out.println();

        printStars();
        System.out.println(" [1] Write a Prescription");
        System.out.println(" [2] back to main menu ");
        while (true)
        {
            System.out.println(" Enter number :");
            char choice = scan.next().charAt(0);
            if (choice == '1')
            {
                while (true)
                {
                    System.out.println(" OK ,Prescription for who? ");
                    patientsList(doctor);
                    System.out.println();

                    System.out.println(" Enter number :");
                    input = scan.next();

                    if(Pattern.matches("^[0-9]+$",input))// correct input , must be number
                    {
                        if(Integer.parseInt(input) < doctor.getPatients().size())// if this condition be false ,where is patient with that number ? we can't see that patient here , mean in list
                        {
                            writePrescription(doctor,doctor.getPatients().get(Integer.parseInt(input)));

                            for (int i = 0; i < turns.size() ; i++ ) // delete turn from turns list
                            {
                                if (turns.get(i).getPatient() == doctor.getPatients().get(Integer.parseInt(input)))
                                {
                                    turns.remove(i);
                                    break;
                                }
                            }
                            doctor.getPatients().get(Integer.parseInt(input)).setDoctor(null); // this doctor is not her/him doctor now
                            doctor.removePatient(doctor.getPatients().get(Integer.parseInt(input)));
                            System.out.println(" Done");

                            System.out.println(" Do you want to continue or back to menu ? back = b :");
                            input = scan.nextLine();
                            if (input.equals("b"))
                            {
                                doctorMenu(doctor);
                                break;
                            }
                        }
                        else
                        {
                            System.out.println(" you don't have a patient with this number right now so we back!!");
                            break;
                        }
                    }
                    else
                    {
                        System.out.println(" attention!!");
                    }

                }
                doctorMenu(doctor);
                break; // break big loop
            }
            if (choice == '2')
            {
                mainMenu();
                break;
            }

            System.out.println(" wrong!!");
        }
    }

    public static void patientMenu(Patient patient)
    {
        System.out.println();
        printStars();
        System.out.println();
        System.out.println(patient);
        System.out.println();
        printStars();
        System.out.println();

        System.out.println(" [1] Doctors List");
        System.out.println(" [2] Set Turn");
        System.out.println(" [3] Cancel Turn");
        System.out.println(" [4] Prescription");
        System.out.println(" [5] Back");

        System.out.println(" Where should we go? enter number of that place : ");
        char choice  = scan.next().charAt(0);
        if (choice == '1')
        {
            printDoctorsList();
            System.out.println(" for getting turn ,remember doctors codes ,so Enter something and back to your menu");
            scan.nextLine();
            input = scan.nextLine();
            patientMenu(patient);

        }else if (choice == '2')
        {
           setAndGetTurn(patient);
        }
        else if (choice == '3')
        {
            cancelTurn(patient);
        }
        else if(choice == '4')
        {
            printPrescriptions(patient);
            System.out.println(" enter something for back to menu :");
            input = scan.next();
            patientMenu(patient);
        }
        else if (choice == '5')
        {
            mainMenu();
        }else
        {
            System.out.println(" Wrong input , pay attention to menu !");
            patientMenu(patient);
        }
    }

    public  static void setAndGetTurn(Patient patient)
    {
        while (true)
        {
            if (patient.getDoctor() != null) //mean patient have turned with a doctor
            {
                System.out.println(" you have a turn so we back");
                patientMenu(patient);
                return;
            }
            System.out.println(" Choose the doctor you want with doctor code | back to menu = back: ");
            input = scan.next();
            if (Pattern.matches("^[0-9]+$",input)) // code is a number here ...
            {
                if(people.size() > Integer.parseInt(input)) // how we get something from list if that index can't be there right now?
                {
                    if (people.get(Integer.parseInt(input)) instanceof Doctor ) //how we get a turn with somebody and somebody is not a doctor?
                    {
                        Doctor doctor = (Doctor) people.get(Integer.parseInt(input));
                        if (doctor.getCapacity() - 1 >= 0)
                        {
                            doctor.setCapacity(doctor.getCapacity() - 1 );
                            patient.setDoctor(doctor);
                            doctor.addPatient(patient);
                            Turn turn = new Turn();
                            turn.setDoctor(doctor);
                            turn.setPatient(patient);
                            LocalDateTime Date = LocalDateTime.now();
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            turn.setDate(Date.format(dateTimeFormatter)) ;
                            turns.add(turn);
                            System.out.println(turn);
                            System.out.println("Your turn has been registered");
                            System.out.println(" Enter something and back to menu : ");
                            scan.nextLine();
                            input = scan.nextLine();
                            patientMenu(patient);
                            break;
                        }
                        else{
                            System.out.println("full capacity");
                        }
                    }
                }
            }else if(input.equals("back"))
            {
                patientMenu(patient);
                break;
            }
            System.out.println(" So Wrong !!");
        }
    }

    static void cancelTurn(Patient patient)
    {
        printStars();
        System.out.println();
        System.out.println(" TURN:");
        printTurn(patient);
        System.out.println();
        printStars();

        if(patient.getDoctor() != null)
        {
            System.out.println(" Delete Turn? y | N ");
            char input = scan.next().charAt(0);
            if (input == 'y')
            {
                patient.getDoctor().removePatient(patient);
                patient.getDoctor().setCapacity(patient.getDoctor().getCapacity() + 1) ;
                for (int i = 0; i < turns.size() ; i++ )//remove turn from turns list
                {
                    if (turns.get(i).getPatient() == patient)
                    {
                        turns.remove(i);
                        break;
                    }
                }
                patient.setDoctor(null) ; // patient's doctor = nobody right now
                System.out.println("done");
            }

        }
        else
        {
            System.out.println("you don't have a turn so enter something and we back to menu");
            input = scan.next();
        }
        patientMenu(patient);
    }

    public  static  void writePrescription(Doctor doctor , Patient patient)
    {
        Prescription prescription = new Prescription() ;
        prescription.setDoctor(doctor) ;
        prescription.setPatient(patient) ;
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        prescription.setDate(Date.format(dateTimeFormatter));
        System.out.println(" Enter medicines :");
        scan.nextLine();
        prescription.setMedicines(scan.nextLine()) ;
        prescription.setWhoWroteThePrescription(" Doctor "+ doctor.getFullName() + " proficiency : " + doctor.getProficiency() );
        prescriptions.add(prescription);
        System.out.println(prescription);
    }

    public static void printDoctorsList()
    {
        System.out.println(" Doctors List :");
        printStars();
        for (int i = 0 ; i < people.size() ; i++)
        {
            if (people.get(i) instanceof Doctor)
            {
                System.out.printf("%n%s%d%s%s%s%s%s%d%n"," [ ", i , " ]  Doctor " , people.get(i).getFullName() , " , proficiency : " , ((Doctor) people.get(i)).getProficiency() , ", capacity : " , ((Doctor) people.get(i)).getCapacity());
            }
        }
        printStars();
    }
    public  static void patientsList(Doctor doctor)
    {
        System.out.println(" Patients List :");
        for (int i = 0 ; i < doctor.getPatients().size() ; i++)
        {
            System.out.print(" [" + i + "] ");
            System.out.println(doctor.getPatients().get(i));
        }
    }
    public static void printTurn(Patient patient)
    {
        for (Turn turn : turns)
        {
            if (turn.getPatient() == patient)
            {
                System.out.println(turn);
                break;
            }
        }
    }
    public  static  void printPrescriptions(Patient patient)
    {
        System.out.println(" prescriptions : ");
        for (Prescription prescription : prescriptions)
        {
            if (prescription.getPatient() == patient)
            {
                System.out.println(prescription);
                System.out.println();
            }
        }
    }
}