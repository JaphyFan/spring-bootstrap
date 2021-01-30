package com.japhy.bootstrap.web.infrastructure.util;

import com.japhy.bootstrap.web.domain.user.entity.User;
import com.japhy.bootstrap.web.domain.user.repository.UserRepository;
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
 * @since 2021/1/30 14:38
 */
@Service
@RequiredArgsConstructor
public class WebUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUserName = userRepository.findByUserName(username);
        return byUserName.map(user -> {
            List<GrantedAuthority> grantedAuthorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
            user.setGrantedAuthorityList(grantedAuthorities);
            return user;
        }).orElseThrow(
            () -> new UsernameNotFoundException("username=" + username + " is not found"));
    }
}
