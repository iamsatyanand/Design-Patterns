package BuilderPattern.Basic;

import java.util.HashMap;

public class User4 {
    private String firstName;
    private String lastname;
    private int age;
    private String email;
    private String password;

    public User4(HashMap<String, Object> userData) {

        this.firstName = (String) userData.get("firstName");
        this.lastname = (String)userData.get("lastname");
        this.age = (int) userData.get("age");
        this.email = (String) userData.get("email");
        this.password = (String) userData.get("password");

        if(firstName == null || firstName.isEmpty()){
            throw new RuntimeException("Invalid first name");
        }

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
        return "User4{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
