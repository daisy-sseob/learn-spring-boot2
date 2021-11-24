package me.sseob.demowebapplication.accunt;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest //@SpringBooTest 를 사용하게 될 경우 모든 Bean을 등록하게 되므로 Postgres database를 사용하게 된다. 
public class AccountRepositoryTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void di() throws SQLException {

		Account account = new Account();
		account.setUsername("sseob");
		account.setPassword("1234");

		Account newAcount = accountRepository.save(account);

		assertThat(account).isNotNull();

		Account byUsername = accountRepository.findByUsername(newAcount.getUsername());
		assertThat(byUsername.getUsername()).isEqualTo("sseob");
		
		Account nullableUsername = accountRepository.findByUsername("sseobbbb");
		assertThat(nullableUsername).isNull();

	}
}