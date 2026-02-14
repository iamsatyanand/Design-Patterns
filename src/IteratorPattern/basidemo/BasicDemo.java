package IteratorPattern.basidemo;

import IteratorPattern.basidemo.repositories.UserRepositoryImpl;
import IteratorPattern.basidemo.services.UserService;

public class BasicDemo {

    public static void main(String[] args) {

        UserService users = new UserService(new UserRepositoryImpl());
        users.getUsersOnPlatform();

    }
}
