package com.example.zagMProject.service;


import com.example.zagMProject.Feature;
import com.example.zagMProject.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements Feature {
    private List<User> users = new ArrayList<>();

    @Override
    public void Create(User user) {
        users.add(user);
    }

    @Override
    public void Update(User user , int id) {
        boolean isupdated =false;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUserId()==id){
                users.set(i,user);
                isupdated = true;
                System.out.println("is updated");
                break;
            }

        }
    }

    @Override
    public User GetUserDetails(int id) {
        boolean isfounded =false;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUserId()==id){

                isfounded = true;
                id = i; // change value of id to index
                break;
            }

        }
        if(!isfounded){
            return users.get(id);
        }
        else {
            return null;}
    }

    @Override
    public void Delete(String name) {
        boolean isdeleted = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserFullName().equals(name)) {
                users.remove(users.get(i));
                isdeleted = true;
                System.out.println("is Deleted");
                break;
            }
        }
    }

    @Override
    public List<User> Filter(User user) {

        return List.of();
    }
}


