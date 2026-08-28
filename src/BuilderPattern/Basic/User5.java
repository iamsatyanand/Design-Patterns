package BuilderPattern.Basic;


public class User5 {
    private String firstName;
    private String lastname;
    private int age;
    private String email;
    private String password;

    public User5(Builder builder) {

        this.firstName = builder.getFirstName();
        this.lastname = builder.getLastname();
        this.age = builder.getAge();
        this.email = builder.getEmail();
        this.password = builder.getPassword();

    }

    //  getters & Setters

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User5{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
