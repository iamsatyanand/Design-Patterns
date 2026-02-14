package IteratorPattern.basidemo.repositories;

import IteratorPattern.basidemo.InMemoryDatabase;

import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private InMemoryDatabase db;

    public UserRepositoryImpl() {
        this.db = new InMemoryDatabase();
    }

    @Override
    public List<String> findUsers(int limit, int offset) {
        List<String> allUsers = db.getUsers();
        int start = offset;
        int end = Math.min(start + limit, allUsers.size());

        if(start >= allUsers.size()){
            return List.of();
        }

        return allUsers.subList(start, end);
    }

    public List<String> getLimitedUsers(int offset, int limit){
        return db.getUsersRange(offset, limit);
    }
}
