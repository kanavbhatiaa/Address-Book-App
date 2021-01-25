/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookApp;

/**
 *
 * @author Birbal
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

public class ContactManager {

    private int numberOfContacts, maxContacts;
    private Contact[] contactList;

    public ContactManager(int maxContacts) {
        numberOfContacts = 0;
        contactList = new Contact[maxContacts];
    }

    public Contact findContact(String firstName, String lastName, TableView tableView) {
        try {
            File file = new File("User.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    String[] vec = line.split(",");
                    if (vec[0].contentEquals(firstName) && vec[1].contains(lastName)) {
                        tableView.getItems().add(new Contact(vec[0], vec[1], vec[2], vec[3], new Address(vec[4], vec[5], vec[6], vec[7], vec[8], vec[9]), vec[10], vec[11], new MyDate(Integer.parseInt(vec[12]), Integer.parseInt(vec[13]), Integer.parseInt(vec[14]))));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public String viewAllContacts() {
        String s = "";
        for (int i = 0; i < numberOfContacts; i++) {
            s += contactList[i].toString() + "\n";
        }
        return s;
    }

    public Contact[] allContacts() {
        Contact[] response = new Contact[numberOfContacts];
        for (int i = 0; i < numberOfContacts; i++) {
            response[i] = contactList[i];
        }
        return response;
    }

    public String viewContactsInCity(String city, TableView tableView) {
        String s = "";
        try {
            File file = new File("User.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    String[] vec = line.split(",");
                    if (vec[6].contains(city)) {
                        tableView.getItems().add(new Contact(vec[0], vec[1], vec[2], vec[3], new Address(vec[4], vec[5], vec[6], vec[7], vec[8], vec[9]), vec[10], vec[11], new MyDate(Integer.parseInt(vec[12]), Integer.parseInt(vec[12]), Integer.parseInt(vec[12]))));
                    }
                }
            }
        } catch (Exception e) {

        }
        return s;
    }

    public void addData(String firstName, String lastName, String homeNo, String workNo, String streetinfo1, String streetinfo2, String city, String postalCode, String province, String country, String email, String notes, int day, int month, int year) {
        try {
            FileWriter myWriter = new FileWriter("User.txt", true);
            myWriter.write(firstName + "," + lastName + "," + homeNo + "," + workNo + "," + streetinfo1 + "," + streetinfo2 + "," + city + "," + postalCode + "," + province + "," + country + "," + email + "," + notes + "," + day + "," + month + "," + year + "\n");
            myWriter.close();
            JOptionPane.showMessageDialog(null, "User Created Successfully");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String add(String firstName, String lastName, String homePhone, String workPhone, Address homeAddress, String email, String notes, MyDate birthday) {
        String s = "";
//        if (findContact(firstName, lastName) != null) {
//            s = "Contact with same number is already been added!";
//            return s;
//        }
        contactList[numberOfContacts] = new Contact(firstName, lastName, homePhone, workPhone, homeAddress, email, notes, birthday);
        numberOfContacts++;
        s = "Contact " + firstName + " " + lastName + " with home phone " + homePhone + " is successfully been added!";
        return s;
    }

    public void deleteData(String fName) {
        try {
            RandomAccessFile file = new RandomAccessFile("User.txt", "rw");
            String delete;
            String task = "";
            byte[] tasking;
            while ((delete = file.readLine()) != null) {
                if (delete.contains(fName)) {
                    continue;
                }
                task += delete + "\n";
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt"));
            writer.write(task);
            file.close();
            writer.close();
            JOptionPane.showMessageDialog(null, "User Delete Successfully");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

//    public String edit(String firstName, String lastName) {
//        String s = "";
//        Scanner scanner = new Scanner(System.in);
////        if (findContact(firstName, lastName) == null) {
////            s = "Contact " + firstName + " " + lastName + " is not exist";
////            return s;
////        }
//        System.out.println("What would you like to edit?");
//        System.out.println("1 - Edit First Name");
//        System.out.println("2 - Edit Last Name");
//        System.out.println("3 - Edit Home Phone");
//        System.out.println("4 - Edit Work Phone");
//        System.out.println("5 - Edit Home Address");
//        System.out.println("6 - Edit Email");
//        System.out.println("7 - Edit Notes");
//        System.out.println("8 - Edit Birthday");
//        System.out.println("9- To Exit");
//        int input = scanner.nextInt();
//        switch (input) {
//            case 1:
//                System.out.println(findContact(firstName, lastName).getFirstName() + " is the current name");
//                try {
//                    System.out.println("Enter the new name");
//                    String inputName = scanner.next();
//                    if (inputName == findContact(firstName, lastName).getFirstName()) {
//                        System.out.println("New name cannot be same");
//                    }
//                    findContact(firstName, lastName).setFirstName(inputName);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 2:
//                System.out.println(findContact(firstName, lastName).getLastName() + " is the current last name");
//                try {
//                    System.out.println("Enter the new last name");
//                    String inputLastName = scanner.next();
//                    if (inputLastName == findContact(firstName, lastName).getLastName()) {
//                        System.out.println("New last name cannot be same");
//                    }
//                    findContact(firstName, lastName).setLastName(inputLastName);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 3:
//                System.out.println(findContact(firstName, lastName).getHomePhone() + " is the current Home Phone");
//                try {
//                    System.out.println("Enter the new home phone");
//                    String inputHomePhone = scanner.next();
//                    if (inputHomePhone == findContact(firstName, lastName).getHomePhone()) {
//                        System.out.println("New home phone cannot be same");
//                    }
//                    findContact(firstName, lastName).setHomePhone(inputHomePhone);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 4:
//                System.out.println(findContact(firstName, lastName).getWorkPhone() + " is the current work phone");
//                try {
//                    System.out.println("Enter the new work phone");
//                    String inputWorkPhone = scanner.next();
//                    if (inputWorkPhone == findContact(firstName, lastName).getWorkPhone()) {
//                        System.out.println("New work phone cannot be same");
//                    }
//                    findContact(firstName, lastName).setWorkPhone(inputWorkPhone);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 5:
//                System.out.println(findContact(firstName, lastName).getHomeAddress() + " is the current home address");
//                try {
//                    System.out.println("Enter the new home address");
//                    System.out.println("Street address 1:");
//                    String inputStreetAddress1 = scanner.next();
//                    System.out.println("Street address 2:");
//                    String inputStreetAddress2 = scanner.next();
//                    System.out.println("Province:");
//                    String inputProvince = scanner.next();
//                    System.out.println("City:");
//                    String inputCity = scanner.next();
//                    System.out.println("Postal Code:");
//                    String inputPostalCode = scanner.next();
//                    System.out.println("Country:");
//                    String inputCountry = scanner.next();
//                    String fullAddress = inputStreetAddress1 + " " + inputStreetAddress2 + " " + inputProvince + " " + inputCity + " " + inputPostalCode + " " + inputCountry;
//
//                    if (fullAddress == findContact(firstName, lastName).getHomeAddress()) {
//                        System.out.println("New home address cannot be same as previous address!");
//                    }
//                    findContact(firstName, lastName).setHomeAddress(inputStreetAddress1, inputStreetAddress2, inputProvince, inputCity, inputPostalCode, inputCountry);
//                    System.out.println("Address successfully updated!");
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 6:
//                System.out.println(findContact(firstName, lastName).getEmail() + " is the current Email address");
//                try {
//                    System.out.println("Enter the new email address");
//                    String inputEmailAddress = scanner.next();
//                    if (inputEmailAddress == findContact(firstName, lastName).getEmail()) {
//                        System.out.println("New Email address cannot be same");
//                    }
//                    findContact(firstName, lastName).setEmail(inputEmailAddress);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 7:
//                System.out.println(findContact(firstName, lastName).getNotes() + " is the current note");
//                try {
//                    System.out.println("Enter the new note");
//                    String inputNote = scanner.next();
//                    if (inputNote == findContact(firstName, lastName).getNotes()) {
//                        System.out.println("New note cannot be same");
//                    }
//                    findContact(firstName, lastName).setNotes(inputNote);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 8:
//                System.out.println(findContact(firstName, lastName).getBirthday() + " " + findContact(firstName, lastName).getBirthMonthLongForm() + " " + findContact(firstName, lastName).getBirthYear() + " is the current birthday");
//                try {
//                    System.out.println("Enter the new birthday");
//                    int inputBirthday = scanner.nextInt();
//                    System.out.println("Enter the new birth month");
//                    int inputBirthMonth = scanner.nextInt();
//                    System.out.println("Enter the new birth year");
//                    int inputBirthYear = scanner.nextInt();
//
//                    if (inputBirthday == findContact(firstName, lastName).getBirthDay() && inputBirthMonth == findContact(firstName, lastName).getBirthMonth() && inputBirthYear == findContact(firstName, lastName).getBirthYear()) {
//                        System.out.println("New Birthday cannot be same as your last birthday");
//                    }
//                    findContact(firstName, lastName).setBirthday(inputBirthday);
//                    findContact(firstName, lastName).setBirthMonth(inputBirthMonth);
//                    findContact(firstName, lastName).setBirthYear(inputBirthYear);
//                    System.out.println("Your birthday updated as " + inputBirthday + " " + findContact(firstName, lastName).getBirthMonthShortForm() + " " + inputBirthYear);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                break;
//            case 9:
//                System.out.println("Exiting...");
//                break;
//        }
//        s = "Please enter a number from 1 to 9!";
//        return s;
//    }
    public String delete(String firstName, String lastName) {
        String s = "";
//        if (findContact(firstName, lastName) == null) {
//            s = "Contact is not exist!";
//            return s;
//        }
        for (int i = 0; i < numberOfContacts; i++) {
            if (contactList[i].getFirstName() == firstName && contactList[i].getLastName() == lastName) {
                s = "Contact " + contactList[i].getFirstName() + " with number " + contactList[i].getHomePhone() + " has been removed";
                contactList[i] = null;
                numberOfContacts--;
                return s;
            }
        }
        s = "Something went wrong";
        return s;
    }
}
