package cz.jakvitov.websecimpl.persistence.service;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;

public interface WebSecUserService {

    WebSecUser getUserByName(String name);

    WebSecUser saveWebSecUser(WebSecUser webSecUser);

    void deleteUserByName(String webSecUser);

}
