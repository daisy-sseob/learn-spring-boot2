package me.sseob.demowebapplication.accunt;

import javassist.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;


/*
	UserDetailsService type의 Bean이 등록 되어있어야 Spring boot 가 자동 설정해주는 user 정보에게서 자유로워 질 수 있다.
 */
@Service
public class AccountService implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		return account; 
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> byUsername = accountRepository.findByUsername(username);
		Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(account.getUsername(), account.getPassword(), authoritest());
	}

	//권한 심플하게 만듦
	private Collection<? extends GrantedAuthority> authoritest() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
