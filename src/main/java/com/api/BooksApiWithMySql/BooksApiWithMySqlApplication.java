package com.api.BooksApiWithMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@SpringBootApplication
//@EnableJpaRepositories("com.api.BooksApiWithMySql.repository")
//@ComponentScan
// Specify the package where your repository is located
//@EntityScan("com.api.BooksApiWithMySql.models")
public class BooksApiWithMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApiWithMySqlApplication.class, args);
    }

}
