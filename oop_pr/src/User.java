
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;


public abstract class User {
    String username;
    String password;
    String id;
    String name;
    String email;

    public User(String username, String password, String id, String name, String email) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    static User login(String username , String password) throws Exception{

            File adminsFile = new File("admins.txt");
            if(adminsFile.exists()) {
                Scanner adminsReader = new Scanner(adminsFile);
                while (adminsReader.hasNextLine()) {
                    String data = adminsReader.nextLine();
                    String[] dataFields = data.split(",");
                    if (dataFields[0].equals(username)) {
                        if (dataFields[1].equals(password)) {
                            Admin admin = new Admin(dataFields[0], dataFields[1], dataFields[2], dataFields[3], dataFields[4]);
                            App.manager = new StoreManager(admin);
                            return admin;
                        }
                        throw new RegisterException("Wrong Password");
                    }
                }
                adminsReader.close();

            }
        File customersFile = new File("customers.txt");
            if(customersFile.exists()) {
                Scanner customersReader = new Scanner(customersFile);
                while (customersReader.hasNextLine()) {
                    String data = customersReader.nextLine();
                    String[] dataFields = data.split(",");
                    if (dataFields[0].equals(username)) {
                        if (dataFields[1].equals(password)) {
                            Customer customer = new Customer(dataFields[0], dataFields[1], dataFields[2], dataFields[3], dataFields[4]);
                            App.manager = new StoreManager(customer);
                            return customer;
                        }
                        throw new RegisterException("Wrong Password");
                    }
                }
                customersReader.close();
            }
        throw  new RegisterException("Couldn't Find User");
    }


    static void signUp( String username , String password , String email , String name)throws Exception {
        String fileName;

            fileName = "customers.txt";
 
        File file = new File(fileName);
        if (!file.createNewFile()) {
            // System.out.println("File Already CreatedS");
        }
        FileWriter fileWriter = new FileWriter(fileName , true);
        String uniqueID = UUID.randomUUID().toString();
        fileWriter.write(username + "," + password + ","+uniqueID + "," + email + "," + name + "\n");
        fileWriter.close();



    }

}
