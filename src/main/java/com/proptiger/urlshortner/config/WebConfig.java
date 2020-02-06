package com.proptiger.urlshortner.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.proptiger")
@EnableJpaRepositories(basePackages= {"com.proptiger"})

public class WebConfig {
	@Bean
    public EntityManagerFactory entityManagerFactory(){
        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(createJPAAdapter());
        factory.setDataSource(dataSource());
        factory.setPersistenceProviderClass(HibernatePersistence.class);
        factory.setPackagesToScan("com.proptiger");
        factory.setJpaProperties(createJPAProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
    @Bean
    public JpaTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
    
    private Properties createJPAProperties() {
        Properties properties = new Properties();
        return properties;
    }
    private HibernateJpaVendorAdapter createJPAAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter
                .setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(org.springframework.orm.jpa.vendor.Database.MYSQL);
        return vendorAdapter;
    }
    
     @Bean 
        public HibernateExceptionTranslator hibernateExceptionTranslator(){ 
          return new HibernateExceptionTranslator(); 
        }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306");
        dataSource.setUsername("Mudra");
        dataSource.setPassword("Mudrads13@");
        return dataSource;
    
}
}
