package com.example.zagMProject.model;



import jakarta.validation.constraints.*;
import lombok.*;

@Data                    //Create setters, getters and other methods(equals, hashCode, canEqual, toString) for all data fields
@AllArgsConstructor     //Create an argument Constructor(non-default constructor) to create new object in controller
@NoArgsConstructor     //Create a non-argument Constructor(Empty Constructor  ---> default constructor)
public class User {
    @NotNull(message = "Enter valid id")
    private Integer userId;
    @NotNull(message = "Enter valid username")
    @Size(max = 15)
    private String userUsername;
    @NotNull(message = "Enter the password")
    @Size(min = 6)
    private String userPassword;
    @NotNull(message = "Enter valid email")
    @Email
    private String userEmail;
    @NotNull(message = "Enter valid the name")
    @Size(max = 20)
    private String userFullName;
    @NotNull(message = "Enter valid moblie number")
    private String userMobileNumber;
    @NotNull(message = "Enter valid the role")
    private String userRole;
    @NotNull(message = "Enter the gendar")
    private String userGender;
    @NotNull(message = "Enter the status(Active or InActive)")
    private String userStatus;

}
