package cz.jakvitov.websecimpl.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

/**
 * Entity representing a user in the database
 */
@Entity
@Table(name = "web_sec_user")
public class WebSecUser{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "web_sec_user_id")
    private Long webSecUserId;

    @Column(unique = true, name = "web_sec_user_name", nullable = false)
    private String webSecUserName;

    @Column(name = "web_sec_user_password")
    private String webSecUserPassword;

    @OneToMany(mappedBy = "webSecUser")
    private List<WebSecUserRole> userRoles;

    public WebSecUser() {
    }

    public WebSecUser(Long webSecUserId, String webSecUserName, String webSecUserPassword, List<WebSecUserRole> userRoles) {
        this.webSecUserId = webSecUserId;
        this.webSecUserName = webSecUserName;
        this.webSecUserPassword = webSecUserPassword;
        this.userRoles = userRoles;
    }

    public Long getWebSecUserId() {
        return webSecUserId;
    }

    public void setWebSecUserId(Long webSecUserId) {
        this.webSecUserId = webSecUserId;
    }

    public String getWebSecUserName() {
        return webSecUserName;
    }

    public void setWebSecUserName(String webSecUserName) {
        this.webSecUserName = webSecUserName;
    }

    public String getWebSecUserPassword() {
        return webSecUserPassword;
    }

    public void setWebSecUserPassword(String webSecUserPassword) {
        this.webSecUserPassword = webSecUserPassword;
    }

    public List<WebSecUserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<WebSecUserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "WebSecUser{" +
                "webSecUserId=" + webSecUserId +
                ", webSecUserName='" + webSecUserName + '\'' +
                ", webSecUserPassword='" + webSecUserPassword + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
