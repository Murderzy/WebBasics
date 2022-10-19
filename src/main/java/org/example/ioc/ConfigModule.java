package org.example.ioc;

import com.google.inject.AbstractModule;
import org.example.services.hash.DataService;
import org.example.services.hash.MysqlDataService;


public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        // Конфигурация служб-поставщиков
        bind(DataService.class).to(MysqlDataService.class) ;


        //
    }
}