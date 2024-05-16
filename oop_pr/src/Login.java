
import java.io.FileNotFoundException;
import java.util.UUID;

public class Login {


    void login(String username , String password) throws Exception{
        if(!username.trim().isEmpty() && !password.trim().isEmpty() ){

            try{
                User.login(username, password);
                // code for what to do after login
                
                System.out.println("you are one of us");
            }
            catch (RegisterException e){
                    // exeption will also print
                    // he needed this to update message
                throw new Exception("can't login");
                // System.out.println("eleminate intruder");
            }
            catch (FileNotFoundException e){
                System.out.println("Couldn't find file");
            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("Unexpected error");
            }
        }
    }

    public void onRegisterClick() { // sign in

        try {

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Couldn't Load Second Screen");
        }
    }
}
