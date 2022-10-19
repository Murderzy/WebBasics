package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/servlet")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        //res.getWriter().print("<h1>Сервлет работает</h1>");
        HttpSession session = req.getSession();
        String userInput = (String)session.getAttribute("userInput");
        req.setAttribute("userInput",userInput);
        if(userInput != null)
        {
            session.removeAttribute("userInput");
        }
        req.getRequestDispatcher("WEB-INF/servlets.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // При наличие параметов, передаваемых формой, они становятся доступными
        // через req.getParameter
        // !!! до первого чтения из req необходимо указать кодировку
        req.setCharacterEncoding("UTF-8");
        String userInput = req.getParameter("userInput");
        //req.setAttribute("userInput",userInput); -- при редиректе будет бесполезно
        req.getSession().setAttribute("userInput",userInput);  //  сессия хранит данные между запросами
        res.sendRedirect(req.getRequestURI());
    }
}


/*
HttpServlet по своему принципу напоминает ApiController (ASP)
 */