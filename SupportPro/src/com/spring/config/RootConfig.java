package com.spring.config;



import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages="com.repository")
@ImportResource(value={"/config/dataSource.xml","/config/mail.xml"})
public class RootConfig {
	/*
	 * @Bean public LocalSessionFactoryBean
	 * getLocalSessionFactoryBean(DataSource dataSource) {
	 * LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
	 * sfb.setDataSource(dataSource); sfb.setPackagesToScan(new String[] {
	 * "com.domain.**" }); Properties props = new Properties();
	 * props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
	 * sfb.setHibernateProperties(props); return sfb; }
	 */

	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.domain.**");
		return emfb;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager jpaTransactionManager= new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}
	
}
