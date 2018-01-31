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
@Table(name = "tbl_payer")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Payer extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 4752108320487671577L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payerSequence")
    @SequenceGenerator(name = "payerSequence", sequenceName = "sequence_payer")
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(nullable = false, updatable = false)
    private Account account;

    @Column(name="internal", nullable=false, updatable = false)
    private boolean internal;

}
