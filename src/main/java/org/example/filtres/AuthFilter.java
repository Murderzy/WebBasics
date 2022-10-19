package org.example.filtres;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter {
    private FilterConfig filterConfig ;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig ;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        if(req.getMethod().equalsIgnoreCase("POST"))
        {
            String userLogin = req.getParameter("userLogin");
            String userPassword = req.getParameter("userPassword");
            if(userLogin != null && userPassword != null)
            {
                System.out.println(userLogin + " " + userPassword);
                res.sendRedirect(req.getRequestURI());
                return;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        this.filterConfig = null ;
    }
}
