package cz.jakvitov.websecimpl.security;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import cz.jakvitov.websecimpl.persistence.entity.WebSecUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * User details class to get user information for security
 */

public class WebSecUserDetails implements UserDetails {

    private String name;
    private String password;
    private List<WebSecUserRole> userRoles;


    public WebSecUserDetails(WebSecUser webSecUser){
        this.name = webSecUser.getWebSecUserName();
        this.password = webSecUser.getWebSecUserPassword();
        this.userRoles = webSecUser.getUserRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for (WebSecUserRole i : this.userRoles){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(i.getUserRole().getRoleString()));
        }
        return grantedAuthoritySet;
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
