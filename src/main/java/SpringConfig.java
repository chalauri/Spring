import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Chalauri-G on 8/20/2017.
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = SpringConfig.class, basePackages = {"ge.chalauri.repositories"})
@ComponentScan(basePackages = {"ge.chalauri.controller", "ge.chalauri.beans", "ge.chalauri.entities"})
@EnableTransactionManagement
@EnableScheduling
public class SpringConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.favorPathExtension(Boolean.TRUE)
                .ignoreAcceptHeader(Boolean.TRUE)
                .useJaf(Boolean.FALSE)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.restDataSource());
        em.setPackagesToScan("ge.chalauri");
        em.setPersistenceUnitName("chalauri");

        // TODO read from file

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
            {
                // String dialect =
                // "org.hibernate.dialect.MySQL5InnoDBDialect";//
                // getConfig("spring.jpa.database-platform");
                String dialect = "org.hibernate.dialect.MySQL5Dialect";
                this.setDatabasePlatform(dialect);
                // this.setDatabasePlatform(dialect);

                this.setShowSql(true);

                // this.setShowSql(true);
                // this.setGenerateDdl(false);

                this.setGenerateDdl(true);

            }
        };

        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource restDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // String driver = "com.mysql.jdbc.Driver";//
        // getConfig("spring.jpa.database-platform");
        // dataSource.setDriverClassName(driver);
        String driver = "com.mysql.jdbc.Driver";
        dataSource.setDriverClassName(driver);

        String url = "jdbc:mysql://localhost:3306/test";
        dataSource.setUrl(url);

        String username = "root";
        dataSource.setUsername(username);

        String password = "root";
        dataSource.setPassword(password);

        return dataSource;
    }


    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());
        transactionManager.setDataSource(this.restDataSource());

        return transactionManager;
    }


}
