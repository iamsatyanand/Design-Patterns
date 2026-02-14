package IteratorPattern.basidemo.services;

import IteratorPattern.basidemo.iterators.Iterator;
import IteratorPattern.basidemo.iterators.UserIterator;
import IteratorPattern.basidemo.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    private final Iterator<List<String>> userIterator;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userIterator = new UserIterator(userRepository, 10);
    }

    public void getUsersOnPlatform(){
//        this.userRepository.findUsers(10,1);
        while(userIterator.hasNext()){
            List<String> users = userIterator.next();
             System.out.println(users);
        }
    }
}
