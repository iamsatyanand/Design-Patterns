package BuilderPattern.Basic;

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
            // 1) so many attributes passed to constructor, there fore we need to remenber the sewuence of parameters
            // 2) adding new parameters becomes headache so client code will be less readable and code will be bloated and unmanageable
            // 3) if we have another non mandatory field where we have to keep validation if added then we have to add that field also in constructor and
                    // we have to pass null for those params which are not required always during object creation
                        // one solution for this is create multiple constructors(constructor overloading) but the problem is
                        // if there are huge amount of parameters then there will be a lot of combinations of constructors
                        // for n params 2^n possible combination which will be extremely unmanageable.
                        // also suppose firstname, lastname, email all of string type and firstname, lastname, password are also of string type then for this we can create on;y one parameters
            // 4) what if we add validation in setter but then we also have the invalid object during the object creation time till setter gets called
        user3.setFirstName("Satya");
    }
}
