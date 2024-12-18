package com.example.zagMProject;

import com.example.zagMProject.model.User;

import java.util.List;

public interface Feature {
    public void Create(User user);
    public void Update(User user, int id);
    public User GetUserDetails(int id);
    public void Delete(int id);
    public List<User> Filter(String status,String role);
    public List<User> GetAllUsers();
}
