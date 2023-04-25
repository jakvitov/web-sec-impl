package cz.jakvitov.websecimpl.security;

import cz.jakvitov.websecimpl.persistence.exceptions.UserNotFoundExeption;
import cz.jakvitov.websecimpl.persistence.service.WebSecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserDetailsLoaderService implements UserDetailsService {

    @Autowired
    WebSecUserService webSecUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return new WebSecUserDetails(webSecUserService.getUserByName(username));
        }
        catch (UserNotFoundExeption userNotFoundExeption){
            throw new UsernameNotFoundException(userNotFoundExeption.getMessage());
        }
    }
}
