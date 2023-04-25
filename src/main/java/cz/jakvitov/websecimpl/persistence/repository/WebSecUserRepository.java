package cz.jakvitov.websecimpl.persistence.repository;

import cz.jakvitov.websecimpl.persistence.entity.WebSecUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebSecUserRepository extends JpaRepository<WebSecUser, Long> {
    Optional<WebSecUser> findWebSecUserByWebSecUserName(String websecUserUserName);

    @Transactional
    void deleteByWebSecUserName(String userName);
}
