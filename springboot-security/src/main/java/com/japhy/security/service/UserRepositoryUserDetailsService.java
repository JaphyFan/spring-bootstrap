package com.japhy.security.service;

import com.japhy.security.model.User;
import com.japhy.security.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2021/1/4 13:14
 */
@Service
@RequiredArgsConstructor
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUserName = userRepository.findByUserName(username);
        return byUserName.map(user -> {
            List<GrantedAuthority> grantedAuthorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
            user.setAuthorityList(grantedAuthorities);
            return user;
        }).orElseThrow(
            () -> new UsernameNotFoundException("username=" + username + " is not found"));
    }
}
