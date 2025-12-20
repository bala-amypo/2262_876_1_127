package com.example.demo.servlet;

    import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class SimpleEchoServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
        response.setStatus(HttpServletResponse.SC_OK);
    } catch (Exception e) {
    }
}

}