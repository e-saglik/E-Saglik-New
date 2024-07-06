
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // Allow requests from localhost
        response.setHeader("Access-Control-Allow-Origin", "http://localhost");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "3600");

        // Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        // Cleanup code, if needed
    }

    @Override
    public boolean accept(Object entry) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}















///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package filter;
//
//import Entity.User;
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// *
// * @author zafer
// */
//@WebFilter("/*")
//public class LoginFilter implements Filter{
//
//    @Override
//    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
////        HttpServletRequest req =(HttpServletRequest) sr;
////        HttpServletResponse res =(HttpServletResponse) sr1;
////        
////        String url = req.getRequestURI();
////        
////        User u = (User) req.getSession().getAttribute("valid_user");
////        
////        if(u == null){
////            if(url.contains("doctor")){
////               res.sendRedirect(req.getContextPath() + "/login.xhtml");
////            }
////            else{
////                fc.doFilter(sr, sr1);
////            }
////        }
////        else{
////            if( url.contains("doctor")){
////                res.sendRedirect(req.getContextPath() + "/index.xhtml");
////            }
////            else{
////                fc.doFilter(sr, sr1);
////            }
////        }
//    }
//    
//}
