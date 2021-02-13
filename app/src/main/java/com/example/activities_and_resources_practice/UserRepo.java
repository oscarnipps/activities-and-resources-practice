package com.example.activities_and_resources_practice;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    public static UserRepo mInstance;

    public static UserRepo getInstance() {
        if (mInstance == null) {
            mInstance = new UserRepo();
        }
        return mInstance;
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("john doe","Male",20));
        users.add(new User("sarah jones","Female",30));
        users.add(new User("richard ken","Male",30));
        users.add(new User("sandra hill","Female",25));
        return users;
    }

}
