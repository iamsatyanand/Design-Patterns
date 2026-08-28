package BuilderPattern.Basic;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // all fields public
        User user = new User();
        user.firstName = ""; // ---------> can be changed from outside class.

        System.out.println(user);


        // all fields private
        User1 user1 = new User1();
        // user1.FirstName(""); - not possible
        System.out.println(user1);

        // all fields are private plus we have getters and setters too where setter handles validation
        User2 user2 = new User2();
        user2.setFirstName("Satya");
        // object is already created above via default constrctore
        // where all the fields/properties got some default value
        // till we call setter, the user object created is invalid object which has empty firstname
        // the moment i created the user till the time i call setter
        // my user is an invalid object
        // what if the object is an immutable object that means after creation of object we cant mutate it or update it
        // then also setter validations will not work for us. we have to validate when the object has been created.
        System.out.println(user2);


        // all fields are private plus we have getters and setters , also we have custom constructor which handles validation
        User3 user3 = new User3("satya", "mishra", 20, "satya@gmail.com", "password");
        // problems here
            // 1) so many attributes passed to constructor, there fore we need to remember the sequence of parameters
            // 2) adding new parameters becomes headache so client code will be less readable and code will be bloated and unmanageable
            // 3) if we have another non mandatory field where we have to keep validation if added then we have to add that field also in constructor and
                    // we have to pass null for those params which are not required always during object creation
                        // one solution for this is create multiple constructors(constructor overloading) but the problem is
                        // if there are huge amount of parameters then there will be a lot of combinations of constructors
                        // for n params 2^n possible combination which will be extremely unmanageable.
                        // also suppose firstname, lastname, email all of string type and firstname, lastname, password are also of string type then for this we can create on;y one parameters
            // 4) what if we add validation in setter but then we also have the invalid object during the object creation time till setter gets called
        System.out.println(user3);


        HashMap<String, Object> userData = new HashMap<>();
        userData.put("firstName", "Satya");
        userData.put("lastname", "Mishra");
        userData.put("age", 20);
        userData.put("email", "satya@gmail.com");
        userData.put("password", "password");

        // here the problem is
        // HashMap<String, Object> approach sacrifices type safety
        // example: userData.put("age", "twenty"); ----> will fail at runtime with a ClassCastException.
        // we can also accidentally make a typo: userData.put("fristName", "Satya"); ----> userData.get("firstName") returns null
        // There is also no compile-time guarantee that the required fields exist.
//        HashMap<String, Object> userData = new HashMap<>();
//        userData.put("firstName", "Satya");
//        User4 user4 = new User4(userData);
//        The constructor has to figure out that lastname, age, email, etc. are missing.

        User4 user4 = new User4(userData);
        System.out.println(user4);


        // what if somehow someone creates this key-value pair based object for us,
        // we can leverage it and make a very clean class
        // lets define a separate class which gives us a mapper object (lets call it a builder object)
        // as his object is actually helping us to build another object
        // this Builder class will contain all the properties of our main User class
        // it will create a temporary object before we create our final User
        // as we need to pass a builder object to our User constructor, so we need to have a builder object
        // before we call a User constructor i.e. we need to create a builder object before we create a User object
        // there is no problem in it Builder is like a helper class no impact of this in User object
        // but keep in mind builder object should be clean i.e. there should not be bloated constructor of builder class
        // this builder is not going to use a bloated constructor for object creation
        // Instead we are going to use setter based validations in Builder class
        // but we had seen already the problem with setter based validation i.e. bloated constructor, invalid object creation before actual object, also immutable object problem
        // but here those problems of invalid object and immutability is gone here as its it not our user object
        // builder need not be immutable as it is temporary object that is going to stay for sometime only
        // benefit - since builder setter have validations so user constructor doesn't need to have any validations
        // user constructor will be very clean

        Builder builder = new Builder();
        builder.setFirstName("Satya");
        builder.setLastname("mishra");
        builder.setAge(35);
        builder.setEmail("Satya@xyz.com");
        builder.setPassword("SatyaXYZ");

        User5 user5 = new User5(builder);
        System.out.println(user5);

    }
}
