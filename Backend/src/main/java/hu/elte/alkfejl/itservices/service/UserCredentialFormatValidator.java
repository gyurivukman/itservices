/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.itservices.service;

/**
 *
 * @author simon
 */
public class UserCredentialFormatValidator {

    public static boolean validateUserNameFormat(String username){
        return username.matches("^[a-zA-Z]{5,20}$");
    }
    
    public static boolean validatePasswordFormat(String password){
        boolean hasUppercase = password.matches(".*[A-Z]+.*");
        boolean hasNumber = password.matches(".*[0-9]+.*");
        boolean correctLength = password.matches("^[a-zA-Z0-9]{5,20}$");
        return hasUppercase && hasNumber && correctLength;
    }
    
    public static boolean validateEmailFormat(String email){
        return email.matches("[a-z\\-\\_0-9\\.]+@[a-z\\-]+\\.[a-z]{3}");
    }
    
    public static boolean validateEmployeeIdFormat(String employeeid){
        return employeeid.matches("[0-9]{8}");
    }
}
