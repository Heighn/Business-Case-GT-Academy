package nl.getthere.users;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Created by hein.dehaan on 7-10-2016.
 */
public class UserProfile {
    private String userName;
    private String password;
    private String role;
    private SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("student");

    public SimpleGrantedAuthority getGrantedAuthority() {
        return grantedAuthority;
    }

    public void setGrantedAuthority(SimpleGrantedAuthority grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }

    public void changeRole(String role){
        this.grantedAuthority = new SimpleGrantedAuthority(role);
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
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
