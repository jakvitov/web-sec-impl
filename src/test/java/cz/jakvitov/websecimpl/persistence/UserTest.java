package cz.jakvitov.websecimpl.persistence;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import cz.jakvitov.websecimpl.persistence.repository.WebSecUserRepository;
import cz.jakvitov.websecimpl.persistence.service.WebSecUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserTest {

    @Autowired
    private WebSecUserRepository webSecUserRepository;

    @Autowired
    private WebSecUserService webSecUserService;

    @Test

    void persistNewUserTestInRepository(){
        WebSecUser webSecUser = new WebSecUser();
        webSecUser.setName("testUser1");
        webSecUser.setPassword("password");

        webSecUserRepository.saveAndFlush(webSecUser);
        webSecUser.setName("testUser2");
        webSecUserService.saveWebSecUser(webSecUser);
    }

    @Test
    void findPersistedUsers(){
        WebSecUser webSecUser1 = webSecUserService.getUserByName("testUser2");
    }

    @Test
    void deletePersistedUsers(){
        webSecUserService.deleteUserByName("testUser2");
    }

}