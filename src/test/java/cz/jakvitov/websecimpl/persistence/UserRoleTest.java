package cz.jakvitov.websecimpl.persistence;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import cz.jakvitov.websecimpl.persistence.entity.WebSecUserRole;
import cz.jakvitov.websecimpl.persistence.exceptions.UserNotFoundExeption;
import cz.jakvitov.websecimpl.persistence.service.WebSecUserService;
import cz.jakvitov.websecimpl.security.UserRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRoleTest {

    @Autowired
    private WebSecUserService webSecUserService;

    @BeforeAll
    public void setupUser(){
        try {
            webSecUserService.getUserByName("testUser1");
        }
        catch (UserNotFoundExeption UNFE){
            WebSecUser webSecUser = new WebSecUser();
            webSecUser.setWebSecUserName("testUser1");
            webSecUser.setWebSecUserName("password");
            webSecUserService.saveWebSecUser(webSecUser);
        }
    }

    @Test
    public void addTestUserRole(){
        WebSecUser webSecUser = webSecUserService.getUserByName("testUser1");
        WebSecUserRole webSecUserRoleAdmin = new WebSecUserRole();
        WebSecUserRole webSecUserRoleUser = new WebSecUserRole();
        webSecUserRoleAdmin.setUserRole(UserRole.ADMIN);
        webSecUserRoleUser.setUserRole(UserRole.USER);
        WebSecUserRole[] webSecUserRoles = {webSecUserRoleAdmin, webSecUserRoleUser};
        webSecUser.setUserRoles(Arrays.asList(webSecUserRoles));
        webSecUserService.saveWebSecUser(webSecUser);
    }

}
