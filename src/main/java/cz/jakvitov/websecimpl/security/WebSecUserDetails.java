package cz.jakvitov.websecimpl.security;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * User details class to get user information for security
 */

public class WebSecUserDetails implements UserDetails {

    private String name;
    private String password;
    private UserRole userRoles;


    public WebSecUserDetails(WebSecUser webSecUser){
        this.name = webSecUser.getWebSecUserName();
        this.password = webSecUser.getWebSecUserPassword();
        this.userRoles = webSecUser.getWebSecUserRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.userRoles.getRoleString()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
