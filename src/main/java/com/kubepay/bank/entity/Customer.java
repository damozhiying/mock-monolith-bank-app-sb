package com.kubepay.bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.master.CustomerType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_customer")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Customer extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -7167480734041147763L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="customerSequence")
    @SequenceGenerator(name="customerSequence", sequenceName="sequence_customer")
    private Long id;

    @ManyToOne
    @JoinColumn(updatable=false)
    private Person person;

    @ManyToOne
    @JoinColumn(updatable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    private CustomerType cutomerType;

}
