
/*import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.*;*/

//import javafx.*;
import java.util.*;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class Main {

    public static List<User> accounts = new ArrayList<User>();

    public static void main(String[] args)
    {
        //create base accounts
        Main mainClass = new Main();

        mainClass.createBaseAccounts();

        //save accounts to file
        mainClass.saveData(accounts);
    }

    public List<User> getAccounts()
    {
        return accounts;
    }


    public void createBaseAccounts()
    {
        //Default Users

        //Staff 1
        Staff staffOne = new Staff(123);
        staffOne.setInfo("6029871234", "500 E University Dr", "asandler@gmail.com");
        staffOne.setUserName("asandler");
        staffOne.setDOB("08/11/1984");
        staffOne.setPassWord("happyfeet1234");
        staffOne.setName("Adam Sandler");
        staffOne.setType("Staff");

        //Patient 1
        Patient patientOne = new Patient();
        patientOne.setDOB("08/10/1999");
        patientOne.setName("John Smith");
        patientOne.setUserName("jsmith");
        patientOne.setType("Patient");
        patientOne.setPassWord("applesmith321");
        patientOne.setInsurance("Cigna");
        patientOne.setAnAllergy("Honey");
        patientOne.visitHistory.add(new Visit("08/10/2000",Arrays.asList("N/A"),Arrays.asList("N/A"),Arrays.asList("N/A")));
        patientOne.setBodyTemp(98);
        patientOne.setHeight(68);
        patientOne.setBloodPressure((int)(120/80));
        patientOne.setWeight(148);
        accounts.add(patientOne);

        staffOne.addAPatient(patientOne);

        //Patient 2
        Patient patientTwo = new Patient();
        patientTwo.setDOB("08/10/1987");
        patientTwo.setName("Sen Bimmons");
        patientTwo.setUserName("sbimmons");
        patientTwo.setType("Patient");
        patientTwo.setPassWord("threepoint3");
        patientTwo.setInsurance("Cigna");
        patientOne.setAnAllergy("Honey");
        patientOne.visitHistory.add(new Visit("08/10/2000",Arrays.asList("N/A"),Arrays.asList("N/A"),Arrays.asList("N/A")));
        patientTwo.setBodyTemp(98);
        patientTwo.setHeight(78);
        patientTwo.setBloodPressure((int)(124/80));
        patientTwo.setWeight(148);
        accounts.add(patientTwo);

        staffOne.addAPatient(patientTwo);
        accounts.add(staffOne);
    }


    public class LoadAccounts
    {
        File file = new File("data.txt");
    }

    //public class SaveAccounts
    //{
    public void saveData(List<User> l)
    {
        File file;
        PrintWriter out;
        FileWriter write;

        try {
            file = new File("data.txt");
            write = new FileWriter(file,false);
            out = new PrintWriter(file);

            if (!(file.exists()))
            {
                file.createNewFile();
            } else {
                out.flush();
                write.close();
            }
        } catch (Exception exc) {exc.printStackTrace(); return;}

        for(User each : l)
        {
            out.println(each.toString());
        }
        out.close();
    }

    //}

    public class User
    {
        //private variables
        private String userName;
        private String passWord;
        private String type;
        private String name;
        private Info basic;
        private Patient aPatient;
        private Staff aStaff;
        private String dob;
        //private messageInbox messageinbox;

        //Constructors
        public User(String fullname, String usersName, String password, String typ)
        {
            name = fullname;
            userName = usersName;
            passWord = password;
            type = typ;
            dob = " ";
        }
        public User()
        {
            name = " ";
            userName = " ";
            passWord = " ";
            type = " ";
            dob = " ";
        }
        void setName(String nam)
        {
            name = nam;
        }
        String getName()
        {
            return name;
        }
        void setUserName(String unam)
        {
            userName = unam;
        }
        String getUserName()
        {
            return userName;
        }
        void setPassWord(String passW)
        {
            passWord = passW;
        }
        String getPassWord()
        {
            return passWord;
        }
        void setType(String typ)
        {
            type = typ;
        }
        String getType()
        {
            return type;
        }
        void setInfo(String pN, String hA, String eMail)
        {
            basic = new Info(pN, hA, eMail);
        }
        Info getInfo()
        {
            return basic;
        }
        String getDOB()
        {
            return dob;
        }
        void setDOB(String dob)
        {
            this.dob = dob;
        }

        void setPatient(String aD, float w, float h, int bT, int bP, String p, String iP)
        {
            aPatient = new Patient(aD, w, h, bT, bP, p, iP);
        }
        Patient getPatient()
        {
            return aPatient;
        }
        void setStaffID(int id)
        {
            aStaff = new Staff(id);
        }
        int getStaffID()
        {
            return aStaff.getID();
        }
        public String toString()
        {
            return name + "\n" + userName + "\n" + passWord + "\n" + type + "\n" + basic.toString() + "\n" +  aPatient.toString() + "\n" + aStaff.toString() + "\n" + "--End--" ;
        }
    }

    public class Patient extends User
    {
        //private variables
        private String assignedDoctor;
        private float weight;
        private float height;
        private int bodyTemp;
        private int bloodPressure;
        private List<String> allergies;
        private List<Visit> visitHistory;
        private String pharmLoc;
        private String insuranceProv;

        //Constructors
        Patient(String aD, float w, float h, int bT, int bP, String p, String iP)
        {
            assignedDoctor = aD;
            weight = w;
            height = h;
            bodyTemp = bT;
            bloodPressure = bP;
            allergies = null;
            visitHistory = null;
            pharmLoc = p;
            insuranceProv = iP;
        }
        Patient()
        {
            assignedDoctor = " ";
            weight = 0;
            height = 0;
            bodyTemp = 0;
            bloodPressure = 0;
            allergies = new ArrayList<String>();
            visitHistory = new ArrayList<Visit>();
            pharmLoc = " ";
            insuranceProv = " ";
        }

        void setAssignedDocter(String aD)
        {
            assignedDoctor = aD;
        }
        String getAssignedDoctor()
        {
            return assignedDoctor;
        }
        void setWeight(float w)
        {
            weight = w;
        }
        float getWeight()
        {
            return weight;
        }
        void setHeight(float h)
        {
            height = h;
        }
        float getHeight()
        {
            return height;
        }
        void setBodyTemp(int bT)
        {
            bodyTemp = bT;
        }
        int getBodyTemp()
        {
            return bodyTemp;
        }
        void setBloodPressure(int bP)
        {
            bloodPressure = bP;
        }
        int getBloodPressure()
        {
            return bloodPressure;
        }
        void setAnAllergy(String a)
        {
            allergies.add(a);
        }
        List<String> getAllergies()
        {
            return allergies;
        }
        void setPharmLoc(String pL)
        {
            pharmLoc = pL;
        }
        String getPharmLoc()
        {
            return pharmLoc;
        }
        void setInsurance(String iP)
        {
            insuranceProv = iP;
        }
        String getInsurance()
        {
            return insuranceProv;
        }
        public String toString()
        {
            return assignedDoctor + "\n" + weight + "\n" + height + "\n" + bodyTemp + "\n" + bloodPressure + "\n" + allergies.toString() + "\n" + visitHistory.toString() + "\n" + pharmLoc + "\n" + insuranceProv + "\n";
        }
    }

    public class Staff extends User
    {
        private List<Patient> somePatients;
        private int id;

        Staff(int id)
        {
            this.somePatients = new ArrayList<Patient>();
            this.id = id;
        }

        int getID()
        {
            return id;
        }

        List<Patient> getPatients()
        {
            return somePatients;
        }

        void addAPatient(Patient p)
        {
            somePatients.add(p);
        }

        Patient findPatient(String firstName, String lastName, String dob)
        {
            // "MM//DD//YYYY"
            for (Patient each : somePatients)
            {
                if (each.getName().equalsIgnoreCase(firstName + " " + lastName))
                {
                    if (each.getDOB().equalsIgnoreCase(dob))
                    {
                        return each;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            return null;
        }
        public String toString()
        {
            return id  + "\n" + somePatients.toString() + "\n" ;
        }

    }

    public class Info extends User
    {
        private String phoneNumber;
        private String homeAddress;
        private String email;

        Info(String number, String homeAddress, String email)
        {
            this.phoneNumber = number;
            this.homeAddress = homeAddress;
            this.email = email;
        }

        String getPhoneNumber()
        {
            return phoneNumber;
        }

        String getHomeAddress()
        {
            return homeAddress;
        }

        String getEmail()
        {
            return email;
        }
        public String toString()
        {
            return phoneNumber + "\n" + homeAddress + "\n" + email + "\n";
        }
    }

    public class Message extends MessageInbox
    {
        private String text;
        private User sender;
        private User recepient;
        private String type;

        public Message(String text, User sender, User recepient, String type)
        {
            super(type);
            this.text = text;
            this.sender = sender;
            this.recepient = recepient;
        }

        String getText()
        {
            return text;
        }

        String getType()
        {
            return type;
        }

        User getSender()
        {
            return sender;
        }

        User getRecepient()
        {
            return recepient;
        }
    }

    public class MessageInbox extends User
    {
        private String type;
        private List<Message> messages;

        public MessageInbox(String type)
        {
            this.type = type;
            this.messages = new ArrayList<Message>();
        }

        String getType()
        {
            return type;
        }

        List<Message> getMessages()
        {
            return messages;
        }

        void addMessage(Message message)
        {
            messages.add(message);
        }


    }

    public class Visit extends Patient
    {
        private String date;
        private List<String> medicine;
        private List<String> orders;
        private List<String> notes;

        Visit(String date)
        {
            this.date = date;
            this.medicine = new ArrayList<String>();
            this.orders = new ArrayList<String>();
            this.notes = new ArrayList<String>();
        }

        Visit(String date, List<String> medicine, List<String> orders, List<String> notes)
        {
            this.date = date;
            this.medicine = medicine;
            this.orders = orders;
            this.notes = notes;
        }

        void setDate(String d)
        {
            date = d;
        }

        String getDate()
        {
            return date;
        }

        void addMedicine(String m)
        {
            medicine.add(m);
        }

        List<String> getMedicine()
        {
            return medicine;
        }

        void addOrder(String o)
        {
            orders.add(o);
        }

        List<String> getOrders()
        {
            return orders;
        }

        void addNote(String n)
        {
            notes.add(n);
        }

        List<String> getNotes()
        {
            return notes;
        }
    }
}
//end of code
