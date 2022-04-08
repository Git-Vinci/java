package cn.steven.springsecuritydemo18902.config;

import cn.steven.springsecuritydemo18902.entity.Account;
import cn.steven.springsecuritydemo18902.entity.Role;
import cn.steven.springsecuritydemo18902.mapper.AccountMapper;
import cn.steven.springsecuritydemo18902.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Account> accounts = accountMapper.queryAccountByName(s);
        int id = accounts.get(0).getId();
        List<Role> roles = roleMapper.queryRolesByAid(id);

        Set<SimpleGrantedAuthority> collect
                = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toSet());
//User(String username, String password, boolean enabled,
// boolean accountNonExpired, boolean credentialsNonExpired,
// boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
        User user =  new User(s, accounts.get(0).getPassword(), true,
                    true, true,
                    accounts.get(0).getState() == 1, collect);
        return user;
    }
}
