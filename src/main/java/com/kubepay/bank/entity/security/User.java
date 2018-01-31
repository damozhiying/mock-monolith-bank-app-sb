package com.kubepay.bank.entity.security;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.AbstractBaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="tbl_user")
@EqualsAndHashCode(callSuper=true)
public class User extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -8200433310546720823L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="userSequence")
    @SequenceGenerator(name="userSequence", sequenceName="sequence_user")
    private Long id;

    @Column(name="user", unique=true, nullable=false, updatable=false, length = 32)
    private String userName;

    @Column(name="password", nullable=false, length = 32)
    private String password;

    @Column(name="enabled", nullable=false)
    private boolean enabled;

    @Column(name="account_non_expired", nullable=false)
    private boolean accountNonExpired;

    @Column(name="account_non_locked", nullable=false)
    private boolean accountNonLocked;

    @Column(name="credentials_non_expired", nullable=false)
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_users_roles",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
        this.enabled = false;
        this.accountNonExpired=false;
        this.accountNonLocked=false;
        this.credentialsNonExpired=false;
    }

    public User(final String userName, final String password) {
        this.userName = userName;
        this.password = password;
        this.enabled = false;
        this.accountNonExpired=false;
        this.accountNonLocked=false;
        this.credentialsNonExpired=false;
    }



}