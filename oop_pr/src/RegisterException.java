public class RegisterException  extends  Exception{
    String message;
    public RegisterException(String message) {
        this.message = message;
        System.out.println(message);
    }
}
