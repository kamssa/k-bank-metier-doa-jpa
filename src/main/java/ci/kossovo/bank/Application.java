package ci.kossovo.bank;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import ci.kossovo.bank.entites.Client;
import ci.kossovo.bank.repositories.ClientRepository;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
	SpringApplication.run(Application.class, args);
   /* ClientRepository repository = ctx.getBean(ClientRepository.class);
    repository.save(new Client("Kone"));
    repository.save(new Client("Traore"));
    repository.save(new Client("Diarra"));
    repository.save(new Client("kouadio"));
		*/
	}
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
