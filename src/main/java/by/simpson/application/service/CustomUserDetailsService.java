package by.simpson.application.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.simpson.application.dao.UserDAO;
import by.simpson.application.entity.Role;
import javax.swing.JOptionPane;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserDAO userDAO;

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        by.simpson.application.entity.User domainUser = userDAO.getUser(login);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRoles())
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> list) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(list));
        return authList;
    }

    public List<String> getRoles(List<Role> list) {

        List<String> roles = new ArrayList<String>();

        for (Role role : list) {
            System.out.println("!            !" + role.getRole());
            roles.add(role.getRole());
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
