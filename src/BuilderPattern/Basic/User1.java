package BuilderPattern.Basic;

public class User1 {
    private String firstName;
    private String lastname;
    private int age;
    private String email;
    private String password;


    @Override
    public String toString() {
        return "User1{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
