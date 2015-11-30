/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.Event;
import data.EventDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author William Reithmeyer
 */
public class administrators extends HttpServlet {
    HttpSession session;  
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        
        session = request.getSession();
        String requestURI = request.getRequestURI();
        String url = "/admin/index.jsp";
        if (requestURI.endsWith("/logout")) {
            url = "/admin/logout.jsp";
        } else if (requestURI.endsWith("/deleteEvent")) {
            url = deleteEvent(request, response);
            ;
        } else if (requestURI.endsWith("/pictures")) {
            url = "/pictures.jsp";
        } 
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        session = request.getSession();
        String requestURI = request.getRequestURI();
        String url = "/adminindex.jsp";
        if (requestURI.endsWith("/addEvent")) {
            url = addEvent(request, response);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String addEvent(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        
        String title        = request.getParameter("event_title");
        String description  = request.getParameter("event_desc");
        String imageURL     = request.getParameter("event_featImage");
        String user         = request.getRemoteUser();
        Date date           = new Date();
        String dateS        = date.toString();
        
        Event event = new Event();
        
        event.setCreator(user);
        event.setDate(dateS);
        event.setDescription(description);
        event.setTitle(title);
        event.setFeaturingImage("");
        
        EventDB.insert(event);
        
        return "/admin/";
    }

    private String deleteEvent(HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("eventId"));
        session.setAttribute("event", EventDB.selectEvent(id));
        
        
        return "/admin/deleteEvent.jsp";
    }
}
