package IteratorPattern.basidemo.iterators;

import IteratorPattern.basidemo.repositories.UserRepository;

import java.util.List;

public class UserIterator implements Iterator<List<String>>{

    private UserRepository userRepository;

    private int limit = 1;
    private int offset = 0;
    private List<String> current;

    public UserIterator(UserRepository userRepository, int limit){
        this.userRepository = userRepository;
        this.limit = limit;
        this.current = this.userRepository.findUsers(limit, offset);
    }

    @Override
    public boolean hasNext() {
        return !current.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> result = current;
        this.offset += limit;
        this.current = userRepository.findUsers(limit, offset);
        return result;
    }
}
