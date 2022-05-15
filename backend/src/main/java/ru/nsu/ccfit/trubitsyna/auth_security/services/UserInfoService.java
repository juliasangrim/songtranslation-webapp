package ru.nsu.ccfit.trubitsyna.auth_security.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.nsu.ccfit.trubitsyna.model.User;
import ru.nsu.ccfit.trubitsyna.repo.UserRepository;

@Service
public class UserInfoService implements UserDetailsService {
    
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));
		return ru.nsu.ccfit.trubitsyna.auth_security.userinfo.UserInfo.build(user);
	}
}