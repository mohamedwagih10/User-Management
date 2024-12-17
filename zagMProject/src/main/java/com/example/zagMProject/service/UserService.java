package com.example.zagMProject.service;


import com.example.zagMProject.Feature;
import com.example.zagMProject.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements Feature {
    // arrayaslist make it final cant delete or add
    private List<User> users = new ArrayList<>(Arrays.asList(
        new User(1,"mohamed11","11mmoogg","mohamed@wagih.com","mohamed wagih","0102363466","head","male","active")));

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

        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUserId()==id){


                id = i; // change value of id to index
                break;
            }

        }
        return users.get(id);

    }

    @Override
    public void Delete(String name) {
        boolean isdeleted = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserFullName().equals(name)) {
                users.remove(users.get(i));
                isdeleted = true;
               // System.out.println("is Deleted");
                break;
            }
        }
    }

    @Override
    public List<User> Filter(String status, String role) {

        return users.stream().filter(user -> (status ==null || user.getUserStatus().equalsIgnoreCase(status))&&(role ==null ||user.getUserRole().equalsIgnoreCase(role))).collect(Collectors.toUnmodifiableList());
        // filter the null and what i will pass .equalsIgnoreCase compare without look at capital or small
    }

    @Override
    public List<User> GetAllUsers() {
        return users;
    }
}


