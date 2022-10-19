package org.example.ioc;

import com.google.inject.servlet.ServletModule;
import org.example.servlets.ViewServlet;
import org.example.servlets.FiltersServlet;
import org.example.servlets.HomeServlet;
import org.example.filtres.CharsetFilter;
import org.example.filtres.DataFilter;
import org.example.filtres.DemoFilter;


public class ConfigServlet extends ServletModule {
    @Override
    protected void configureServlets() {
        // Программная замена web.xml - конфигурация фильтров ...
        filter( "/*" ).through( CharsetFilter.class ) ;
        filter( "/*" ).through( DataFilter.class ) ;
        filter( "/*" ).through( DemoFilter.class ) ;

        // ...  и сервлетов
        serve( "/filters" ).with( FiltersServlet.class ) ;
        serve( "/servlet" ).with( ViewServlet.class ) ;
        serve( "/" ).with( HomeServlet.class ) ;

    }
}
