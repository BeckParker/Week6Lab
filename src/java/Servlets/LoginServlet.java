/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import JavaBeans.User;
import Utilities.CookieUtil;
import Utilities.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 679810
 */
public class LoginServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String name = "";
        String action = request.getParameter("action");
        
        if (cookies != null){
            for (Cookie cookie: cookies){
                if (cookie.getName().equals("name")){
                    name = cookie.getValue();
                    request.setAttribute("username", name);
                    request.setAttribute("isChecked", "checked");
                } else {
                    request.setAttribute("isChecked", "");
                }
            }
            
        } 
        
        if (action != null) {
            if (action.equals("logout")){
                session.setAttribute("user", null);
                request.setAttribute("success", "You have been successfully logged out");
            } 
        }
        
        if (session.getAttribute("user") != null){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean checked = false;
        HttpSession session = request.getSession();
        String checkBox = request.getParameter("rememberme");
        
        if (request.getParameter("rememberme") != null) {
            checked = true;
        } 
        
        User user = UserService.login(username, password);
        
        if (user == null) {
            request.setAttribute("errorMessage", "Invalid username or password.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            if (checked == true) {
                Cookie c = new Cookie("name", username);
                c.setMaxAge(60 * 60 * 24 * 365 * 2); 
                c.setPath("/");                      
                response.addCookie(c);
            } else {
                Cookie c = CookieUtil.removeCookie(request.getCookies(), "name");
                if (c != null) {
                response.addCookie(c);
                }
            }
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }
    }

}
