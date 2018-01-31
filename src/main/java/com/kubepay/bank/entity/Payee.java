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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_payee")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Payee extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 1685549471669641801L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payeeSequence")
    @SequenceGenerator(name = "payeeSequence", sequenceName = "sequence_payee")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    private Account account;

    @Column(name="internal", nullable=false, updatable = false)
    private boolean internal;

}
