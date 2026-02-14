package SOLIDPrinciples.SingleResponsibilityPrinciple.Question1;

public class EmailService {

    public void sendEmail(User user, String subject, String message){
        //email sending logic
        System.out.println("sending email to :"+ user.getName());
    }
}
