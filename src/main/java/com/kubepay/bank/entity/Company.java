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
@Table(name = "tbl_company")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Company extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 5888521454601280644L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="companySequence")
    @SequenceGenerator(name="companySequence", sequenceName="sequence_company")
    private Long id;

    @Column(name="company", nullable=false, length = 32)
    private String company;

    @Column(name="phone", nullable=false, length = 32)
    private String phone;

    @Column(name="email", nullable=false, length = 32)
    private String email;

    @Column(name="contact_title", nullable=false, length = 32)
    private String contactTitle;

}
