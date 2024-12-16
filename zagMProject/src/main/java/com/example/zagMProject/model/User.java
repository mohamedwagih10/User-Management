package com.example.zagMProject.model;


import lombok.*;

@Data                    //Create setters, getters and other methods(equals, hashCode, canEqual, toString) for all data fields
@AllArgsConstructor     //Create an argument Constructor(non-default constructor) to create new object in controller
@NoArgsConstructor     //Create a non-argument Constructor(Empty Constructor  ---> default constructor)
public class User {
    private Integer userId;

    private String userUsername;

    private String userPassword;

    private String userEmail;

    private String userFullName;

    private String userMobileNumber;

    private String userRole;

    private String userGender;

    private String userStatus;

}
