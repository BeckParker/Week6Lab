/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import javax.servlet.http.Cookie;

/**
 *
 * @author 679810
 */
public class CookieUtil {
    
    public static Cookie getCookie(Cookie[] cookies, String cookieName){
        Cookie c = null;
        if (cookies != null) {
            for (Cookie cookie: cookies){
                if (cookie.getName().equals(cookieName)){
                    c = cookie;
                }
            }
        }
        return c;
    }
    
    public static Cookie removeCookie(Cookie[] cookies, String cookieName){
        Cookie c = null;
        if (cookies != null) {
            for (Cookie cookie: cookies){
                if (cookie.getName().equals(cookieName)){
                    c = cookie;
                    c.setMaxAge(0);
                    c.setPath("/");
                }
            }
        }
        return c;
    }
    
}
