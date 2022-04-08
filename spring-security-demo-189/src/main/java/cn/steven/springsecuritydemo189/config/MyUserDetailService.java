package cn.steven.springsecuritydemo189.config;

import cn.steven.springsecuritydemo189.entity.Account;
import cn.steven.springsecuritydemo189.entity.Role;
import cn.steven.springsecuritydemo189.mapper.AccountMapper;
import cn.steven.springsecuritydemo189.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Account> accounts = accountMapper.queryAccountByUserName(s);
        //判断
        if(accounts== null || accounts.size() ==0){
            return null;
        }
        Account account = accounts.get(0);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = roleMapper.queryRolesByAid(account.getId());

        Set<String> collect =
                roles.stream().map(role -> role.getRoleName()).collect(Collectors.toSet());
        collect.forEach(roleName->{
            authorities.add(new SimpleGrantedAuthority(roleName));
        });

        return new User(s,account.getPassword(),authorities);
    }
}
