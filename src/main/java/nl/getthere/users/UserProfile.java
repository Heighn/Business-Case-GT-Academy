package nl.getthere.users;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

/**
 * Created by hein.dehaan on 7-10-2016.
 */

@Entity
public class UserProfile {
    private Long id;
    private String userName;
    private String password;
    private String passwordHash;
    private String role;
    private SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("student");
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleGrantedAuthority getGrantedAuthority() {
        return grantedAuthority;
    }



    public void setGrantedAuthority(SimpleGrantedAuthority grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }

    public void changeRole(String role){
        this.grantedAuthority = new SimpleGrantedAuthority(role);
    }

    @NotEmpty
    @Transient
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
        this.passwordHash = passwordEncoder.encode(password);
    }

    /* Dit is de feitelijke hash van het password en deze slaan we op */
    @NotEmpty
    public String getPasswordHash() {
        return passwordHash;
    }
    @SuppressWarnings("unused")
    private void setPasswordHash(String hash){
        // wordt gebruikt door hibernate bij ophalen uit db
        this.passwordHash = hash;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
