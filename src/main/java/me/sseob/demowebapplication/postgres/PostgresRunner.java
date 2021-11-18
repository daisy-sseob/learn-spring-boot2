package me.sseob.demowebapplication.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

@Component
public class PostgresRunner implements ApplicationRunner {

	private final DataSource dataSource;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PostgresRunner(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//try catch with resource
		try(Connection connection = dataSource.getConnection()) {

			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("url: " + metaData.getURL());
			System.out.println("driver name: " + metaData.getDriverName());
			System.out.println("user name: " + metaData.getUserName());

			Statement statement = connection.createStatement();
			
			String delete = "drop table account;";
			statement.execute(delete);
			String sql = "CREATE TABLE ACCOUNT(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (ID));";
			statement.executeUpdate(sql);
		}

		jdbcTemplate.execute("INSERT INTO ACCOUNT VALUES (1,'sseob')");
	}
}
