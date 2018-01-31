package com.kubepay.bank.entity.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.AbstractBaseMaster;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_transaction_status")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class TransactionStatus extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = -4064816015916749150L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transactionStatusSequence")
    @SequenceGenerator(name = "transactionStatusSequence", sequenceName = "sequence_transaction_status")
    private Long id;

    @Column(name="transaction_status", unique=true, nullable=false, length=32)
    private String transactionStatus;

    public TransactionStatus(final String transactionStatus) {

        this.transactionStatus = transactionStatus;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.transactionStatus;
    }

}
