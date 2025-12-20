package com.example.demo.servlet;

public class SimpleEchoServlet{
    public void doGet(
        org.springframework.mock.web.MockHttpServletRequest request,
        org.springframework.mock.web.MockHttpServletResponse response
) {
    response.setStatus(200);
}

}