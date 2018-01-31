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
@Table(name = "tbl_currency")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Currency extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = 7495715209834703923L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "currencySequence")
    @SequenceGenerator(name = "currencySequence", sequenceName = "sequence_currency")
    private Long id;

    @Column(name="currency", unique=true, nullable=false, length=32)
    private String currency;

    public Currency(final String currency) {

        this.currency = currency;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.currency;
    }

}
