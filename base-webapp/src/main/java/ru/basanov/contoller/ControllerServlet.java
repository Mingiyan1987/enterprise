package ru.basanov.contoller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "сontroller", urlPatterns = {"/", "/catalog"})
public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        String path = request.getServletPath();
        if (path.equals("/")){
            url +="index.jsp";
        } else if (path.equals("/catalog")){
            url +="catalog.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
