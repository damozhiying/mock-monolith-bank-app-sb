package com.kubepay.bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_branch")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Branch extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 8104478439529554764L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "branchSequence")
    @SequenceGenerator(name = "branchSequence", sequenceName = "sequence_branch")
    private Long id;

    @Column(name = "branch", nullable = false, updatable = false, length = 32)
    private String branch;

    @Column(name = "city", nullable = false, updatable = false, length = 32)
    private String city;

    @Column(name = "country", nullable = false, updatable = false, length = 32)
    private String country;

    @Column(name = "phone", nullable = false, length = 32)
    private String phone;

    @Column(name = "manager", nullable = false)
    private Long manager;

}
