package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");  //  устанвливаем кодировку
        HttpSession session =  req.getSession();  //  получаем ссылку на сессию

        String userLogin = (String)session.getAttribute("userLogin");  //  получаем атрибуты
        String userName = (String)session.getAttribute("userName");

        req.setAttribute("userLogin",userLogin);
        req.setAttribute("userName",userName);

        if(userName != null || userLogin != null)  //  очищаем сессию
        {
            session.removeAttribute("userName");
            session.removeAttribute("userLogin");
        }
        req.getRequestDispatcher("WEB-INF/reg.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");  //  устанавливаем кодировку

        String userLogin = req.getParameter("userLogin");
        String userName = req.getParameter("userName");

        HttpSession session = req.getSession();  //  получаем сессию
        session.setAttribute("userLogin",userLogin);  //  сохраняем атрибуты в сессию
        session.setAttribute("userName",userName);

        res.sendRedirect(req.getRequestURI());  //  редикрект
    }
}
