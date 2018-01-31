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
@Table(name = "tbl_person")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Person extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -2888092042132202193L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="personSequence")
    @SequenceGenerator(name="personSequence", sequenceName="sequence_person")
    private Long id;

    @Column(length = 3)
    private String firstName;

    @Column(length = 3)
    private String lastName;

    @Column(length = 3)
    private String middleName;

    @Column(length = 3)
    private String email;

    @Column(length = 3)
    private String phoneNumber;

    @Column(length = 3)
    private String mobile;

    @Column(length = 3)
    private String ssn;

    @Column(length = 3)
    private String pan;

    @Column(length = 3)
    private String house;

    @Column(length = 3)
    private String street;

    @Column(length = 3)
    private String landMark;

    @Column(length = 3)
    private String city;

    @Column(length = 3)
    private String state;

    @Column(length = 3)
    private String country;

    @Column(length = 3)
    private String pincode;

}
