package com.kubepay.bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.master.AccountStatus;
import com.kubepay.bank.entity.master.AccountType;
import com.kubepay.bank.entity.master.Currency;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_account")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Account extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -7408520889960540470L;

    @Id
    @Column(unique=true, nullable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="accountSequence")
    @SequenceGenerator(name="accountSequence", sequenceName="sequence_account")
    private Long id;

    @Column(name="account", unique=true, nullable=false, updatable=false, length=32)
    private String account;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(nullable = false, updatable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(nullable = false, updatable=false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn( nullable = false, updatable=false)
    private Currency baseCurrency;

    @Column(name="balance", nullable=false, scale=100, precision=2)
    private BigDecimal balance;

    @Column(name="rate", nullable=false, scale=9, precision=2)
    private Double rate;

    @ManyToOne
    @JoinColumn(nullable = false, updatable=false)
    private AccountStatus accountStatus;

}
