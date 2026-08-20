package BuilderPattern.Basic;

public class User {

    public String firstName;
    public String lastname;
    public int age;
    public String email;
    public String password;


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
