package cz.jakvitov.websecimpl.security;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import cz.jakvitov.websecimpl.security.roles.UserAdminAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * User details class to get user information for security
 */

public class WebSecUserDetails implements UserDetails {

    private String name;
    private String password;


    public WebSecUserDetails(WebSecUser webSecUser){
        this.name = webSecUser.getName();
        this.password = webSecUser.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new UserAdminAuthority(), new UserAdminAuthority());
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
