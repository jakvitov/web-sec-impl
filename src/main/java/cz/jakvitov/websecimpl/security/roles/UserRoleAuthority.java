package cz.jakvitov.websecimpl.security.roles;

import org.springframework.security.core.GrantedAuthority;

public class UserRoleAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "USER";
    }
}
