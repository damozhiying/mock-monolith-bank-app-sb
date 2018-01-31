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
@Table(name = "tbl_customer_type")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class CustomerType extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = 6114471540674446579L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customerTypeSequence")
    @SequenceGenerator(name = "customerTypeSequence", sequenceName = "sequence_customer_type")
    private Long id;

    @Column(name="customer_type", unique=true, nullable=false, length=32)
    private String customerType;

    public CustomerType(final String customerType) {

        this.customerType = customerType;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.customerType;
    }

}
