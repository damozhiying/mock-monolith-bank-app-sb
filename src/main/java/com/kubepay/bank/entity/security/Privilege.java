package com.kubepay.bank.entity.security;

import java.io.Serializable;

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

@Entity
@Data
@Table(name = "tbl_privilege")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Privilege extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 2577880145103697959L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "privilegeSequence")
    @SequenceGenerator(name = "privilegeSequence", sequenceName = "sequence_privilege")
    private Long id;

    @Column(name="privilege", unique=true, nullable=false, length=32)
    private String name;

    @Column(name="description", length=1024)
    private String description;

    @Column(name="enabled", nullable=false)
    private boolean enabled;

    public Privilege(final String name) {

        this.name = name;
        this.enabled = true;
    }

}
