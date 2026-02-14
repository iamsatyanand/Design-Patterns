package SOLIDPrinciples.SingleResponsibilityPrinciple.Question1;

import java.util.List;

public class UserRepository {

    public String createUser(User user){
        // db logic
        return "User added successfully";
    }

    public List<User> getAllUsers(){
        // db logic
        return List.of();
    }
}
