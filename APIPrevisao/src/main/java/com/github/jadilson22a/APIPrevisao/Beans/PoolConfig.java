package com.github.jadilson22a.APIPrevisao.Beans;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PoolConfig {
    
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driverClassName}")
    String driver;

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(3);
        config.setMinimumIdle(1);
        config.setIdleTimeout(600000); // 10 minuto
        config.setConnectionTimeout(300000); // 5 minutos
        config.setMaxLifetime(1800000); // 30 minutos
        config.setPoolName("pool-previsao");

        return new HikariDataSource(config);
    }
}
