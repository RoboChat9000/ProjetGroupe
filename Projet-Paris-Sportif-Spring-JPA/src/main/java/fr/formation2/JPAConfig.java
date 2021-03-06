package fr.formation2;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.*;
import org.springframework.dao.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:data-source.properties")
@EnableJpaRepositories("DAO_JPA")
public class JPAConfig {

	@Autowired
	private Environment env;

	
	@Bean("dataSource")
	public BasicDataSource dataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl(env.getProperty("sql.url"));
	dataSource.setUsername(env.getProperty("sql.username"));
	dataSource.setPassword(env.getProperty("sql.password"));
	dataSource.setMaxTotal(env.getProperty("sql.maxConnections", Integer.class));
	return dataSource;
	}


	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	emf.setDataSource(dataSource);
	emf.setPackagesToScan("fr.formation.model");
	emf.setJpaVendorAdapter(vendorAdapter);
	emf.setJpaProperties(this.hibernateProperties());
	return emf;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
		}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(emf);
	return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	return new PersistenceExceptionTranslationPostProcessor();
	}
	

}
