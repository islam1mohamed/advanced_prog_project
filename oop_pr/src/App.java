
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    static StoreManager manager;


    

    public static void main(String[] args) {
        try{
        Scanner scan = new Scanner(System.in); // For reading input from the console
        System.out.println("Do you want to\n [1]sign up         [2]login");
        int signState= scan.nextInt();
        scan.nextLine();
        if (signState ==1){

            System.out.println("please enter username:");
            String username = scan.nextLine();
            System.out.println("please enter password:");
            String password =  scan.nextLine();
            System.out.println("please enter email:");
            String email =  scan.nextLine();
            // SignUp sign = new SignUp();
            System.out.println("please enter name:");
            String name =  scan.nextLine();
            new SignUp(username, password , email  ,name);
            Login page = new Login();
            page.login(username,password);
        }
        else if (signState ==2){
        System.out.println("please enter username:");

        String username = scan.nextLine();
        System.out.println("please enter password:");
        String password =  scan.nextLine();
        System.out.println("username is "+ username );

        Login page = new Login();
        page.login(username,password);
        }
        else {System.out.println("wrong input");
            App.main(args);
        }
            boolean user_done = false;
            System.out.println("=============");
            System.out.println("logged in");
            System.out.println("=============");
        while (!user_done){
            int i = 1;

            // Now you have a list of Product objects, you can use it as needed
            for (Product product : manager.products) {

            System.out.print(i+ "- ");
            System.out.println(product.name +" ");
            System.out.println();
            i++;

            }


            // choose product
            System.out.println("choose item you want : [1-8]");
            int num = scan.nextInt();
            Product prd =  manager.products.get(num-1);
            System.out.println("How many do you want : ");
            int order_num = scan.nextInt();
            prd.amountInStock = prd.amountInStock - order_num;

            System.out.println("you order is");
            float prc = prd.price;
            System.out.println(prd.category +"\n"+prd.name +" \n" + prc);
            scan.nextLine();
            System.out.println("confirm order (Yes/No)");
            String confirm = scan.nextLine();
            // System.out.println(confirm);
            if (confirm.equalsIgnoreCase("Yes")) { 
            prd.amountInStock = prd.amountInStock-5;//user order;
            System.out.println(" your pruchase arrives in 2 days");
            user_done = true;
            }
            else if(confirm == "N"){

            user_done = false;

            }
        }
            // checkout + pil
            //confirm 
  
    

        
        }
        catch(Exception e ){
            System.out.println("please try again\n");
            System.err.println(e);
            App.main(args);
        }
        
        


    }

}
