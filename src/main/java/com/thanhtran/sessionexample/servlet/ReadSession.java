/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.sessionexample.servlet;

import com.thanhtran.sessionexample.model.City;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Tran
 */
public class ReadSession extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try(PrintWriter out = response.getWriter()){
            
            writeHeaderInfo(out);
            
            String cityName = request.getParameter("cityName");
            String region = request.getParameter("region");
            
            HttpSession session = request.getSession();         
            
            session.setAttribute("cityName", cityName);
            session.setAttribute("region", region);
            
            City city = new City(cityName, region);
            
            city.setCityName(cityName);
            city.setRegion(region);
            
            String readSession = request.getParameter("readSession");
            String createSession = request.getParameter("createSession");
            String killSession = request.getParameter("killSession");
            
            if (readSession != null){

                if (cityName != null){

                    String format = null;
                    format = "City is %s and region is %s<br>";
                    out.println(String.format(format, cityName, region));

                } else {
                    out.print("City is not in session<br>");
                }
                } else {
                     if(createSession != null){
                         RequestDispatcher rd = request.getRequestDispatcher("CreateSession.do");
                         rd.forward(request, response);
                     } 
                     
                     if (killSession != null){
                         RequestDispatcher rd = request.getRequestDispatcher("KillSession.do");
                         rd.forward(request, response);
                     }
                }
            
                out.print("<a href = \"index.html\">Back to Index</a>");
            
            writeFooterInfo(out);
        }
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        doPost(request, response);
        
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
