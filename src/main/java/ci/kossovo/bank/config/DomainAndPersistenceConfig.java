package ci.kossovo.bank.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

	@EnableJpaRepositories(basePackages = { "ci.kossovo.bank.dao"})
	@EnableAutoConfiguration
	@ComponentScan(basePackages = { "ci.kossovo.bank" })
	@EntityScan(basePackages = { "ci.kossovo.bank.entites"})
	@EnableTransactionManagement
	public class DomainAndPersistenceConfig {

		// la source de données MySQL
		@Bean
		public DataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/k-bank_db");
			dataSource.setUsername("root");
			dataSource.setPassword("admin");
			return dataSource;
		}

		@Bean
		public JpaVendorAdapter jpaVendorAdapter() {
			HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
			hibernateJpaVendorAdapter.setShowSql(false);
			hibernateJpaVendorAdapter.setGenerateDdl(false);
			hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
			
			return hibernateJpaVendorAdapter;
		}


	}


