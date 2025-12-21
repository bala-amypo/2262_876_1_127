package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleEchoServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);

}