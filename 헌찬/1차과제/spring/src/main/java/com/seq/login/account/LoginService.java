package com.seq.login.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService{
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        var result = accountRepository.findByUserId(userId);

        System.out.println(userId);
        System.out.println(userId);
        System.out.println(result);
        System.out.println(result);

        if(result.isEmpty()) {
            throw new UsernameNotFoundException("user not found");
        }

        var user = result.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("일반"));

        return new User(user.getUserId(), user.getPassword(), authorities);
    }
}
