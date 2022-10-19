package org.example.filtres;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.services.hash.DataService;
import org.example.services.hash.MysqlDataService;


import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class DataFilter  implements Filter {
    //private final DataService dataService ;
    private FilterConfig filterConfig ;
   // @Inject
   // public DataFilter( DataService dataService ) {
       // this.dataService = dataService ;
   // }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig ;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        DataService dataService = new MysqlDataService() ;
        if( dataService.getConnection() == null ) {
            servletRequest.getRequestDispatcher( "WEB-INF/static.jsp" )
                    .forward( servletRequest, servletResponse ) ;
        }
        else {
            Connection connection = dataService.getConnection();
            String sql = "SELECT * FROM randoms";
            ArrayList<String> str = new ArrayList<String>();
            ResultSet res;
            try (Statement statement = connection.createStatement()) {
                 res = statement.executeQuery(sql);

                while (res.next()) {
                    System.out.printf("%d %d %s %n", res.getLong(1),
                            res.getInt(2), res.getString("str"));
                    str.add(res.getString("str"));
                }
                ;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println(sql);
                return;
            }

            servletRequest.setAttribute("str",str);
            servletRequest.setAttribute( "DataService", dataService ) ;
            filterChain.doFilter( servletRequest, servletResponse ) ;
        }
    }
    // Реализовать фильтр подключения к БД
    // Обеспечить переход на статическую страницу если нет подключения
    // На стартовой странице вывести данные о кол-ве записей в БД
    //  (любая таблица для примера). * - вывести данные из таблицы.

    public void destroy() {
        this.filterConfig = null ;
    }
}