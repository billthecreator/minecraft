/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.imgscalr.Scalr;
/**
 *
 * @author William Reithmeyer
 */
public class pages extends HttpServlet {

    
    
    HttpSession session;  
    
    
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        String ip = getIP();
        String online = "Offline";
        
//        if (pingIP()) {online = "Online";}
        
        ArrayList<String> pictures = getPictures();
        ArrayList<String> pictureThumbs = getPictureThumbs(pictures);
        
        session = request.getSession();
        session.setAttribute("ip", ip);
        session.setAttribute("online", online);
        
        String requestURI = request.getRequestURI();
        String url = "/index.jsp";
        if (requestURI.endsWith("/map")) {
            url = "/map.jsp";
        } else if (requestURI.endsWith("/rules")) {
            url = "/rules.jsp";
        } else if (requestURI.endsWith("/pictures")) {
            session.setAttribute("pictures", pictures);
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
        String url = "/admin";
        if (requestURI.endsWith("/updateProduct")) {
        } else if (requestURI.endsWith("/deleteProduct")) {
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String getIP() {
        String ip = "error";
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            Scanner in = new Scanner(whatismyip.openStream());
            ip = in.next();
        } catch (MalformedURLException ex) {
            Logger.getLogger(pages.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pages.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // debug
//        ip = "127.0.0.1";
        
        return ip;
    }

    private boolean pingIP() throws IOException {
        Socket socket = null;
        boolean reachable = true;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(getIP(), 8080), 500);
        } catch (SocketTimeoutException e){
            reachable = false;
        } finally {            
            if (socket != null) try { socket.close(); } catch(IOException e) {
            reachable = false;}
        }
        return reachable;
    }
    
    private ArrayList<String> getPictures() {
        
        ArrayList<String> pictureList = new ArrayList<String>();
        String sFile;
        
        File folder = new File(getServletContext().getRealPath("/pictures/"));
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                
                sFile = fileEntry.getName();
                pictureList.add(sFile);
                System.out.println(sFile);
            }
        }
                System.out.println("--");
        return pictureList;
    }

    private ArrayList<String> getPictureThumbs(ArrayList<String> pictures) throws IOException {
        for(String item : pictures){
            
            String thumb = getServletContext().getRealPath("/pictures/thumbs/") + "\\" + item;
            System.out.println(thumb);
            String orig = getServletContext().getRealPath("/pictures/") + "\\" + item;
            System.out.println(orig);

            
            if (!new File(thumb).exists()) {
                try {
                    
                    BufferedImage img = ImageIO.read(new File(orig)); 
                    BufferedImage dstImg = Scalr.resize(img, 300); 
                    ImageIO.write(dstImg, "png", new File(thumb));
                      
                } catch (NullPointerException e) {
                    
                    System.out.println("error");
                }

            }
        }
        return null;
    }
}
