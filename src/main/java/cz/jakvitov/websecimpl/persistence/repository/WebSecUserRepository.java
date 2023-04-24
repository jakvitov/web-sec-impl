package cz.jakvitov.websecimpl.persistence.repository;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebSecUserRepository extends JpaRepository<WebSecUser, Long> {

    @Query("select new WebSecUser(w.id, w.name, w.password) from WebSecUser w where w.name=?1")
    List<WebSecUser> findByName(String name);

}
