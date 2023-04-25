package cz.jakvitov.websecimpl.persistence.entity;

import cz.jakvitov.websecimpl.security.UserRole;
import jakarta.persistence.*;

/**
 * Entity that represents user roles in the database
 */
@Entity
@Table(name = "web_sec_user_role")
public class WebSecUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "web_sec_user_role_id")
    private Long webSecUserRoleId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "web_sec_user_id")
    private WebSecUser webSecUser;

    public WebSecUserRole() {
    }

    public WebSecUserRole(Long webSecUserRoleId, UserRole userRole, WebSecUser webSecUser) {
        this.webSecUserRoleId = webSecUserRoleId;
        this.userRole = userRole;
        this.webSecUser = webSecUser;
    }

    public Long getWebSecUserRoleId() {
        return webSecUserRoleId;
    }

    public void setWebSecUserRoleId(Long webSecUserRoleId) {
        this.webSecUserRoleId = webSecUserRoleId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public WebSecUser getWebSecUser() {
        return webSecUser;
    }

    public void setWebSecUser(WebSecUser webSecUser) {
        this.webSecUser = webSecUser;
    }


}
