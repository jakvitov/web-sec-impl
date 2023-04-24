package cz.jakvitov.websecimpl.persistence.service;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import cz.jakvitov.websecimpl.persistence.exceptions.UserNotFoundExeption;
import cz.jakvitov.websecimpl.persistence.repository.WebSecUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSecUserServiceImpl implements WebSecUserService{

    @Autowired
    private WebSecUserRepository webSecUserRepository;

    @Override
    public WebSecUser getUserByName(String name) {
        List<WebSecUser> webSecUserList = this.webSecUserRepository.findByName(name);
        if (webSecUserList.size() == 0){
            throw new UserNotFoundExeption("User " + name + " not found");
        }
        else if (webSecUserList.size() > 1) {
            throw new UserNotFoundExeption("Found multiple usernames, critical error");
        }
        else {
            return webSecUserList.get(0);
        }
    }

    @Override
    public WebSecUser saveWebSecUser(WebSecUser webSecUser) {
        return webSecUserRepository.saveAndFlush(webSecUser);
    }

    @Override
    public void deleteUserByName(String userName) {
        webSecUserRepository.delete(this.getUserByName(userName));
    }
}
