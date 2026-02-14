package SOLIDPrinciples.SingleResponsibilityPrinciple.Question1;

public class UserReportGenerator {

    public String GenerateFeport(User user){
        // report generation logic
        return "Report generated successfully for" + user.getName();
    }
}
