package IteratorPattern.basidemo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {



    private List<String> users = new ArrayList<>();


    public InMemoryDatabase() {
        seeder();
    }

    // seeder function are those function which
    // populates initial data in our DB
    public void seeder(){
        for(int i=1; i<2000; i++){
            users.add("User "+i);
        }
    }

    public List<String> getUsers(){
        return users;
    }

    public List<String> getUsersRange(int offset, int limit){
        System.out.println("fetching "+ limit +" users starting at "+offset +"---");
        int end = Math.min(offset + limit, users.size());
        if(offset >= users.size()){
            return List.of();
        }

        return users.subList(offset, end);
    }
}
