package com.example.Quiz.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByUserpassword", query = "SELECT u FROM User u WHERE u.userpassword = :userpassword"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByUserscore", query = "SELECT u FROM User u WHERE u.userscore = :userscore")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "username")
    private String username;
    @Column(name = "userpassword")
    private String userpassword;
    @Column(name = "email")
    private String email;
    @Column(name = "userscore")
    private Integer userscore;
    @JoinColumn(name = "userrole", referencedColumnName = "roleid")
    @ManyToOne (fetch = FetchType.EAGER)
    @JsonBackReference
    private Role userrole;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.userpassword = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserscore() {
        return userscore;
    }

    public void setUserscore(Integer userscore) {
        this.userscore = userscore;
    }

    public Role getUserrole() {
        return userrole;
    }

    public void setUserrole(Role role) {
        this.userrole = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "userid=" + userid + " username=" + username + " email=" + email;
    }

}
