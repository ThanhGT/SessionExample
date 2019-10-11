/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.sessionexample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Tran
 */
public class KillSession extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try(PrintWriter out = response.getWriter()){
            
            writeHeaderInfo(out);
            
            String killSession = request.getParameter("killSession");
            
            HttpSession session = request.getSession();
            
            if (killSession != null){
                
                out.print("Session invalidated<br>");
                session.invalidate();
            
            } 
                
                 out.print("<a href = \"index.html\">Back to Index</a>");
           
            
            writeFooterInfo(out);
        }
      
    }

    private void writeHeaderInfo(final PrintWriter out){
        out.print("<!DOCTYPE html");
        out.print("<html>");
        out.print("<head>");
        out.print("<title></title>");
        out.print("</head>");
        out.print("<body>");
    }
    
    private void writeFooterInfo(final PrintWriter out){
        out.print("</body>");
        out.print("</html>");
    }
        
}
