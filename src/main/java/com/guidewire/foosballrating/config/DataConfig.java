package com.guidewire.foosballrating.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
@MapperScan("com.guidewire.foosballrating.persistence")
public class DataConfig {

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setPassword("");

        // create a table and populate some data
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table games if exists");
        jdbcTemplate.execute("create table games(id NUMERIC, aPlayer1 varchar(255), aPlayer2 varchar(255), bPlayer1 varchar(255), bPlayer2 varchar(255), aScore INTEGER , bScore INTEGER, dateOfGame TIMESTAMP)");
        jdbcTemplate.execute("create table players(id NUMERIC, username varchar(255), gamesWon INTEGER , gamesLost INTEGER, setsWon INTEGER, setsLost INTEGER, rank INTEGER)");
        LocalDateTime dateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        jdbcTemplate.update("INSERT INTO games(aPlayer1, aPlayer2, bPlayer1, bPlayer2, aScore, bScore, dateOfGame) values (?,?,?,?,?,?,?)", "Marcin", "Lukasz", "Anastasiia", "Janusz", 3, 2, dateTime);
        jdbcTemplate.update("INSERT INTO players(username, gamesWon, gamesLost, setsWon, setsLost, rank) values (?,?,?,?,?,?)", "Marcin", 1, 0, 3, 2, 125);

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("org.guidewire.foosballrating.domain");
        sessionFactory.setMapperLocations(ResourcePatternUtils.getResourcePatternResolver(resourceLoader).
                getResources("classpath:com/guidewire/foosballrating/persistence/*.xml"));
        return sessionFactory;
    }
}