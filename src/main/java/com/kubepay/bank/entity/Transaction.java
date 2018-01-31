package com.kubepay.bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.master.Currency;
import com.kubepay.bank.entity.master.TransactionStatus;
import com.kubepay.bank.entity.master.TransactionType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_transaction")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Transaction extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 2502318344410936568L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transactionSequence")
    @SequenceGenerator(name = "transactionSequence", sequenceName = "sequence_transaction")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Account account;

    @Column(name = "trnx_date", nullable = false, updatable = false)
    private ZonedDateTime transactionDate;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private TransactionType transactionType;

    @Column(name = "amount", nullable = false, updatable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private Currency currency;

    @Column(name = "starting_balance", nullable = false, updatable = false)
    private BigDecimal startingBalance;

    @ManyToOne(optional = true)
    @JoinColumn(nullable = false, updatable = false)
    private Payer payer;

    @ManyToOne(optional = true)
    @JoinColumn(nullable = false, updatable = false)
    private Payee payee;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Employee approver;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TransactionStatus transactionStstus;

}
