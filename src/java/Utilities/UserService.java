/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import JavaBeans.User;

/**
 *
 * @author 679810
 */
public class UserService {
    
    public static User login(String username, String password){
        User user = null;
        if ((username.equals("adam") || username.equals("betty")) && password.equals("password")){
            user = new User();
            user.setUser(username);
        } 
        return user;
    }
    
    
}
