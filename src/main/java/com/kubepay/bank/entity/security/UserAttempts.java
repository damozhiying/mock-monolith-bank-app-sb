package com.kubepay.bank.entity.security;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.AbstractBaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tbl_user_attempts")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserAttempts extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 8942342822343826136L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="userAttemptsSeq")
    @SequenceGenerator(name="userAttemptsSeq", sequenceName="sequence_user_attempts", allocationSize=50)
    private Long id;

    @Column(name="user", unique=true, nullable=false, updatable=false)
    private User user;

    @Column(name="attempts", nullable=false)
    private int attempts;

    @Column(name="lastModified", nullable=false)
    private Date lastModified;

    public UserAttempts(final User user) {

        this.user = user;
        this.attempts = 0;
        this.lastModified = new Date();
    }

}
