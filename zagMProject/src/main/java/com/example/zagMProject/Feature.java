package com.example.zagMProject;

import com.example.zagMProject.model.User;

import java.util.List;

public interface Feature {
    public void Create(User user);
    public void Update(User user, int id);
    public User GetUserDetails(int id);
    public void Delete(String name);
    public List<User> Filter(User user);
}
