package cz.jakvitov.websecimpl.persistence.service;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import cz.jakvitov.websecimpl.persistence.exceptions.UserNotFoundExeption;
import cz.jakvitov.websecimpl.persistence.repository.WebSecUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebSecUserServiceImpl implements WebSecUserService{

    @Autowired
    private WebSecUserRepository webSecUserRepository;

    @Override
    public WebSecUser getUserByName(String name) throws UserNotFoundExeption {
        Optional<WebSecUser> webSecUser = this.webSecUserRepository.findWebSecUserByWebSecUserName(name);
        webSecUser.orElseThrow(() -> {throw new UserNotFoundExeption("User " + name + " not found");});
        return webSecUser.get();
    }

    @Override
    public WebSecUser saveWebSecUser(WebSecUser webSecUser) {
        return webSecUserRepository.saveAndFlush(webSecUser);
    }

    @Override
    public void deleteUserByName(String userName) {
        webSecUserRepository.deleteByWebSecUserName(userName);
    }
}
