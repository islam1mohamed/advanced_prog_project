
import java.util.regex.Pattern;

public class SignUp {


    public String username;

    public String password;
  
    public String email;

    public String name;
    SignUp(String username , String password ,String email , String name){
        
        if(!username.trim().isEmpty() && !password.trim().isEmpty() && !email.trim().isEmpty() && !name.trim().isEmpty()){
            try {
                
                User.signUp(username , password,email , name);
                

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }




    public static boolean patternMatches(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

}
