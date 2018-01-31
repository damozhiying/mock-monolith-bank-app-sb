package com.kubepay.bank.entity.security;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_role")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Role extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -6750802995353751149L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="roleSequence")
    @SequenceGenerator(name="roleSequence", sequenceName="sequence_role")
    private Long id;

    @ManyToMany
    @JoinTable(name = "tbl_roles_privileges",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    @Column(name="role", unique=true, nullable=false, length=16)
    private String name;

    @Column(name="description", length=1024)
    private String description;

    @Column(name="enabled", nullable=false)
    private boolean enabled;

    public Role(final String name) {

        this.name = name;
        this.enabled = true;
    }

}
