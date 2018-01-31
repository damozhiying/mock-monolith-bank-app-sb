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
@Table(name = "tbl_transaction_type ")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class TransactionType extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = 2179551340465108021L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transactionTypeSequence")
    @SequenceGenerator(name = "transactionTypeSequence", sequenceName = "sequence_transaction_type")
    private Long id;

    @Column(name="transaction_type", unique=true, nullable=false, length=32)
    private String transactionType;

    public TransactionType(final String transactionType) {

        this.transactionType = transactionType;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.transactionType;
    }


}
