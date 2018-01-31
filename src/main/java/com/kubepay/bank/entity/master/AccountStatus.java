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
@Table(name = "tbl_account_status")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AccountStatus extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = 5335427145144715125L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "accountStatusSequence")
    @SequenceGenerator(name = "accountStatusSequence", sequenceName = "sequence_account_status")
    private Long id;

    @Column(name="account_status", unique=true, nullable=false, length=32)
    private String accountStatus;

    public AccountStatus(final String accountStatus) {

        this.accountStatus = accountStatus;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.accountStatus;
    }

}
