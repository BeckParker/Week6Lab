/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 679810
 */
public class Debug extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public int doStartTag() throws JspException {
       HttpServletRequest requestServlet = (HttpServletRequest) pageContext.getRequest();
       String debug = pageContext.getRequest().getParameter("debug");
      /* String query = "";
       
       if(requestServlet.getQueryString() != null)
           query = "?" + requestServlet.getQueryString();*/
       
       if (requestServlet.getServerName().contains("test") 
               || requestServlet.getServerName().equals("localhost")) {
           if (debug != null) {
            return EVAL_BODY_INCLUDE;   
           }
       } else {
            return SKIP_BODY;
       }
        return SKIP_BODY;
    }
    
}
