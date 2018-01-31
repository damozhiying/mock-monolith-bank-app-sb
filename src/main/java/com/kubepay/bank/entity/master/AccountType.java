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
@Table(name = "tbl_account_type")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AccountType extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = -5039224465293120635L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "accountTypeSequence")
    @SequenceGenerator(name = "accountTypeSequence", sequenceName = "sequence_account_type")
    private Long id;

    @Column(name="account_type", unique=true, nullable=false, length=32)
    private String accountType;

    public AccountType(final String accountType) {

        this.accountType = accountType;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.accountType;
    }

}
